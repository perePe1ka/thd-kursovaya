package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.PlanOfWork;
import ru.kursavaya.thdkursovaya.repository.PlanOfWorkRepository;

import java.util.List;

@Service
public class PlanOfWorkService implements IPlanOfWorkService{
    private final PlanOfWorkRepository planOfWorkRepository;
    @Autowired
    public PlanOfWorkService(PlanOfWorkRepository planOfWorkRepository) {
        this.planOfWorkRepository = planOfWorkRepository;
    }
    private List<PlanOfWork> planOfWorks;

    @Override
    public void PlanOfWork(PlanOfWork planOfWork) {

    }

    @Override
    public Leads getPlanOfWork(int id) {
        return null;
    }

    @Override
    public void deletePlanOfWork(int id) {

    }

    @Override
    public List<PlanOfWork> getAll() {
        return null;
    }

    @Override
    public void updatePlanOfWork(PlanOfWork planOfWork) {

    }
}
