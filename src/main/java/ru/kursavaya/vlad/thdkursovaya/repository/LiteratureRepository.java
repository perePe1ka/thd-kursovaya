package ru.kursavaya.vlad.thdkursovaya.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kursavaya.vlad.thdkursovaya.model.Literature;

public interface LiteratureRepository extends CrudRepository<Literature, Long> {
}
