package application.backend.entities;

public class TipoUsuario extends BaseEntity {
    String nome;

    public TipoUsuario() {
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
