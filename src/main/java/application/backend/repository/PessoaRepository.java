package application.backend.repository;

import application.backend.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements BaseRepository<Pessoa> {
    public PessoaRepository() {
    }

    @Override
    public Pessoa get(Integer id) {
        return null;
    }

    @Override
    public List<Pessoa> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Pessoa entity) {

    }
}
