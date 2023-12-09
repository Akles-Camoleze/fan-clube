package application.backend.services;

import application.backend.entities.BaseEntity;
import application.backend.entities.Usuario;
import application.backend.repository.Perform;
import application.backend.repository.PessoaRepository;
import application.backend.repository.TipoUsuarioRepository;
import application.backend.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static application.backend.enums.TipoUsuarioEnum.COMUM;

public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
    private final PessoaService pessoaService;
    private final TipoUsuarioService tipoUsuarioService;

    public UsuarioService() {
        super(new UsuarioRepository());
        this.pessoaService = new PessoaService();
        this.tipoUsuarioService = new TipoUsuarioService();
    }

    public Usuario findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> pessoaService.save(usuario.getPessoa()));
        operations.add(() -> {
            usuario.setIdPessoa(usuario.getPessoa().getId());
            usuario.setIdTipoUsuario(COMUM.getId());
            return this.repository.save(usuario);
        });
        usuario.setPessoa(pessoaService.find(usuario.getIdPessoa()));
        usuario.setTipoUsuario(this.tipoUsuarioService.find(usuario.getIdTipoUsuario()));
        return this.repository.performTransaction(operations);
    }

    public Usuario update(Usuario usuario) {
        usuario.setIdPessoa(usuario.getPessoa().getId());
        usuario.setIdTipoUsuario(usuario.getTipoUsuario().getId());

        this.repository.update(usuario);

        usuario.setPessoa(pessoaService.find(usuario.getIdPessoa()));
        usuario.setTipoUsuario(this.tipoUsuarioService.find(usuario.getIdTipoUsuario()));
        return usuario;
    }

    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    public void delete(Usuario usuario) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> {
            pessoaService.delete(usuario.getPessoa());
            return null;
        });
        operations.add(() -> {
            this.repository.delete(usuario);
            return null;
        });
        this.repository.performTransaction(operations);
    }

    public Usuario find(Integer id) {
        return this.repository.find(id);
    }

}
