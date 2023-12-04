package application.backend.entities;

import application.database.DbException;
import application.utils.DateParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Pessoa extends BaseEntity {
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private Endereco endereco;
    private Integer idEndereco;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(ResultSet resultSet) {
        try {
            id = resultSet.getInt("ps.id");
            nome = resultSet.getString("ps.nome");
            sobrenome = resultSet.getString("ps.sobrenome");
            telefone = resultSet.getString("ps.telefone");
            dataNascimento = DateParser.parseString(resultSet.getString("ps.dataNascimento"));
            this.endereco = new Endereco(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Pessoa(String nome, String sobrenome, Date dataNascimento, Endereco endereco, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Pessoa(Integer id, String nome, String sobrenome, Date dataNascimento, Endereco endereco, String telefone) {
        super(id);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco=" + endereco +
                ", id=" + id +
                '}';
    }
}
