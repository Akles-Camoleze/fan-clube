package application.backend.services;

import application.backend.entities.BaseEntity;
import application.backend.entities.Usuario;
import application.backend.repository.BaseRepository;

public class BaseService<U extends BaseEntity, T extends BaseRepository<U>> {
    protected final T repository;

    public BaseService(T repository) {
        this.repository = repository;
    }

    public void delete(U entity) {
        this.repository.delete(entity);
    }

    public U find(Integer id) {
        return this.repository.find(id);
    }

    public U update(U entity) {
        this.repository.update(entity);
        return this.find(entity.getId());
    }
}
