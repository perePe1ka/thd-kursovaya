package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.BelongTeachDep;

import java.util.List;

public interface IBelongTeachDepService {

    void create(BelongTeachDep belongTeachDep);

    BelongTeachDep getBelongTeachDep(int id);

    void deleteBelongTeachDep(int id);

    List<BelongTeachDep> getAll();

    void updateBelongTeachDep(BelongTeachDep belongTeachDep);
}
