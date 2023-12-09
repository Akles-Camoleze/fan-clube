package application.backend.services;

import application.backend.entities.Endereco;
import application.backend.repository.EnderecoRepository;
import application.backend.repository.Perform;

public class EnderecoService extends BaseService<Endereco, EnderecoRepository> {
    public EnderecoService() {
        super(new EnderecoRepository());
    }

    public Endereco save(Endereco endereco) {
        endereco.setIdCidade(endereco.getCidade().getId());
        return this.repository.performOperation((Perform<Endereco>) (connection) -> this.repository.save(connection, endereco));
    }
}
