package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.BelongDisSpec;
import ru.kursavaya.thdkursovaya.model.BelongTeachDep;

import java.util.List;

public interface IBelongTeachDepService {

    void create(BelongTeachDep belongTeachDep);

    BelongTeachDep getBelongTeachDep(int id);

    void deleteBelongTeachDep(int id);

    List<BelongTeachDep> getAll();

    void updateBelongTeachDep(BelongTeachDep belongTeachDep);
}
