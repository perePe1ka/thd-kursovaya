package ru.kursavaya.vlad.thdkursovaya.service;

import ru.kursavaya.vlad.thdkursovaya.model.Leads;

import java.util.List;

public interface ILeadsService {
    void create(Leads leads);

    Leads getLeads(int id);

    void deleteLeads(int id);

    List<Leads> getAll();

    void updateLeads(Leads leads);
}
