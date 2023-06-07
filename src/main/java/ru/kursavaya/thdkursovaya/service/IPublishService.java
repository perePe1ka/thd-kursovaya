package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.PlanOfWork;
import ru.kursavaya.thdkursovaya.model.Publish;

import java.util.List;

public interface IPublishService {
    void Publish(Publish publish);

    Leads getPublish(int id);

    void deletePublish(int id);

    List<Publish> getAll();

    void updatePublish(Publish publish);
}
