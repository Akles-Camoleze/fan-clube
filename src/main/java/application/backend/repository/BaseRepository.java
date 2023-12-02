package application.backend.repository;

import application.backend.entities.TipoUsuario;

public interface BaseRepository<T> {
    T get(Integer id);

    T[] get();

    void save();
}
