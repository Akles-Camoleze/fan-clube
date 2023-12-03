package application.backend.dto;

import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioTipoDTO implements DataTransferObject {
    private Integer idUsuario;
    private Integer idPessoa;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String nomeTipoUsuario;

    public UsuarioTipoDTO() {
    }

    public UsuarioTipoDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }


    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.idUsuario = resultSet.getInt("id");
            this.idPessoa = resultSet.getInt("idPessoa");
            this.nomeUsuario = resultSet.getString("nome");
            this.emailUsuario = resultSet.getString("email");
            this.senhaUsuario = resultSet.getString("senha");
            this.nomeTipoUsuario = resultSet.getString("nomeTipoUsuario");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNomeTipoUsuario() {
        return nomeTipoUsuario;
    }

    public void setNomeTipoUsuario(String nomeTipoUsuario) {
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioTipoDTO{" +
                "idUsuario=" + idUsuario +
                ", idPessoa=" + idPessoa +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", senhaUsuario='" + senhaUsuario + '\'' +
                ", nomeTipoUsuario='" + nomeTipoUsuario + '\'' +
                '}';
    }
}
