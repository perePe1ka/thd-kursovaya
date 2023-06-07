package ru.kursavaya.vlad.thdkursovaya.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kursavaya.vlad.thdkursovaya.model.Discipline;

public interface DisciplineRepository extends CrudRepository<Discipline, Long> {
}
