package application.backend.repository;

import application.backend.entities.Endereco;

public class EnderecoRepository implements BaseRepository<Endereco> {

    public EnderecoRepository() {
    }

    @Override
    public Endereco get(Integer id) {
        return null;
    }

    @Override
    public Endereco[] get() {
        return new Endereco[0];
    }

    @Override
    public void save(Endereco entity) {

    }

}
