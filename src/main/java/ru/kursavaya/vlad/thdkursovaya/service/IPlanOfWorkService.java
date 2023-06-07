package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.PlanOfWork;

import java.util.List;

public interface IPlanOfWorkService {
    void create(PlanOfWork planOfWork);

    PlanOfWork getPlanOfWork(int id);

    void deletePlanOfWork(int id);

    List<PlanOfWork> getAll();

    void updatePlanOfWork(PlanOfWork planOfWork);
}
