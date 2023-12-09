package application.backend.controller;

import application.backend.dto.PessoaReportDTO;
import application.backend.dto.PessoaResponseDTO;
import application.backend.entities.Pessoa;
import application.backend.repository.EnderecoRepository;
import application.backend.repository.PessoaRepository;
import application.backend.services.EnderecoService;
import application.backend.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PessoaController extends Controller<PessoaService> {
    PessoaController() {
        super(new PessoaService());
    }

    @GetMapping("/all")
    public List<Pessoa> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{personId}")
    public PessoaResponseDTO find(@PathVariable Integer personId) {
        return modelMapper.map(this.service.find(personId), PessoaResponseDTO.class);
    }

    @PostMapping("/register")
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody Pessoa request) {
        Pessoa person = this.service.save(request);
        if (person != null) {
            person.setEndereco(new EnderecoRepository().find(person.getIdEndereco()));
            PessoaResponseDTO dto = modelMapper.map(person, PessoaResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/person-report")
    public ResponseEntity<List<PessoaReportDTO>> getPessoaReport() {
        List<PessoaReportDTO> dtos = this.service.getPessoaReport();
        if (!dtos.isEmpty()) {
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
