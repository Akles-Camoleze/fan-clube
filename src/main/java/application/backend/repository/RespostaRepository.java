package application.backend.repository;

import application.backend.entities.Resposta;

public class RespostaRepository implements BaseRepository<Resposta> {
    public RespostaRepository() {
    }

    @Override
    public Resposta get(Integer id) {
        return null;
    }

    @Override
    public Resposta[] get() {
        return new Resposta[0];
    }

    @Override
    public void save(Resposta entity) {
    }

}
