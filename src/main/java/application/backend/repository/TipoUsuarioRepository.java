package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioRepository implements BaseRepository<TipoUsuario> {

    public TipoUsuarioRepository() {
    }

    @Override
    public TipoUsuario find(Integer id) {
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
    public List<TipoUsuario> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(TipoUsuario entity) {

    }

}
