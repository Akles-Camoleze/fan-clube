package application.backend.repository;

import application.backend.entities.Cidade;
import application.backend.entities.Endereco;
import application.backend.entities.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaRepository implements BaseRepository<Pessoa> {
    public PessoaRepository() {
    }

    @Override
    public Pessoa find(Integer id)  {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT
                        `ps`.*,
                        `end`.`rua`,
                        `end`.`bairro`,
                        `end`.`numero`,
                        `end`.`idCidade`,
                        `cd`.`nome` as `nomeCidade`,
                        `cd`.`uf` as `uf`
                    FROM `fan_club`.`pessoa` as `ps`
                    JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                    WHERE `ps`.`id` = ?;"""
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(result.getInt("idCidade"));
                cidade.setNome(result.getString("nomeCidade"));
                cidade.setUf(result.getString("uf"));

                Endereco endereco = new Endereco();
                endereco.setId(result.getInt("idEndereco"));
                endereco.setIdCidade(result.getInt("idCidade"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setRua(result.getString("rua"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCidade(cidade);

                Pessoa pessoa = new Pessoa();
                pessoa.setId(result.getInt("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setSobrenome(result.getString("sobrenome"));
                pessoa.setIdEndereco(result.getInt("idEndereco"));
                pessoa.setEndereco(endereco);

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    pessoa.setDataNascimento(sdf.parse(result.getString("dataNascimento")));
                    return pessoa;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            return null;
        });
    }

    @Override
    public List<Pessoa> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Pessoa entity) {

    }
}
