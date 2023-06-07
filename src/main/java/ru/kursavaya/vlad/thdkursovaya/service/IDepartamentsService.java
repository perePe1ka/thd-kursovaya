package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Departaments;

import java.util.List;

public interface IDepartamentsService {
    void create(Departaments departaments);

    Departaments getDepartaments(int id);

    void deleteDepartaments(int id);

    List<Departaments> getAll();

    void updateDepartaments(Departaments departaments);
}
