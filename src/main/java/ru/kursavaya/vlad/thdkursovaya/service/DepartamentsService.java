package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.Departaments;
import ru.kursavaya.vlad.thdkursovaya.repository.DepartamentsRepository;

import java.util.List;
import java.util.Optional;

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
        departamentsRepository.save(departaments);
    }

    @Override
    public Departaments getDepartaments(int id) {
        Optional<Departaments> optionalDepartaments = departamentsRepository.findById((long) id);
        if (optionalDepartaments.isPresent()) {
            return optionalDepartaments.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteDepartaments(int id) {
        departamentsRepository.deleteById((long) id);
    }

    @Override
    public List<Departaments> getAll() {
        return (List<Departaments>) departamentsRepository.findAll();
    }

    @Override
    public void updateDepartaments(Departaments departaments) {
        departamentsRepository.save(departaments);
    }
}
