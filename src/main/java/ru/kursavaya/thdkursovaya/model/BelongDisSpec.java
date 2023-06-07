package ru.kursavaya.thdkursovaya.model;

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
    private int id_speciality;

    @Column
    private int id_discipline;
}
