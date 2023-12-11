package application.backend.services;

import application.backend.entities.Resposta;
import application.backend.repository.RespostaRepository;

public class RespostaService extends BaseService<Resposta, RespostaRepository> {
    public RespostaService() {
        super(new RespostaRepository());
    }
}
