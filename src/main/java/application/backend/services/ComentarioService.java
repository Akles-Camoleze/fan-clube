package application.backend.services;
import application.backend.entities.Comentario;
import application.backend.repository.ComentarioRepository;

public class ComentarioService extends BaseService<Comentario, ComentarioRepository> {
    public ComentarioService() {
        super(new ComentarioRepository());
    }

}
