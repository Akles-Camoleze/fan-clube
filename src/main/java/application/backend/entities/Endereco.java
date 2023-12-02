package application.backend.entities;

public class Endereco extends BaseEntity {
    private String rua;
    private Integer numero;
    private String bairro;
    private Cidade cidade;
    private Integer idCidade;

    public Endereco() {
    }

    public Endereco(String rua, Integer numero, String bairro, Cidade cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco(Integer id, String rua, Integer numero, String bairro, Cidade cidade) {
        super(id);
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                ", id=" + id +
                '}';
    }
}
