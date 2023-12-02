package application.backend.repository;

import application.backend.entities.TipoUsuario;

public class TipoUsuarioRepository implements BaseRepository<TipoUsuario> {

    public TipoUsuarioRepository() {
    }

    @Override
    public TipoUsuario get(Integer id) {
        return null;
    }

    @Override
    public TipoUsuario[] get() {
        return new TipoUsuario[0];
    }

    @Override
    public void save() {

    }
}
