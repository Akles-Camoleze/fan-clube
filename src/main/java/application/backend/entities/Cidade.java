package application.backend.entities;

public class Cidade extends BaseEntity {
    private String nome;
    private String uf;

    public Cidade() {
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

}
