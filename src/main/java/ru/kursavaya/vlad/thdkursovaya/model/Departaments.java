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
@Table(name = "departments")
public class Departaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "departaments")
    private Set<Teachers> teachers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "fk_izdayot",
            joinColumns = @JoinColumn(name = "id_departament"),
            inverseJoinColumns = @JoinColumn(name = "id_literature")
    )
    private Set<Literature> literature = new HashSet<>();
}
