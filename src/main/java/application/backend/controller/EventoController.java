package application.backend.controller;

import application.backend.repository.EventoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventoController extends Controller<EventoRepository> {

    EventoController() {
        super(new EventoRepository());
    }
}
