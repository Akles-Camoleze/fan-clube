package application.backend.entities;

import java.util.Date;

public class Inscricao extends BaseEntity {
    private Date dataIncricao;
    private Usuario usuario;
    private Evento evento;

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
}
