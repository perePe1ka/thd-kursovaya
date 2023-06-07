package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Speciality;

import java.util.List;

public interface ISpecialityService {
    void create(Speciality speciality);

    Speciality getSpeciality(int id);

    void deleteSpeciality(int id);

    List<Speciality> getAll();

    void updateSpeciality(Speciality speciality);
}
