package application.backend.repository;

import application.backend.entities.Resposta;

import java.util.ArrayList;
import java.util.List;

public class RespostaRepository implements BaseRepository<Resposta> {
    public RespostaRepository() {
    }

    @Override
    public Resposta find(Integer id) {
        return null;
    }

    @Override
    public List<Resposta> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Resposta entity) {
    }

}
