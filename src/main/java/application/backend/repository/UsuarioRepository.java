package application.backend.repository;

import application.backend.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements BaseRepository<Usuario> {
    public UsuarioRepository() {
    }

    @Override
    public Usuario get(Integer id) {
        return null;
    }

    @Override
    public List<Usuario> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Usuario entity) {

    }

}
