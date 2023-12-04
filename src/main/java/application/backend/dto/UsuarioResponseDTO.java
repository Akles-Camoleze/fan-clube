package application.backend.dto;

import application.backend.entities.Pessoa;
import application.backend.entities.TipoUsuario;
import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioResponseDTO implements DataTransferObject {
    private Integer id;
    private Pessoa pessoa;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }


    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("usr.id");
            this.nome = resultSet.getString("usr.nome");
            this.email = resultSet.getString("usr.email");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioTipoDTO{" +
                "idUsuario=" + id +
                ", idPessoa=" + pessoa +
                ", nomeUsuario='" + nome + '\'' +
                ", emailUsuario='" + email + '\'' +
                ", nomeTipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
