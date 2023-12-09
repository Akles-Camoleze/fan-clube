package application.backend.services;

import application.backend.dto.PessoaReportDTO;
import application.backend.dto.PessoaResponseDTO;
import application.backend.entities.BaseEntity;
import application.backend.entities.Pessoa;
import application.backend.repository.EnderecoRepository;
import application.backend.repository.Perform;
import application.backend.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PessoaService extends BaseService<Pessoa, PessoaRepository> {
    private final EnderecoService enderecoService;

    public PessoaService() {
        super(new PessoaRepository());
        this.enderecoService = new EnderecoService();
    }

    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    public PessoaResponseDTO find(Integer id) {
        return this.repository.find(id, PessoaResponseDTO.class);
    }

    public Pessoa save(Pessoa pessoa) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> this.enderecoService.save(pessoa.getEndereco()));
        operations.add(() -> {
            pessoa.setIdEndereco(pessoa.getEndereco().getId());
            return this.repository.save(pessoa);
        });
        return this.repository.performTransaction(operations);
    }

    public List<PessoaReportDTO> getPessoaReport() {
        return this.repository.getPessoaReport();
    }
}