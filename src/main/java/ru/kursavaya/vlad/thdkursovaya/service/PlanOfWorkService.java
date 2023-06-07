package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.PlanOfWork;
import ru.kursavaya.vlad.thdkursovaya.repository.PlanOfWorkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlanOfWorkService implements IPlanOfWorkService{
    private final PlanOfWorkRepository planOfWorkRepository;
    @Autowired
    public PlanOfWorkService(PlanOfWorkRepository planOfWorkRepository) {
        this.planOfWorkRepository = planOfWorkRepository;
    }
    private List<PlanOfWork> planOfWorks;

    @Override
    public void create(PlanOfWork planOfWork) {
        planOfWorkRepository.save(planOfWork);
    }

    @Override
    public PlanOfWork getPlanOfWork(int id) {
        Optional<PlanOfWork> optionalPlanOfWork = planOfWorkRepository.findById((long) id);
        if (optionalPlanOfWork.isPresent()) {
            return optionalPlanOfWork.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePlanOfWork(int id) {
        planOfWorkRepository.deleteById((long) id);
    }

    @Override
    public List<PlanOfWork> getAll() {
        return (List<PlanOfWork>) planOfWorkRepository.findAll();
    }

    @Override
    public void updatePlanOfWork(PlanOfWork planOfWork) {
        planOfWorkRepository.save(planOfWork);
    }
}
