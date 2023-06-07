package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Discipline;

import java.util.List;

public interface IDisciplineService {
    void create(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

    List<Discipline> getAll();

    void updateDiscipline(Discipline discipline);
}
