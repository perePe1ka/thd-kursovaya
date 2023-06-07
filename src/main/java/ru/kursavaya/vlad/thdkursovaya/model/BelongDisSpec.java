package ru.kursavaya.vlad.thdkursovaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fk_spec_discip")
public class BelongDisSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_speciality")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "id_discipline")
    private Discipline discipline;
}
