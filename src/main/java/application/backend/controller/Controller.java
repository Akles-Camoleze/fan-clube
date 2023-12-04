package application.backend.controller;

import org.modelmapper.ModelMapper;

public class Controller<T> {
    protected T repository;
    protected ModelMapper modelMapper;

    Controller(T repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }
}
