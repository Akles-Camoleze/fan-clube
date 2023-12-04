package application.backend.dto;

import application.utils.DateParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PessoaEnderecoCidadeDTO implements DataTransferObject {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String telefone;
    private EnderecoResponseDTO endereco;

    public PessoaEnderecoCidadeDTO() {
    }

    public PessoaEnderecoCidadeDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("ps.id");
            this.nome = resultSet.getString("ps.nome");
            this.sobrenome = resultSet.getString("ps.sobrenome");
            this.telefone = resultSet.getString("ps.telefone");
            this.endereco = new EnderecoResponseDTO(resultSet);
            this.dataNascimento = DateParser.parseString(resultSet.getString("ps.dataNascimento"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaEnderecoCidadeDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}

