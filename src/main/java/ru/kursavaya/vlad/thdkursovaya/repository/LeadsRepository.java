package ru.kursavaya.vlad.thdkursovaya.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kursavaya.vlad.thdkursovaya.model.Leads;

public interface LeadsRepository extends CrudRepository<Leads, Long> {
}
