package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.BelongDisSpec;
import ru.kursavaya.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.thdkursovaya.repository.BelongTeachDepRepository;

import java.util.List;

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

    }

    @Override
    public BelongTeachDep getBelongTeachDep(int id) {
        return null;
    }

    @Override
    public void deleteBelongTeachDep(int id) {

    }

    @Override
    public List<BelongTeachDep> getAll() {
        return null;
    }

    @Override
    public void updateBelongTeachDep(BelongTeachDep belongTeachDep) {

    }
}
