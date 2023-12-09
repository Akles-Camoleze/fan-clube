package application.backend.services;

import application.backend.entities.BaseEntity;
import application.backend.entities.Usuario;
import application.backend.repository.Perform;
import application.backend.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static application.backend.enums.TipoUsuarioEnum.COMUM;

public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
    private final PessoaService pessoaService;

    public UsuarioService() {
        super(new UsuarioRepository());
        this.pessoaService = new PessoaService();
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
        return this.repository.performTransaction(operations);
    }

    public List<Usuario> findAll() {
        return this.repository.findAll();
    }
}
