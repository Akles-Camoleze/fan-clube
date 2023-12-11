package application.backend.services;

import application.backend.entities.Endereco;
import application.backend.repository.EnderecoRepository;

public class EnderecoService extends BaseService<Endereco, EnderecoRepository> {
    public EnderecoService() {
        super(new EnderecoRepository());
    }

    public Endereco save(Endereco endereco) {
        endereco.setIdCidade(endereco.getCidade().getId());
        return this.repository.save(endereco);
    }

    @Override
    public Endereco update(Endereco endereco) {
        endereco.setIdCidade(endereco.getCidade().getId());
        this.repository.update(endereco);
        return this.find(endereco.getId());
    }

}
