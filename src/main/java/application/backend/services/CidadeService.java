package application.backend.services;

import application.backend.entities.Cidade;
import application.backend.repository.CidadeRepository;

public class CidadeService extends BaseService<Cidade, CidadeRepository> {
    public CidadeService() {
        super(new CidadeRepository());
    }

    public Cidade save(Cidade cidade) {
        return this.repository.save(cidade);
    }
}
