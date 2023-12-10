package application.backend.entities;

import application.database.DbException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Inscricao extends BaseEntity {
    private Date dataIncricao;
    private Usuario usuario;
    private Evento evento;
    private Integer idUsuario;
    private Integer idEvento;

    public Inscricao() {
    }

    public Inscricao(Date dataIncricao, Usuario usuario, Evento evento) {
        this.dataIncricao = dataIncricao;
        this.usuario = usuario;
        this.evento = evento;
    }

    public Inscricao(Integer id, Date dataIncricao, Usuario usuario, Evento evento) {
        super(id);
        this.dataIncricao = dataIncricao;
        this.usuario = usuario;
        this.evento = evento;
    }

    public Inscricao(ResultSet resultSet) {
        try {
            id = resultSet.getInt("ins.id");
            usuario = new Usuario(resultSet);
            evento = new Evento(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Date getDataIncricao() {
        return dataIncricao;
    }

    public void setDataIncricao(Date dataIncricao) {
        this.dataIncricao = dataIncricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
}
