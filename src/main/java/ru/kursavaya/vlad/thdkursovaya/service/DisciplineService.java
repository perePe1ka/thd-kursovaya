package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.vlad.thdkursovaya.model.Discipline;
import ru.kursavaya.vlad.thdkursovaya.repository.DisciplineRepository;

import java.util.List;
import java.util.Optional;

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
        disciplineRepository.save(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById((long) id);
        if (optionalDiscipline.isPresent()) {
            return optionalDiscipline.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteDiscipline(int id) {
        disciplineRepository.deleteById((long) id);
    }

    @Override
    public List<Discipline> getAll() {
        return (List<Discipline>) disciplineRepository.findAll();
    }

    @Override
    public void updateDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }
}
