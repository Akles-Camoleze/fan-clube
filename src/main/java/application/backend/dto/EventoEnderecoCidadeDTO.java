package application.backend.dto;

import application.utils.DateParser;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EventoEnderecoCidadeDTO implements DataTransferObject {
    private Integer idEvento;
    private String nomeEvento;
    private Integer capacidadeEvento;
    private Date dataEvento;
    private String bairroEndereco;
    private String descricaoEvento;
    private BigDecimal valorEvento;
    private String nomeCidade;
    private String ufCidade;
    private String ruaEndereco;
    private Integer numeroEndereco;

    public EventoEnderecoCidadeDTO() {
    }

    public EventoEnderecoCidadeDTO(ResultSet resultSet) {
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

            this.idEvento = resultSet.getInt("id");
            this.nomeEvento = resultSet.getString("nome");
            this.capacidadeEvento = resultSet.getInt("capacidade");
            this.descricaoEvento = resultSet.getString("descricao");
            this.valorEvento = resultSet.getBigDecimal("valor");

            this.dataEvento = DateParser.parseString(resultSet.getString("data"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Integer getCapacidadeEvento() {
        return capacidadeEvento;
    }

    public void setCapacidadeEvento(Integer capacidadeEvento) {
        this.capacidadeEvento = capacidadeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public BigDecimal getValorEvento() {
        return valorEvento;
    }

    public void setValorEvento(BigDecimal valorEvento) {
        this.valorEvento = valorEvento;
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

    @Override
    public String toString() {
        return "EventoEnderecoCidadeDTO{" +
                "idEvento=" + idEvento +
                ", nomeEvento='" + nomeEvento + '\'' +
                ", capacidadeEvento=" + capacidadeEvento +
                ", dataEvento=" + dataEvento +
                ", bairroEndereco='" + bairroEndereco + '\'' +
                ", descricaoEvento='" + descricaoEvento + '\'' +
                ", valorEvento=" + valorEvento +
                ", nomeCidade='" + nomeCidade + '\'' +
                ", ufCidade='" + ufCidade + '\'' +
                ", ruaEndereco='" + ruaEndereco + '\'' +
                ", numeroEndereco=" + numeroEndereco +
                '}';
    }
}
