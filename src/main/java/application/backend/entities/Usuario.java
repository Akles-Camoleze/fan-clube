package application.backend.entities;

import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario extends BaseEntity {
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private Integer idTipoUsuario;
    private Pessoa pessoa;
    private Integer idPessoa;

    public Usuario() {
    }

    public Usuario(ResultSet resultSet) {
        try {
            id = resultSet.getInt("usr.id");
            nome = resultSet.getString("usr.nome");
            email = resultSet.getString("usr.email");
            senha = resultSet.getString("usr.senha");
            pessoa = new Pessoa(resultSet);
            tipoUsuario = new TipoUsuario(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
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

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", pessoa=" + pessoa +
                ", id=" + id +
                '}';
    }
}
