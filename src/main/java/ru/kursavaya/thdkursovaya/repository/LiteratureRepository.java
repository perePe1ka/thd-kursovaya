package ru.kursavaya.thdkursovaya.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kursavaya.thdkursovaya.model.BelongTeachDep;
import ru.kursavaya.thdkursovaya.model.Literature;

public interface LiteratureRepository extends CrudRepository<Literature, Long> {
}
