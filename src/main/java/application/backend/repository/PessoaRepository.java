package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.dto.EventoReportDTO;
import application.backend.dto.PessoaReportDTO;
import application.backend.entities.Pessoa;
import application.database.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class PessoaRepository implements BaseRepository<Pessoa> {
    public PessoaRepository() {
    }

    @Override
    public Pessoa find(Integer id)  {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `ps`.*, `end`.*, `cd`.*
                    FROM `fan_club`.`pessoa` as `ps`
                    JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                    WHERE `ps`.`id` = ?;"""
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return new Pessoa(result);
            }
            return null;
        });
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `ps`.*, `end`.*, `cd`.*
                    FROM `fan_club`.`pessoa` as `ps`
                    JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                    WHERE `ps`.`id` = ?;"""
            );
            st.setInt(1, id);
            return runQuery(st, clazz);
        });
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    public List<PessoaReportDTO> getPessoaReport() {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT
                        `ps`.*,
                        `end`.*,
                        `cd`.*,
                        COUNT(`ins`.`id`) AS `qtdInscricao`
                    FROM `fan_club`.`pessoa` AS `ps`
                    JOIN `fan_club`.`endereco` AS `end` ON `end`.`id` = `ps`.`idEndereco`
                    JOIN `fan_club`.`cidade` AS `cd` ON `cd`.`id` = `end`.`idCidade`
                    JOIN `fan_club`.`usuario` AS `usr` ON `usr`.`idPessoa` = `ps`.`id`
                    LEFT JOIN `fan_club`.`inscricao` AS `ins` ON `ins`.`idUsuario` = `usr`.`id`
                    GROUP BY `ps`.`id`;"""
            );
            return runQuery(st, PessoaReportDTO.class, new ArrayList<>());
        });
    }

    @Override
    public List<Pessoa> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Pessoa save(Pessoa entity) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    INSERT INTO `fan_club`.`pessoa` (nome, sobrenome, telefone, dataNascimento, idEndereco)
                    VALUES (?, ?, ?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, entity.getNome());
            st.setString(2, entity.getSobrenome());
            st.setString(3, entity.getTelefone());
            st.setDate(4, new Date(entity.getDataNascimento().getTime()));
            st.setInt(5, entity.getIdEndereco());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
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
