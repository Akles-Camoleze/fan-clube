package application.backend.controller;

import application.backend.dto.EventoEnderecoCidadeDTO;
import application.backend.repository.EventoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventoController extends Controller<EventoRepository> {

    EventoController() {
        super(new EventoRepository());
    }

    @GetMapping("/all")
    public List<EventoEnderecoCidadeDTO> findAll() {
        return this.repository.findAll(EventoEnderecoCidadeDTO.class);
    }
}
