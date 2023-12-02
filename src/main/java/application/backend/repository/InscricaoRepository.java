package application.backend.repository;

import application.backend.entities.Inscricao;

import java.util.ArrayList;
import java.util.List;

public class InscricaoRepository implements BaseRepository<Inscricao> {
    public InscricaoRepository() {
    }

    @Override
    public Inscricao find(Integer id) {
        return null;
    }

    @Override
    public List<Inscricao> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Inscricao entity) {

    }

}
