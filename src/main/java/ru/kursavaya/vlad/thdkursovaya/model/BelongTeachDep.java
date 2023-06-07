package ru.kursavaya.vlad.thdkursovaya.model;

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
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teachers teacher;

    @ManyToOne
    @JoinColumn(name = "id_departament")
    private Departaments departaments;

    @Column(name = "date_start_work")
    private String dateStartWork;
}
