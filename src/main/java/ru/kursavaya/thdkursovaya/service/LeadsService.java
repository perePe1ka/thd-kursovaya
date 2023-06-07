package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.repository.LeadsRepository;

import java.util.List;

@Service
public class LeadsService implements ILeadsService{
    private final LeadsRepository leadsRepository;
    @Autowired
    public LeadsService(LeadsRepository leadsRepository) {
        this.leadsRepository = leadsRepository;
    }

    private List<Leads> leads;

    @Override
    public void create(Leads leads) {

    }

    @Override
    public Leads getLeads(int id) {
        return null;
    }

    @Override
    public void deleteLeads(int id) {

    }

    @Override
    public List<Leads> getAll() {
        return null;
    }

    @Override
    public void updateLeads(Leads leads) {

    }
}
