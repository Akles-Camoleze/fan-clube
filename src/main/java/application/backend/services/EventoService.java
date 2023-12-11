package application.backend.services;

import application.backend.dto.EventoReportDTO;
import application.backend.entities.BaseEntity;
import application.backend.entities.Evento;
import application.backend.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

    public Evento save(Evento evento) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> this.enderecoService.save(evento.getEndereco()));
        operations.add(() -> {
            evento.setIdEndereco(evento.getEndereco().getId());
            return this.repository.save(evento);
        });
        return this.repository.performTransaction(operations);
    }

    @Override
    public Evento update(Evento evento) {
        evento.setIdEndereco(evento.getEndereco().getId());
        ArrayList<Runnable> operations = new ArrayList<>();
        operations.add(() -> this.enderecoService.update(evento.getEndereco()));
        operations.add(() -> this.repository.update(evento));
        this.repository.performTransaction(operations);
        return find(evento.getId());
    }
}
