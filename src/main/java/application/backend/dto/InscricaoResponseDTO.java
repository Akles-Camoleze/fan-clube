package application.backend.dto;

import application.backend.entities.Evento;
import application.backend.entities.Usuario;

import java.sql.ResultSet;

public class InscricaoResponseDTO implements DataTransferObject {
    private Integer id;
    private Usuario usuario;
    private Evento evento;

    public InscricaoResponseDTO() {
    }

    public InscricaoResponseDTO(ResultSet resultSet) {
        this.toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
