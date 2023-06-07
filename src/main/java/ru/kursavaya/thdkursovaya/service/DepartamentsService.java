package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Departaments;
import ru.kursavaya.thdkursovaya.repository.DepartamentsRepository;

import java.util.List;

@Service
public class DepartamentsService implements IDepartamentsService{
    private final DepartamentsRepository departamentsRepository;

    @Autowired
    public DepartamentsService(DepartamentsRepository departamentsRepository) {
        this.departamentsRepository = departamentsRepository;
    }

    private List<Departaments> departaments;

    @Override
    public void create(Departaments departaments) {

    }

    @Override
    public Departaments getDepartaments(int id) {
        return null;
    }

    @Override
    public void deleteDepartaments(int id) {

    }

    @Override
    public List<Departaments> getAll() {
        return null;
    }

    @Override
    public void updateDepartaments(Departaments departaments) {

    }
}
