package ru.kursavaya.vlad.thdkursovaya.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.vlad.thdkursovaya.model.Teachers;
import ru.kursavaya.vlad.thdkursovaya.repository.BelongTeachDepRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BelongTeachDepService implements IBelongTeachDepService{
    private final BelongTeachDepRepository belongTeachDepRepository;

    @Autowired
    public BelongTeachDepService(BelongTeachDepRepository belongTeachDepRepository) {
        this.belongTeachDepRepository = belongTeachDepRepository;
    }
    private List<BelongTeachDep> belongTeachDeps;

    @Override
    public void create(BelongTeachDep belongTeachDep) {
        belongTeachDepRepository.save(belongTeachDep);
    }

    @Override
    public BelongTeachDep getBelongTeachDep(int id) {
        Optional<BelongTeachDep> optionalBelongTeachDep = belongTeachDepRepository.findById((long) id);
        if (optionalBelongTeachDep.isPresent()) {
            return optionalBelongTeachDep.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteBelongTeachDep(int id) {
        belongTeachDepRepository.deleteById((long) id);
    }

    @Override
    public List<BelongTeachDep> getAll() {
        return (List<BelongTeachDep>) belongTeachDepRepository.findAll();
    }

    @Override
    public void updateBelongTeachDep(BelongTeachDep belongTeachDep) {
        belongTeachDepRepository.save(belongTeachDep);
    }
}
