package application.backend.entities;

public class Usuario extends BaseEntity {
    private String nome;
    private String email;
    private String senha;

    private TipoUsuario tipoUsuario;
    private Pessoa pessoa;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, TipoUsuario tipoUsuario, Pessoa pessoa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.pessoa = pessoa;
    }

    public Usuario(Integer id, String nome, String email, String senha, TipoUsuario tipoUsuario, Pessoa pessoa) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
