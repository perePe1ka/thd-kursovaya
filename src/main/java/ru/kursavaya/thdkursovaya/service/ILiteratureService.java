package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Literature;

import java.util.List;

public interface ILiteratureService {
    void Literature(Literature literature);

    Leads getLiterature(int id);

    void deleteLiterature(int id);

    List<Literature> getAll();

    void updateLiterature(Literature literature);
}
