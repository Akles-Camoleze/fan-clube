package application.backend.services;

import application.backend.entities.TipoUsuario;
import application.backend.repository.TipoUsuarioRepository;

import java.util.List;

public class TipoUsuarioService extends BaseService<TipoUsuario, TipoUsuarioRepository> {
    public TipoUsuarioService() {
        super(new TipoUsuarioRepository());
    }

    public List<TipoUsuario> findAll() {
        return this.repository.findAll();
    }

    public TipoUsuario find(Integer id) {
        return this.repository.find(id);
    }

}
