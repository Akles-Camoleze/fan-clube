package application.backend.dto;

import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoResponseDTO implements DataTransferObject {
    private Integer id;
    private String rua;
    private String bairro;
    private Integer numero;
    private CidadeResponseDTO cidade;

    public EnderecoResponseDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("end.id");
            this.rua = resultSet.getString("end.rua");
            this.bairro = resultSet.getString("usr.bairro");
            this.numero = resultSet.getInt("end.numero");
            this.cidade = new CidadeResponseDTO(resultSet);
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public CidadeResponseDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeResponseDTO cidade) {
        this.cidade = cidade;
    }
}
