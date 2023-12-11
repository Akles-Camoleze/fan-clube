package application.backend.entities;

import application.database.DbException;
import application.utils.DateParser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoUsuario extends BaseEntity {
    String nome;

    public TipoUsuario() {
    }

    public TipoUsuario(ResultSet resultSet) {
        try {
            id = resultSet.getInt("tp.id");
            nome = resultSet.getString("tp.nome");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public TipoUsuario(String nome) {
        this.nome = nome;
    }

    public TipoUsuario(Integer id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
