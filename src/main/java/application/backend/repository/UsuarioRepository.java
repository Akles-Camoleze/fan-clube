package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.*;
import application.utils.DateParser;

import java.lang.reflect.Constructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements BaseRepository<Usuario> {
    public UsuarioRepository() {
    }

    @Override
    public Usuario find(Integer id) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Usuario entity) {

    }

    public Usuario findByEmail(String email) {
        return performOperation(connection -> {
            PreparedStatement st;
            try {
                st = connection.prepareStatement("""
                        SELECT `usr`.*, `tp`.*, `ps`.*, `end`.*, `cd`.*
                        FROM `fan_club`.`usuario` as `usr`
                        JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                        JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                        JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                        JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                        WHERE `usr`.`email` = ?;"""
                );
                st.setString(1, email);
                ResultSet result = st.executeQuery();

                System.out.println("Antes");
                if(result.next()) {
                    Cidade cidade = new Cidade();
                    cidade.setId(result.getInt("cd.id"));
                    cidade.setNome(result.getString("cd.nome"));
                    cidade.setUf(result.getString("cd.uf"));

                    Endereco endereco = new Endereco();
                    endereco.setId(result.getInt("end.id"));
                    endereco.setNumero(result.getInt("end.numero"));
                    endereco.setRua(result.getString("end.rua"));
                    endereco.setBairro(result.getString("end.bairro"));
                    endereco.setCidade(cidade);

                    Pessoa pessoa = new Pessoa();
                    pessoa.setEndereco(endereco);
                    pessoa.setId(result.getInt("ps.id"));
                    pessoa.setNome(result.getString("ps.nome"));
                    pessoa.setSobrenome(result.getString("ps.sobrenome"));
                    pessoa.setTelefone(result.getString("ps.telefone"));
                    pessoa.setDataNascimento(DateParser.parseString(result.getString("ps.dataNascimento")));

                    TipoUsuario tipoUsuario = new TipoUsuario();
                    tipoUsuario.setId(result.getInt("tp.id"));
                    tipoUsuario.setNome(result.getString("tp.nome"));

                    Usuario usuario = new Usuario();
                    usuario.setId(result.getInt("usr.id"));
                    usuario.setNome(result.getString("usr.nome"));
                    usuario.setEmail(result.getString("usr.email"));
                    usuario.setSenha(result.getString("usr.senha"));
                    usuario.setPessoa(pessoa);
                    usuario.setTipoUsuario(tipoUsuario);

                    System.out.println(usuario);

                    return usuario;
                }

                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
