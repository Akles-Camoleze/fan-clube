package application.backend.repository;

import application.backend.entities.Cidade;

public class CidadeRepository implements BaseRepository<Cidade> {
    public CidadeRepository() {
    }

    @Override
    public Cidade get(Integer id) {
        return null;
    }

    @Override
    public Cidade[] get() {
        return new Cidade[0];
    }

    @Override
    public void save() {

    }
}
