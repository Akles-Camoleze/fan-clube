package application.backend.services;

import application.backend.repository.BaseRepository;

public class BaseService<U, T extends BaseRepository<U>> {
    protected final T repository;

    public BaseService(T repository) {
        this.repository = repository;
    }
}
