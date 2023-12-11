package application.backend.services;

import application.backend.entities.Inscricao;
import application.backend.repository.InscricaoRepository;

import java.util.List;

public class InscricaoService extends BaseService<Inscricao, InscricaoRepository> {
    public InscricaoService() {
        super(new InscricaoRepository());
    }

    public Inscricao save(Inscricao inscricao) {
        inscricao.setIdEvento(inscricao.getEvento().getId());
        inscricao.setIdUsuario(inscricao.getUsuario().getId());
        return this.repository.save(inscricao);
    }

    public List<Inscricao> findAllByUsuario(Integer idUsuario) {
        return this.repository.findAllByUsuario(idUsuario);
    }
}
