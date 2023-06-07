package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Publish;
import ru.kursavaya.thdkursovaya.repository.PublishRepository;

import java.util.List;

@Service
public class PublishService implements IPublishService{
    private final PublishRepository publishRepository;
    @Autowired
    public PublishService(PublishRepository publishRepository) {
        this.publishRepository = publishRepository;
    }
    private List<Publish> publish;

    @Override
    public void Publish(Publish publish) {

    }

    @Override
    public Leads getPublish(int id) {
        return null;
    }

    @Override
    public void deletePublish(int id) {

    }

    @Override
    public List<Publish> getAll() {
        return null;
    }

    @Override
    public void updatePublish(Publish publish) {

    }
}
