package application.backend.controller;

import application.backend.dto.InscricaoResponseDTO;
import application.backend.entities.Inscricao;
import application.backend.services.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subscription")
public class InscricaoController extends Controller<InscricaoService> {
    InscricaoController() {
        super(new InscricaoService());
    }

    @PostMapping("/register")
    public ResponseEntity<InscricaoResponseDTO> register(@RequestBody Inscricao request) {
        Inscricao inscricao = this.service.save(request);
        if (inscricao != null) {
            return ResponseEntity.ok(modelMapper.map(inscricao, InscricaoResponseDTO.class));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/all/{idUsuario}")
    public ResponseEntity<List<InscricaoResponseDTO>> findAllByUsuario(@PathVariable Integer idUsuario) {
        List<Inscricao> inscricoes = this.service.findAllByUsuario(idUsuario);
        if (inscricoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<InscricaoResponseDTO> dtos = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
            dtos.add(modelMapper.map(inscricao, InscricaoResponseDTO.class));
        }
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{idInscricao}")
    public ResponseEntity<Void> delete(@PathVariable Integer idInscricao) {
        Inscricao inscricao = this.service.find(idInscricao);
        if (inscricao != null) {
            this.service.delete(inscricao);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
