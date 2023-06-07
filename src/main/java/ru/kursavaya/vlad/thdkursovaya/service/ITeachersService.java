package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Teachers;

import java.util.List;

public interface ITeachersService {
    void create(Teachers teachers);

    Teachers getTeachers(int id);

    void deleteTeachers(int id);

    List<Teachers> getAll();

    void updateTeachers(Teachers teachers);
}
