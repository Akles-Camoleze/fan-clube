package application.backend.controller;

import application.backend.repository.TipoUsuarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-type")
public class TipoUsuarioController extends Controller<TipoUsuarioRepository> {
    TipoUsuarioController() {
        super(new TipoUsuarioRepository());
    }
}
