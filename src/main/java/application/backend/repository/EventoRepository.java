package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.*;
import java.sql.PreparedStatement;
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
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
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
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`
                    WHERE `env`.`data` > NOW();"""
            );
            return runQuery(st, clazz, new ArrayList<>());
        });
    }

    @Override
    public List<Evento> findAll() {
        return null;
    }

    @Override
    public void save(Evento entity) {

    }
}
