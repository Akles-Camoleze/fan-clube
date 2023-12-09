package application.backend.controller;

import application.backend.dto.EventoReportDTO;
import application.backend.dto.EventoResponseDTO;
import application.backend.entities.Evento;
import application.backend.services.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventoController extends Controller<EventoService> {

    EventoController() {
        super(new EventoService());
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventoResponseDTO>> findAll() {
        List<Evento> eventos = this.service.findAll();
        if (eventos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<EventoResponseDTO> dtos = new ArrayList<>();
        for (Evento evento : eventos) {
            dtos.add(modelMapper.map(evento, EventoResponseDTO.class));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/subscription-report")
    public ResponseEntity<List<EventoReportDTO>> getSubscriptionReport(@RequestParam(required = false) Integer year) {
        List<EventoReportDTO> dtos = this.service.getSubscriptionReport(year);
        if (!dtos.isEmpty()) {
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
