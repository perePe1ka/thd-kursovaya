package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Speciality;
import ru.kursavaya.thdkursovaya.model.Teachers;

import java.util.List;

public interface ITeachersService {
    void Teachers(Teachers teachers);

    Leads getTeachers(int id);

    void deleteTeachers(int id);

    List<Teachers> getAll();

    void updateTeachers(Teachers teachers);
}
