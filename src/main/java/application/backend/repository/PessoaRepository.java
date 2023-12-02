package application.backend.repository;

import application.backend.entities.Pessoa;

public class PessoaRepository implements BaseRepository<Pessoa> {
    public PessoaRepository() {
    }

    @Override
    public Pessoa get(Integer id) {
        return null;
    }

    @Override
    public Pessoa[] get() {
        return new Pessoa[0];
    }

    @Override
    public void save(Pessoa entity) {

    }
}
