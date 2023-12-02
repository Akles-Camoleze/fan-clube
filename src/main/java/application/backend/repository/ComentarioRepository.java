package application.backend.repository;

import application.backend.entities.Comentario;

public class ComentarioRepository implements BaseRepository<Comentario> {
    public ComentarioRepository() {
    }

    @Override
    public Comentario get(Integer id) {
        return null;
    }

    @Override
    public Comentario[] get() {
        return new Comentario[0];
    }

    @Override
    public void save() {

    }
}
