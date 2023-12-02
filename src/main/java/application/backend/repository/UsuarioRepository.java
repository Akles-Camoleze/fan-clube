package application.backend.repository;

import application.backend.entities.TipoUsuario;
import application.backend.entities.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public List<Usuario> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Usuario entity) {

    }

    public Usuario findByEmail(String email) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `usr`.*, `tp`.`nome` as `nomeTipoUsuario`
                    FROM `fan_club`.`usuario` as `usr`
                    JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                    JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                    WHERE `usr`.`email` = ?;"""
            );
            st.setString(1, email);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(result.getInt("idTipoUsuario"));
                tipoUsuario.setNome(result.getString("nomeTipoUsuario"));

                Usuario usuario = new Usuario();
                usuario.setTipoUsuario(tipoUsuario);
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setIdTipoUsuario(result.getInt("idTipoUsuario"));
                usuario.setIdPessoa(result.getInt("idPessoa"));

                return usuario;
            }
            return null;
        });
    }

}
