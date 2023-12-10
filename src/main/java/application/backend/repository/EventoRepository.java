package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.dto.EventoReportDTO;
import application.backend.entities.*;
import application.database.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventoRepository extends BaseRepository<Evento> {
    public EventoRepository() {
    }

    @Override
    public Evento find(Integer id) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `env`.*, `end`.*, `cd`.*
                    FROM `fan_club`.`evento` as `env`
                    JOIN `fan_club`.`endereco` as `end` ON `end`.`id` = `env`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`
                    WHERE `env`.`data` > NOW();"""
            );
            return runQuery(st, clazz, new ArrayList<>());
        });
    }

    @Override
    public List<Evento> findAll() {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `env`.*, `end`.*, `cd`.*
                    FROM `fan_club`.`evento` as `env`
                    JOIN `fan_club`.`endereco` as `end` ON `end`.`id` = `env`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`
                    WHERE `env`.`data` > NOW();"""
            );
            ArrayList<Evento> eventos = new ArrayList<>();
            ResultSet result = st.executeQuery();

            while (result.next()) {
                eventos.add(new Evento(result));
            }
            return eventos;
        });
    }

    public List<EventoReportDTO> getSubscriptionReport(Integer year) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT
                    	YEAR(`env`.`data`) AS `year`,
                    	MONTH(`env`.`data`) AS `month`,
                    	COUNT(`env`.`id`) AS `qtdEvento`,
                    	SUM(`env`.`valor`) AS `total`
                    FROM `fan_club`.`evento` as `env`
                    GROUP BY `year`, `month`
                    HAVING (? IS NULL OR `year` = ?);"""
            );
            st.setObject(1, year);
            st.setObject(2, year);
            return runQuery(st, EventoReportDTO.class, new ArrayList<>());
        });
    }

    @Override
    public Evento save(Evento entity) {
        return performOperation((connection -> {
            PreparedStatement st = connection.prepareStatement("""
                            INSERT INTO `fan_club`.`evento` (nome, data, descricao, idEndereco, capacidade, valor)
                            VALUES (?, ?, ?, ?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, entity.getNome());
            st.setTimestamp(2, entity.getData());
            st.setString(3, entity.getDescricao());
            st.setInt(4, entity.getIdEndereco());
            st.setInt(5, entity.getCapacidade());
            st.setBigDecimal(6, entity.getValor());

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
