package application.backend.services;

import application.backend.dto.PessoaReportDTO;
import application.backend.entities.BaseEntity;
import application.backend.entities.Pessoa;
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

    public Pessoa save(Pessoa pessoa) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> this.enderecoService.save(pessoa.getEndereco()));
        operations.add(() -> {
            pessoa.setIdEndereco(pessoa.getEndereco().getId());
            return this.repository.save(pessoa);
        });
        return this.repository.performTransaction(operations);
    }

    @Override
    public void delete(Pessoa pessoa) {
        List<Supplier<? extends BaseEntity>> operations = new ArrayList<>();
        operations.add(() -> {
            this.enderecoService.delete(pessoa.getEndereco());
            return null;
        });
        operations.add(() -> {
            this.repository.delete(pessoa);
            return null;
        });
        this.repository.performTransaction(operations);
    }

    public List<PessoaReportDTO> getPessoaReport() {
        return this.repository.getPessoaReport();
    }
}
