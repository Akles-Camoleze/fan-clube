package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Cidade;
import application.database.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeRepository implements BaseRepository<Cidade> {
    public CidadeRepository() {
    }

    @Override
    public Cidade find(Integer id) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT * FROM `fan_club`.`cidade` as `cd` WHERE `cd`.`id` = ?
                     """
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return new Cidade(result);
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
    public List<Cidade> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Cidade save(Cidade entity) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                            INSERT INTO `fan_club`.`cidade` (nome, uf)
                            VALUES (?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, entity.getNome());
            st.setString(2, entity.getUf());

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
