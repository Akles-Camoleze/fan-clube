package application.backend.repository;

import application.backend.entities.Inscricao;

public class InscricaoRepository implements BaseRepository<Inscricao> {
    public InscricaoRepository() {
    }

    @Override
    public Inscricao get(Integer id) {
        return null;
    }

    @Override
    public Inscricao[] get() {
        return new Inscricao[0];
    }

    @Override
    public void save(Inscricao entity) {

    }

}
