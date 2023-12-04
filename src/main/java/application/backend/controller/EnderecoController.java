package application.backend.controller;

import application.backend.dto.EnderecoResponseDTO;
import application.backend.entities.Endereco;
import application.backend.repository.CidadeRepository;
import application.backend.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class EnderecoController extends Controller<EnderecoRepository> {


    EnderecoController() {
        super(new EnderecoRepository());
    }

    @PostMapping("/register")
    public ResponseEntity<EnderecoResponseDTO> register(@RequestBody Endereco request) {
        Endereco address = this.repository.save(request);
        if (address != null) {
            address.setCidade(new CidadeRepository().find(address.getIdCidade()));
            EnderecoResponseDTO dto = modelMapper.map(address, EnderecoResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
