package application.backend.repository;

import application.backend.entities.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioRepository implements BaseRepository<TipoUsuario> {

    public TipoUsuarioRepository() {
    }

    @Override
    public TipoUsuario get(Integer id) {
        return null;
    }

    @Override
    public List<TipoUsuario> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(TipoUsuario entity) {

    }

}
