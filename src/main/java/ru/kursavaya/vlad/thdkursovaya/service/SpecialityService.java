package ru.kursavaya.vlad.thdkursovaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kursavaya.vlad.thdkursovaya.model.Speciality;
import ru.kursavaya.vlad.thdkursovaya.repository.SpecialityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService implements ISpecialityService{
    private final SpecialityRepository specialityRepository;
    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }
    private List<Speciality> speciality;

    @Override
    public void create(Speciality speciality) {
        specialityRepository.save(speciality);
    }

    @Override
    public Speciality getSpeciality(int id) {
        Optional<Speciality> optionalSpeciality = specialityRepository.findById((long) id);
        if (optionalSpeciality.isPresent()) {
            return optionalSpeciality.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteSpeciality(int id) {
        specialityRepository.deleteById((long) id);
    }

    @Override
    public List<Speciality> getAll() {
        return (List<Speciality>) specialityRepository.findAll();
    }

    @Override
    public void updateSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }
}
