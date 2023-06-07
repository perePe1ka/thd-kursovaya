package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Literature;
import ru.kursavaya.thdkursovaya.model.PlanOfWork;

import java.util.List;

public interface IPlanOfWorkService {
    void PlanOfWork(PlanOfWork planOfWork);

    Leads getPlanOfWork(int id);

    void deletePlanOfWork(int id);

    List<PlanOfWork> getAll();

    void updatePlanOfWork(PlanOfWork planOfWork);
}
