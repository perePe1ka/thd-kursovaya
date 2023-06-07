package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.vlad.thdkursovaya.model.Leads;
import ru.kursavaya.vlad.thdkursovaya.repository.LeadsRepository;

import java.util.List;
import java.util.Optional;

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
        leadsRepository.save(leads);
    }

    @Override
    public Leads getLeads(int id) {
        Optional<Leads> optionalLeads = leadsRepository.findById((long) id);
        if (optionalLeads.isPresent()) {
            return optionalLeads.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteLeads(int id) {
        leadsRepository.deleteById((long) id);
    }

    @Override
    public List<Leads> getAll() {
        return (List<Leads>) leadsRepository.findAll();
    }

    @Override
    public void updateLeads(Leads leads) {
        leadsRepository.save(leads);
    }
}
