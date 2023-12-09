package application.backend.services;

import application.backend.entities.TipoUsuario;
import application.backend.repository.TipoUsuarioRepository;

public class TipoUsuarioService extends BaseService<TipoUsuario, TipoUsuarioRepository> {
    public TipoUsuarioService() {
        super(new TipoUsuarioRepository());
    }

}
