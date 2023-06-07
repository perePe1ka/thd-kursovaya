package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.BelongDisSpec;

import java.util.List;

public interface IBelongDisSpecService {

    void create(BelongDisSpec belongDisSpec);

    BelongDisSpec getBelongDisSpec(int id);

    void deleteBelongDisSpec(int id);

    List<BelongDisSpec> getAll();

    void updateBelongDisSpec(BelongDisSpec belongDisSpec);


}
