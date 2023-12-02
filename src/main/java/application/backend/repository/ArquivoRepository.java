package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Arquivo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ArquivoRepository implements BaseRepository<Arquivo> {
    public ArquivoRepository() {
    }

    @Override
    public Arquivo find(Integer id) {
        return performOperation(connection -> {
            System.out.println(connection);
            return new Arquivo();
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
    public List<Arquivo> findAll() {
        return performOperation(connection -> {
            System.out.println(connection);
            return new ArrayList<>();
        });
    }

    @Override
    public void save(Arquivo entity) {
        performOperation((Connection connection) -> {});
    }

}
