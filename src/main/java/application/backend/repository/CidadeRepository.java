package application.backend.repository;

import application.backend.entities.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeRepository implements BaseRepository<Cidade> {
    public CidadeRepository() {
    }

    @Override
    public Cidade get(Integer id) {
        return null;
    }

    @Override
    public List<Cidade> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Cidade entity) {

    }
}
