package application.backend.entities;

public class Resposta extends BaseEntity {
    private String mensagem;
    private Usuario usuario;
    private Comentario comentario;

    public Resposta() {
    }

    public Resposta(String mensagem, Usuario usuario, Comentario comentario) {
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Resposta(Integer id, String mensagem, Usuario usuario, Comentario comentario) {
        super(id);
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
