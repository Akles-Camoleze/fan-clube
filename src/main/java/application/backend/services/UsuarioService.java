package application.backend.services;

import application.backend.entities.BaseEntity;
import application.backend.entities.Usuario;
import application.backend.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static application.backend.enums.TipoUsuarioEnum.COMUM;

public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
    private final PessoaService pessoaService;
    private final TipoUsuarioService tipoUsuarioService;
    private final ComentarioService comentarioService;
    private final RespostaService respostaService;

    public UsuarioService() {
        super(new UsuarioRepository());
        this.pessoaService = new PessoaService();
        this.tipoUsuarioService = new TipoUsuarioService();
        this.comentarioService = new ComentarioService();
        this.respostaService = new RespostaService();
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
        this.repository.performTransaction(operations);
        usuario.setTipoUsuario(this.tipoUsuarioService.find(usuario.getIdTipoUsuario()));
        return usuario;
    }

    @Override
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

    @Override
    public void delete(Usuario usuario) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> {
            this.repository.delete(usuario);
            return null;
        });
        operations.add(() -> {
            pessoaService.delete(usuario.getPessoa());
            return null;
        });
        this.repository.performTransaction(operations);
    }

}
