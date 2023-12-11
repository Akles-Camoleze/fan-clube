package application.backend.controller;

import application.backend.entities.TipoUsuario;
import application.backend.services.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-type")
public class TipoUsuarioController extends Controller<TipoUsuarioService> {
    TipoUsuarioController() {
        super(new TipoUsuarioService());
    }

    @GetMapping("/all")
    public ResponseEntity<List<TipoUsuario>> findAll() {
        List<TipoUsuario> tipoUsuarios = this.service.findAll();
        if (tipoUsuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tipoUsuarios);
    }
}
