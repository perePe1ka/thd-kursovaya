package ru.kursavaya.vlad.thdkursovaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vedet")
public class Leads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id_teacher;

    @Column
    private int id_discipline;
}
