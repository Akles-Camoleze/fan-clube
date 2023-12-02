package application.backend.repository;

import application.backend.entities.Arquivo;

public class ArquivoRepository implements BaseRepository<Arquivo> {
    public ArquivoRepository() {
    }

    @Override
    public Arquivo get(Integer id) {
        return null;
    }

    @Override
    public Arquivo[] get() {
        return new Arquivo[0];
    }

    @Override
    public void save(Arquivo entity) {

    }
}
