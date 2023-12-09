package application.backend.dto;

import application.utils.DateParser;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class EventoResponseDTO implements DataTransferObject {
    private Integer id;
    private String nome;
    private Integer capacidade;
    private Timestamp data;
    private String descricao;
    private BigDecimal valor;
    private EnderecoResponseDTO endereco;

    public EventoResponseDTO() {
    }

    public EventoResponseDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("env.id");
            this.nome = resultSet.getString("env.nome");
            this.capacidade = resultSet.getInt("env.capacidade");
            this.descricao = resultSet.getString("env.descricao");
            this.valor = resultSet.getBigDecimal("env.valor");
            this.data = resultSet.getTimestamp("env.data");
            this.endereco = new EnderecoResponseDTO(resultSet);
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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "EventoEnderecoCidadeDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", endereco=" + endereco +
                '}';
    }
}
