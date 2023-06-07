package ru.kursavaya.thdkursovaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fk_teacher_dep")
public class BelongTeachDep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id_teacher;

    @Column
    private int id_departament;

    @Column
    private int date_start_work;
}
