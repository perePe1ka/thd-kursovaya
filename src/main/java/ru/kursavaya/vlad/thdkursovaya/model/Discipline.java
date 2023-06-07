package ru.kursavaya.vlad.thdkursovaya.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @Column
    private String  name;
    @Column
    private String  class_type;

    @ManyToMany
    @JoinTable(
            name = "fk_spec_discip",
            joinColumns = @JoinColumn(name = "id_discipline"),
            inverseJoinColumns = @JoinColumn(name = "id_speciality")
    )
    private Set<Speciality> speciality = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "vedet",
            joinColumns = @JoinColumn(name = "id_discipline"),
            inverseJoinColumns = @JoinColumn(name = "id_teacher")
    )
    private Set<Teachers> teachers = new HashSet<>();



}
