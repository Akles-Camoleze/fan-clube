package application.backend.entities;

import java.util.Date;

public class Pessoa extends BaseEntity {
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, Date dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Pessoa(Integer id, String nome, String sobrenome, Date dataNascimento, Endereco endereco) {
        super(id);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
