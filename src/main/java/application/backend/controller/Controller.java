package application.backend.controller;

import application.backend.services.BaseService;
import org.modelmapper.ModelMapper;

public class Controller<T extends BaseService<?, ?>> {
    protected T service;
    protected ModelMapper modelMapper;

    Controller(T repository) {
        this.service = repository;
        this.modelMapper = new ModelMapper();
    }
}
