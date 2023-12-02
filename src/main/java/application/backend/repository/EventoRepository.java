package application.backend.repository;

import application.backend.entities.Evento;

public class EventoRepository implements BaseRepository<Evento> {
    public EventoRepository() {
    }

    @Override
    public Evento get(Integer id) {
        return null;
    }

    @Override
    public Evento[] get() {
        return new Evento[0];
    }

    @Override
    public void save() {

    }
}
