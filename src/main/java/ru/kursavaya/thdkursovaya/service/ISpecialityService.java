package ru.kursavaya.thdkursovaya.service;

import ru.kursavaya.thdkursovaya.model.Leads;
import ru.kursavaya.thdkursovaya.model.Publish;
import ru.kursavaya.thdkursovaya.model.Speciality;

import java.util.List;

public interface ISpecialityService {
    void Speciality(Speciality speciality);

    Leads getSpeciality(int id);

    void deleteSpeciality(int id);

    List<Speciality> getAll();

    void updateSpeciality(Speciality speciality);
}
