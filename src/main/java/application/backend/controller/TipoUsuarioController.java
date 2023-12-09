package application.backend.controller;

import application.backend.services.TipoUsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-type")
public class TipoUsuarioController extends Controller<TipoUsuarioService> {
    TipoUsuarioController() {
        super(new TipoUsuarioService());
    }
}
