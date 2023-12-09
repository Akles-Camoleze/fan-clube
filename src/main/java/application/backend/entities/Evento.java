package application.backend.entities;

import application.backend.dto.EnderecoResponseDTO;
import application.database.DbException;
import application.utils.DateParser;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Evento extends BaseEntity {
    private String nome;
    private Timestamp data;
    private String descricao;
    private Endereco endereco;
    private Arquivo arquivo;
    private Integer capacidade;
    private BigDecimal valor;

    public Evento() {
    }

    public Evento(String nome, Timestamp data, String descricao, Endereco endereco, Arquivo arquivo, Integer capacidade, BigDecimal valor) {
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.endereco = endereco;
        this.arquivo = arquivo;
        this.capacidade = capacidade;
        this.valor = valor;
    }

    public Evento(Integer id, String nome, Timestamp data, String descricao, Endereco endereco, Arquivo arquivo, Integer capacidade, BigDecimal valor) {
        super(id);
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.endereco = endereco;
        this.arquivo = arquivo;
        this.capacidade = capacidade;
        this.valor = valor;
    }

    public Evento(ResultSet resultSet) {
        try {
            id = resultSet.getInt("env.id");
            nome = resultSet.getString("env.nome");
            data = resultSet.getTimestamp("env.data");
            descricao = resultSet.getString("env.descricao");
            capacidade = resultSet.getInt("env.capacidade");
            valor = resultSet.getBigDecimal("env.valor");
            endereco = new Endereco(resultSet);
            arquivo = null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public Timestamp getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", arquivo=" + arquivo +
                ", capacidade=" + capacidade +
                ", valor=" + valor +
                ", id=" + id +
                '}';
    }
}
