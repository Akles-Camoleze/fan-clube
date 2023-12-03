package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.TipoUsuario;
import application.backend.entities.Usuario;

import java.lang.reflect.Constructor;
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

    public <K extends DataTransferObject> K findByEmail(String email, Class<K> clazz) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `usr`.*, `tp`.`nome` as `nomeTipoUsuario`
                    FROM `fan_club`.`usuario` as `usr`
                    JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                    JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                    WHERE `usr`.`email` = ?;"""
            );
            st.setString(1, email);
            return runQuery(st, clazz);
        });
    }

}
