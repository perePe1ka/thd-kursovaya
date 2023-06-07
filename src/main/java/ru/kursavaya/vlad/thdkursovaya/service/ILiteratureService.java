package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Literature;

import java.util.List;

public interface ILiteratureService {
    void create(Literature literature);

    Literature getLiterature(int id);

    void deleteLiterature(int id);

    List<Literature> getAll();

    void updateLiterature(Literature literature);
}
