package application.backend.entities;

import application.database.DbException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cidade extends BaseEntity {
    private String nome;
    private String uf;

    public Cidade() {
    }

    public Cidade(ResultSet resultSet) {
        try {
            id = resultSet.getInt("cd.id");
            nome = resultSet.getString("cd.nome");
            uf = resultSet.getString("cd.uf");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade(Integer id, String nome, String uf) {
        super(id);
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", id=" + id +
                '}';
    }
}
