package application.backend.repository;

import application.backend.entities.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioRepository implements BaseRepository<Comentario> {
    public ComentarioRepository() {
    }

    @Override
    public Comentario find(Integer id) {
        return null;
    }

    @Override
    public List<Comentario> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Comentario entity) {

    }

}
