package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.BelongDisSpec;
import ru.kursavaya.vlad.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.vlad.thdkursovaya.repository.BelongDisSpecRepository;

import java.util.List;
import java.util.Optional;

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
        belongDisSpecRepository.save(belongDisSpec);
    }

    @Override
    public BelongDisSpec getBelongDisSpec(int id) {
        Optional<BelongDisSpec> optionalBelongDisSpec = belongDisSpecRepository.findById((long) id);
        if (optionalBelongDisSpec.isPresent()) {
            return optionalBelongDisSpec.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteBelongDisSpec(int id) {
        belongDisSpecRepository.deleteById((long) id);
    }

    @Override
    public List<BelongDisSpec> getAll() {
        return (List<BelongDisSpec>) belongDisSpecRepository.findAll();
    }

    @Override
    public void updateBelongDisSpec(BelongDisSpec belongDisSpec) {
        belongDisSpecRepository.save(belongDisSpec);
    }
}
