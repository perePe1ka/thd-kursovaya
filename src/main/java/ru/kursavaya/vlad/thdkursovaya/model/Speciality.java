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
@Table (name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @Column
    private String name;



    @ManyToMany
    @JoinTable(
            name = "fk_spec_discip",
            joinColumns = @JoinColumn(name = "id_speciality"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline")
    )
    private Set<Discipline> discipline = new HashSet<>();

}
