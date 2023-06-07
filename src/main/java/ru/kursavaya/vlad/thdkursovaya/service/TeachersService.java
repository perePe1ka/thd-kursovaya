package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.Teachers;
import ru.kursavaya.vlad.thdkursovaya.repository.TeachersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService implements ITeachersService{
    private final TeachersRepository teachersRepository;
    @Autowired
    public TeachersService(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }
    private List<Teachers> teachers;

    @Override
    public void create(Teachers teachers) {
        teachersRepository.save(teachers);
    }

    @Override
    public Teachers getTeachers(int id) {
        Optional<Teachers> optionalTeachers = teachersRepository.findById((long) id);
        if (optionalTeachers.isPresent()) {
            return optionalTeachers.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteTeachers(int id) {
        teachersRepository.deleteById((long) id);
    }

    @Override
    public List<Teachers> getAll() {
        return (List<Teachers>) teachersRepository.findAll();
    }

    @Override
    public void updateTeachers(Teachers teachers) {
        teachersRepository.save(teachers);
    }
}
