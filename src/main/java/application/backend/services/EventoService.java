package application.backend.services;

import application.backend.dto.EventoReportDTO;
import application.backend.entities.Evento;
import application.backend.repository.EventoRepository;

import java.util.List;

public class EventoService extends BaseService<Evento, EventoRepository> {
    private final EnderecoService enderecoService;

    public EventoService() {
        super(new EventoRepository());
        enderecoService = new EnderecoService();
    }

    public List<Evento> findAll() {
        return this.repository.findAll();
    }

    public List<EventoReportDTO> getSubscriptionReport(Integer year) {
        return this.repository.getSubscriptionReport(year);
    }
}
