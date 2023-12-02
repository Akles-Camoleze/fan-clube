package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeRepository implements BaseRepository<Cidade> {
    public CidadeRepository() {
    }

    @Override
    public Cidade find(Integer id) {
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
    public List<Cidade> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Cidade entity) {

    }
}
