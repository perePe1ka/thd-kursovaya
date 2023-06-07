package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.Literature;
import ru.kursavaya.vlad.thdkursovaya.repository.LiteratureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LiteratureService implements ILiteratureService{
    private final LiteratureRepository literatureRepository;
    @Autowired
    public LiteratureService(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }
    private List<Literature> literature;


    @Override
    public void create(Literature literature) {
        literatureRepository.save(literature);
    }

    @Override
    public Literature getLiterature(int id) {
        Optional<Literature> optionalLiterature = literatureRepository.findById((long) id);
        if (optionalLiterature.isPresent()) {
            return optionalLiterature.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteLiterature(int id) {
        literatureRepository.deleteById((long) id);
    }

    @Override
    public List<Literature> getAll() {
        return (List<Literature>) literatureRepository.findAll();
    }

    @Override
    public void updateLiterature(Literature literature) {
        literatureRepository.save(literature);
    }
}
