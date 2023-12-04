package application.backend.controller;

import application.backend.dto.UsuarioResponseDTO;
import application.backend.entities.Usuario;
import application.backend.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController extends Controller<UsuarioRepository> {

    @Autowired
    private ModelMapper modelMapper;

    UsuarioController() {
        super(new UsuarioRepository());
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody Usuario request) {
        Usuario user = this.repository.findByEmail(request.getEmail());
        if (user != null && user.getSenha().equals(request.getSenha())) {
            UsuarioResponseDTO dto = modelMapper.map(user, UsuarioResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
