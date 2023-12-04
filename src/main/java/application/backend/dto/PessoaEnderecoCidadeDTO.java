package application.backend.dto;

import application.utils.DateParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PessoaEnderecoCidadeDTO implements DataTransferObject {
    private Integer idPessoa;
    private String nomePessoa;
    private String sobrenomePessoa;
    private Date dataNascimentoPessoa;
    private String telefonePessoa;
    private String bairroEndereco;
    private String nomeCidade;
    private String ufCidade;
    private String ruaEndereco;
    private Integer numeroEndereco;

    public PessoaEnderecoCidadeDTO() {
    }

    public PessoaEnderecoCidadeDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.nomeCidade = resultSet.getString("nomeCidade");
            this.ufCidade = resultSet.getString("uf");

            this.ruaEndereco = resultSet.getString("rua");
            this.numeroEndereco = resultSet.getInt("numero");
            this.bairroEndereco = resultSet.getString("bairro");

            this.idPessoa = resultSet.getInt("id");
            this.nomePessoa = resultSet.getString("nome");
            this.sobrenomePessoa = resultSet.getString("sobrenome");
            this.telefonePessoa = resultSet.getString("telefone");

            this.dataNascimentoPessoa = DateParser.parseString(resultSet.getString("dataNascimento"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Date getDataNascimentoPessoa() {
        return dataNascimentoPessoa;
    }

    public void setDataNascimentoPessoa(Date dataNascimentoPessoa) {
        this.dataNascimentoPessoa = dataNascimentoPessoa;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }


    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUfCidade() {
        return ufCidade;
    }

    public void setUfCidade(String ufCidade) {
        this.ufCidade = ufCidade;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public void setSobrenomePessoa(String sobrenomePessoa) {
        this.sobrenomePessoa = sobrenomePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    @Override
    public String toString() {
        return "PessoaEnderecoCidadeDTO{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", sobrenomePessoa='" + sobrenomePessoa + '\'' +
                ", dataNascimento=" + dataNascimentoPessoa +
                ", bairroEndereco='" + bairroEndereco + '\'' +
                ", nomeCidade='" + nomeCidade + '\'' +
                ", ufCidade='" + ufCidade + '\'' +
                ", ruaEndereco='" + ruaEndereco + '\'' +
                ", numeroEndereco=" + numeroEndereco +
                '}';
    }
}

