package application.backend.repository;

import application.backend.entities.Arquivo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ArquivoRepository implements BaseRepository<Arquivo> {
    public ArquivoRepository() {
    }

    @Override
    public Arquivo get(Integer id) {
        return performOperation(connection -> {
            System.out.println(connection);
            return new Arquivo();
        });
    }

    @Override
    public List<Arquivo> get() {
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
