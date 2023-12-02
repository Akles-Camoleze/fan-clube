package application.backend.repository;

import application.backend.entities.Usuario;

public class UsuarioRepository implements BaseRepository<Usuario> {
    public UsuarioRepository() {
    }

    @Override
    public Usuario get(Integer id) {
        return null;
    }

    @Override
    public Usuario[] get() {
        return new Usuario[0];
    }

    @Override
    public void save() {

    }
}
