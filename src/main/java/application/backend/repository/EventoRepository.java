package application.backend.repository;

import application.backend.entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventoRepository implements BaseRepository<Evento> {
    public EventoRepository() {
    }

    @Override
    public Evento find(Integer id) {
        return null;
    }

    @Override
    public List<Evento> findAll() {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT
                        `env`.*,
                        `end`.`rua`,
                        `end`.`bairro`,
                        `end`.`numero`,
                        `end`.`idCidade`,
                        `cd`.`uf`,
                        `cd`.`nome` as `nomeCidade`
                    FROM `fan_club`.`evento` as `env`
                    JOIN `fan_club`.`endereco` as `end` ON `end`.`id` = `env`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`"""
            );
            ResultSet result = st.executeQuery();
            List<Evento> data = new ArrayList<>();

            while (result.next()) {
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

                Evento evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setNome(result.getString("nome"));
                evento.setEndereco(endereco);
                evento.setCapacidade(result.getInt("capacidade"));
                evento.setDescricao(result.getString("descricao"));
                evento.setValor(result.getBigDecimal("valor"));

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    evento.setData(sdf.parse(result.getString("data")));
                    data.add(evento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

            return data;
        });
    }

    @Override
    public void save(Evento entity) {

    }
}
