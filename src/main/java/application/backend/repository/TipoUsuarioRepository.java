package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Endereco;
import application.backend.entities.TipoUsuario;
import application.database.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioRepository extends BaseRepository<TipoUsuario> {

    public TipoUsuarioRepository() {
    }

    @Override
    public TipoUsuario find(Integer id) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT * FROM `fan_club`.`tipoUsuario` as `tp` WHERE `tp`.`id` = ?
                    """
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return new TipoUsuario(result);
            }
            return null;
        });
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
    public List<TipoUsuario> findAll() {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM `fan_club`.`tipoUsuario` as `tp`;");
            ArrayList<TipoUsuario> tiposUsuarios = new ArrayList<>();
            ResultSet result = st.executeQuery();
            while (result.next()) {
                tiposUsuarios.add(new TipoUsuario(result));
            }
            return tiposUsuarios;
        });
    }

    @Override
    public TipoUsuario save(TipoUsuario entity) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    INSERT INTO `fan_club`.`usuario` (nome)
                    VALUES (?)"""
            );
            st.setString(1, entity.getNome());

            if (st.executeUpdate() > 0) {
                ResultSet resultSet = st.getGeneratedKeys();
                if (resultSet.next()) {
                    entity.setId(resultSet.getInt(1));
                }
                DataBase.closeResultSet(resultSet);
                return entity;
            }
            DataBase.closeStatement(st);

            return null;
        });
    }

}
