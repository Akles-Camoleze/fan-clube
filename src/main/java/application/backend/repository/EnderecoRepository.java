package application.backend.repository;

import application.backend.entities.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements BaseRepository<Endereco> {

    public EnderecoRepository() {
    }

    @Override
    public Endereco get(Integer id) {
        return null;
    }

    @Override
    public List<Endereco> get() {
        return new ArrayList<>();
    }

    @Override
    public void save(Endereco entity) {

    }

}
