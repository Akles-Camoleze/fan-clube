package application.backend.repository;

import application.backend.entities.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository implements BaseRepository<Evento> {
    public EventoRepository() {
    }

    @Override
    public Evento get(Integer id) {
        return null;
    }

    @Override
    public List<Evento> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Evento entity) {

    }
}
