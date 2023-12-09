package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Endereco;
import application.database.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository extends BaseRepository<Endereco> {

    public EnderecoRepository() {
    }

    @Override
    public Endereco find(Integer id) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `end`.*, `cd`.*
                    FROM `fan_club`.`endereco` as `end`
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`
                    WHERE `end`.`id` = ?
                     """
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return new Endereco(result);
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
    public List<Endereco> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Endereco save(Connection connection, Endereco entity) {
        return null;
    }

    @Override
    public Endereco save(Endereco entity) {
        return performOperation((connection -> {
            PreparedStatement st = connection.prepareStatement("""
                            INSERT INTO `fan_club`.`endereco` (rua, numero, bairro, idCidade)
                            VALUES (?, ?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, entity.getRua());
            st.setInt(2, entity.getNumero());
            st.setString(3, entity.getBairro());
            st.setInt(4, entity.getIdCidade());

            if (st.executeUpdate() > 0) {
                ResultSet resultSet = st.getGeneratedKeys();
                if (resultSet.next()) {
                    entity.setId(resultSet.getInt(1));
                }
                DataBase.closeResultSet(resultSet);
                DataBase.closeStatement(st);
                return entity;
            }
            DataBase.closeStatement(st);

            return null;
        }));
    }

}
