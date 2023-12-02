package application.backend.repository;

import application.backend.entities.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository implements BaseRepository<Evento> {
    public EventoRepository() {
    }

    @Override
    public Evento find(Integer id) {
        return null;
    }

    @Override
    public List<Evento> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Evento entity) {

    }
}
