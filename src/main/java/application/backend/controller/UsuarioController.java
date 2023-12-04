package application.backend.controller;

import application.backend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController extends Controller<UsuarioRepository> {

    UsuarioController() {
        super(new UsuarioRepository());
    }
}
