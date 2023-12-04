package application.backend.controller;

import application.backend.dto.UsuarioTipoDTO;
import application.backend.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController extends Controller<UsuarioRepository> {

    UsuarioController() {
        super(new UsuarioRepository());
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTipoDTO> login(@RequestBody UsuarioTipoDTO dto) {
        UsuarioTipoDTO user = this.repository.findByEmail(dto.getEmailUsuario(), dto.getClass());
        if (user != null && dto.getSenhaUsuario().equals(user.getSenhaUsuario())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
