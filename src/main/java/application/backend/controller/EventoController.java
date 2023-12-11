package application.backend.controller;

import application.backend.dto.EventoReportDTO;
import application.backend.dto.EventoResponseDTO;
import application.backend.dto.PessoaResponseDTO;
import application.backend.entities.Evento;
import application.backend.services.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/register")
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody Evento request) {
        Evento evento = this.service.save(request);
        if (evento != null) {
            PessoaResponseDTO dto = modelMapper.map(evento, PessoaResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/subscription-report")
    public ResponseEntity<List<EventoReportDTO>> getSubscriptionReport(@RequestParam(required = false) Integer year) {
        List<EventoReportDTO> dtos = this.service.getSubscriptionReport(year);
        if (!dtos.isEmpty()) {
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idEvento}")
    public ResponseEntity<Void> delete(@PathVariable Integer idEvento) {
        Evento evento = this.service.find(idEvento);
        if (evento != null) {
            this.service.delete(evento);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
