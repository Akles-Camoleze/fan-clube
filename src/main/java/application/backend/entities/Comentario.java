package application.backend.entities;

public class Comentario extends BaseEntity {
    private String mensagem;
    private Evento evento;
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(String mensagem, Evento evento, Usuario usuario) {
        this.mensagem = mensagem;
        this.evento = evento;
        this.usuario = usuario;
    }

    public Comentario(Integer id, String mensagem, Evento evento, Usuario usuario) {
        super(id);
        this.mensagem = mensagem;
        this.evento = evento;
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
