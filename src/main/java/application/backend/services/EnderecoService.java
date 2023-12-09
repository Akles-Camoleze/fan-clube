package application.backend.services;

import application.backend.entities.Endereco;
import application.backend.repository.EnderecoRepository;
import application.backend.repository.Perform;

import java.sql.Connection;

public class EnderecoService extends BaseService<Endereco, EnderecoRepository> {
    public EnderecoService() {
        super(new EnderecoRepository());
    }

    public Endereco save(Endereco endereco) {
        endereco.setIdCidade(endereco.getCidade().getId());
        return this.repository.save(endereco);
    }

    public void delete(Endereco endereco) {
        this.repository.delete(endereco);
    }
}
