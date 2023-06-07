package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.BelongDisSpec;
import ru.kursavaya.thdkursovaya.repository.BelongDisSpecRepository;

import java.util.List;

@Service
public class BelongDisSpecService implements IBelongDisSpecService{
    private final BelongDisSpecRepository belongDisSpecRepository;
    @Autowired
    public BelongDisSpecService(BelongDisSpecRepository belongDisSpecRepository) {
        this.belongDisSpecRepository = belongDisSpecRepository;
    }

    private List<BelongDisSpec> belongDisSpecs;


    @Override
    public void create(BelongDisSpec belongDisSpec) {

    }

    @Override
    public BelongDisSpec getBelongDisSpec(int id) {
        return null;
    }

    @Override
    public void deleteBelongDisSpec(int id) {

    }

    @Override
    public List<BelongDisSpec> getAll() {
        return null;
    }

    @Override
    public void updateBelongDisSpec(BelongDisSpec belongDisSpec) {

    }
}
