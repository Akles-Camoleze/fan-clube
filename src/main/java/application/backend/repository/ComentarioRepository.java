package application.backend.repository;

import application.backend.entities.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioRepository implements BaseRepository<Comentario> {
    public ComentarioRepository() {
    }

    @Override
    public Comentario get(Integer id) {
        return null;
    }

    @Override
    public List<Comentario> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Comentario entity) {

    }

}
