package ru.kursavaya.vlad.thdkursovaya.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.Publish;
import ru.kursavaya.vlad.thdkursovaya.repository.PublishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublishService implements IPublishService{
    private final PublishRepository publishRepository;
    @Autowired
    public PublishService(PublishRepository publishRepository) {
        this.publishRepository = publishRepository;
    }
    private List<Publish> publish;

    @Override
    public void create(Publish publish) {
        publishRepository.save(publish);
    }

    @Override
    public Publish getPublish(int id) {
        Optional<Publish> optionalPublish = publishRepository.findById((long) id);
        if (optionalPublish.isPresent()) {
            return optionalPublish.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePublish(int id) {
        publishRepository.deleteById((long) id);
    }

    @Override
    public List<Publish> getAll() {
        return (List<Publish>) publishRepository.findAll();
    }

    @Override
    public void updatePublish(Publish publish) {
        publishRepository.save(publish);
    }
}
