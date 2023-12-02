package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.dto.EventoEnderecoCidadeDTO;
import application.backend.entities.*;

import java.lang.reflect.Constructor;
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
                    JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`"""
            );
            ResultSet result = st.executeQuery();
            List<K> data = new ArrayList<>();

            try {
                while (result.next()) {
                    Constructor<K> constructor = clazz.getDeclaredConstructor(ResultSet.class);
                    data.add(constructor.newInstance(result));
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

            return data;
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
