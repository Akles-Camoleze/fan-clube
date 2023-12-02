package application.backend.entities;

import java.util.Date;

public class Arquivo  extends BaseEntity {
    private String caminho;
    private Date dataUpload;

    public Arquivo() {
    }

    public Arquivo(String caminho, Date dataUpload) {
        this.caminho = caminho;
        this.dataUpload = dataUpload;
    }

    public Arquivo(Integer id, String caminho, Date dataUpload) {
        super(id);
        this.caminho = caminho;
        this.dataUpload = dataUpload;
    }

    public String getCaminho() {
        return caminho;
    }

    public Date getDataUpload() {
        return dataUpload;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setDataUpload(Date dataUpload) {
        this.dataUpload = dataUpload;
    }
}
