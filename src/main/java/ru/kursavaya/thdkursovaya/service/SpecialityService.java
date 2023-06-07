package ru.kursavaya.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Speciality;
import ru.kursavaya.thdkursovaya.repository.SpecialityRepository;

import java.util.List;

@Service
public class SpecialityService implements ISpecialityService{
    private final SpecialityRepository specialityRepository;
    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }
    private List<Speciality> speciality;

    @Override
    public void Speciality(Speciality speciality) {

    }

    @Override
    public Leads getSpeciality(int id) {
        return null;
    }

    @Override
    public void deleteSpeciality(int id) {

    }

    @Override
    public List<Speciality> getAll() {
        return null;
    }

    @Override
    public void updateSpeciality(Speciality speciality) {

    }
}
