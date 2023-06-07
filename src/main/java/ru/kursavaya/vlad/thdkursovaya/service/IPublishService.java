package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Publish;

import java.util.List;

public interface IPublishService {
    void create(Publish publish);

    Publish getPublish(int id);

    void deletePublish(int id);

    List<Publish> getAll();

    void updatePublish(Publish publish);
}
