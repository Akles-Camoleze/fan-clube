package application.backend.controller;

import application.backend.dto.PessoaResponseDTO;
import application.backend.entities.Pessoa;
import application.backend.repository.EnderecoRepository;
import application.backend.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PessoaController extends Controller<PessoaRepository> {

    PessoaController() {
        super(new PessoaRepository());
    }

    @GetMapping("/all")
    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{personId}")
    public PessoaResponseDTO find(@PathVariable Integer personId) {
        return this.repository.find(personId, PessoaResponseDTO.class);
    }

    @PostMapping("/register")
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody Pessoa request) {
        request.setIdEndereco(request.getEndereco().getId());
        Pessoa person = this.repository.save(request);
        if (person != null) {
            person.setEndereco(new EnderecoRepository().find(person.getIdEndereco()));
            PessoaResponseDTO dto = modelMapper.map(person, PessoaResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
