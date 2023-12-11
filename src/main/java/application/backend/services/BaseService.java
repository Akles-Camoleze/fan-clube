package application.backend.services;

import application.backend.entities.BaseEntity;
import application.backend.repository.BaseRepository;

public class BaseService<U extends BaseEntity, T extends BaseRepository<U>> {
    protected final T repository;

    public BaseService(T repository) {
        this.repository = repository;
    }
}
