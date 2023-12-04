package application.backend.controller;

public class Controller<T> {
    protected T repository;

    Controller(T repository) {
        this.repository = repository;
    }
}
