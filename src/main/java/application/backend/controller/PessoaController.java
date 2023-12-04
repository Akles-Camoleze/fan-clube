package application.backend.controller;

import application.backend.dto.PessoaEnderecoCidadeDTO;
import application.backend.entities.Pessoa;
import application.backend.repository.PessoaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public PessoaEnderecoCidadeDTO find(@PathVariable Integer personId) {
        return this.repository.find(personId, PessoaEnderecoCidadeDTO.class);
    }

}
