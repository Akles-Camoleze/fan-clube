package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioRepository extends BaseRepository<Comentario> {
    public ComentarioRepository() {
    }

    @Override
    public Comentario find(Integer id) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    @Override
    public List<Comentario> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Comentario save(Comentario entity) {
        return null;
    }

}
