package application.backend.dto;

import application.backend.entities.Cidade;
import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeResponseDTO implements DataTransferObject {
    private Integer id;
    private String nome;
    private String uf;

    public CidadeResponseDTO() {

    }

    public CidadeResponseDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("cd.id");
            this.nome = resultSet.getString("cd.nome");
            this.uf = resultSet.getString("cd.uf");
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
