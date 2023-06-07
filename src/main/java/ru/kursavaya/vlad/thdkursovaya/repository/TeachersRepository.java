package ru.kursavaya.vlad.thdkursovaya.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kursavaya.vlad.thdkursovaya.model.Teachers;

public interface TeachersRepository extends CrudRepository<Teachers, Long> {
}
