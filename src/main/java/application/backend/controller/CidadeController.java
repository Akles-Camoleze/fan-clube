package application.backend.controller;

import application.backend.dto.CidadeResponseDTO;
import application.backend.entities.Cidade;
import application.backend.repository.CidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CidadeController extends Controller<CidadeRepository> {
    CidadeController() {
        super(new CidadeRepository());
    }

    @PostMapping("/register")
    public ResponseEntity<CidadeResponseDTO> register(@RequestBody Cidade request) {
        Cidade city = this.repository.save(request);
        if (city != null) {
            CidadeResponseDTO dto = modelMapper.map(city, CidadeResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
