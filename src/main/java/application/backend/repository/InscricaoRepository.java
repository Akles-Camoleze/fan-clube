package application.backend.repository;

import application.backend.dto.DataTransferObject;
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
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    @Override
    public List<Inscricao> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Inscricao save(Inscricao entity) {
        return  null;
    }

}
