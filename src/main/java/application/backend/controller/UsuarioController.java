package application.backend.controller;

import application.backend.dto.UsuarioResponseDTO;
import application.backend.entities.Usuario;
import application.backend.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController extends Controller<UsuarioService> {

    UsuarioController() {
        super(new UsuarioService());
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody Usuario request) {
        Usuario user = this.service.findByEmail(request.getEmail());
        if (user != null && user.getSenha().equals(request.getSenha())) {
            UsuarioResponseDTO dto = modelMapper.map(user, UsuarioResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody Usuario request) {
        Usuario user = this.service.save(request);

        if (user != null) {
            UsuarioResponseDTO dto = modelMapper.map(user, UsuarioResponseDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody Usuario request) {
        Usuario user = this.service.update(request);

        if (user != null) {
            UsuarioResponseDTO dto = modelMapper.map(user, UsuarioResponseDTO.class);
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
        List<Usuario> usuarios = this.service.findAll();
        List<UsuarioResponseDTO> dtos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            dtos.add(modelMapper.map(usuario, UsuarioResponseDTO.class));
        }

        if (!dtos.isEmpty()) {
            return ResponseEntity.ok(dtos);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Integer idUsuario) {
        Usuario usuario = this.service.find(idUsuario);
        if (usuario != null) {
            this.service.delete(usuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
