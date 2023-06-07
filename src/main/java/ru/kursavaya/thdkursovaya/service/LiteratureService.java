package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Literature;
import ru.kursavaya.thdkursovaya.repository.LiteratureRepository;

import java.util.List;

@Service
public class LiteratureService implements ILiteratureService{
    private final LiteratureRepository literatureRepository;
    @Autowired
    public LiteratureService(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }
    private List<Literature> literature;


    @Override
    public void Literature(Literature literature) {

    }

    @Override
    public Leads getLiterature(int id) {
        return null;
    }

    @Override
    public void deleteLiterature(int id) {

    }

    @Override
    public List<Literature> getAll() {
        return null;
    }

    @Override
    public void updateLiterature(Literature literature) {

    }
}
