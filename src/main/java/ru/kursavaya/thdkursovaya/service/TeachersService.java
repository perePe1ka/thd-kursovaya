package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Teachers;
import ru.kursavaya.thdkursovaya.repository.TeachersRepository;

import java.util.List;

@Service
public class TeachersService implements ITeachersService{
    private final TeachersRepository teachersRepository;
    @Autowired
    public TeachersService(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }
    private List<Teachers> teachers;

    @Override
    public void Teachers(Teachers teachers) {

    }

    @Override
    public Leads getTeachers(int id) {
        return null;
    }

    @Override
    public void deleteTeachers(int id) {

    }

    @Override
    public List<Teachers> getAll() {
        return null;
    }

    @Override
    public void updateTeachers(Teachers teachers) {

    }
}
