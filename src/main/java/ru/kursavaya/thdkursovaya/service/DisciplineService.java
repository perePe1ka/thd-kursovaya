package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Discipline;
import ru.kursavaya.thdkursovaya.repository.DisciplineRepository;

import java.util.List;

@Service
public class DisciplineService implements IDisciplineService{
    private final DisciplineRepository disciplineRepository;
    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
    private List<Discipline> disciplines;

    @Override
    public void create(Discipline discipline) {

    }

    @Override
    public Discipline getDiscipline(int id) {
        return null;
    }

    @Override
    public void deleteDiscipline(int id) {

    }

    @Override
    public List<Discipline> getAll() {
        return null;
    }

    @Override
    public void updateDiscipline(Discipline discipline) {

    }
}
