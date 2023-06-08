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
@Table(name = "literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;

    @Column
    private String name;
    @Column
    private String  type_of_material;
    @ManyToOne
    @JoinColumn(name = "fk_id_speciality")
    private Speciality speciality;
    @ManyToOne
    @JoinColumn(name = "fk_id_discipline")
    private Discipline discipline;
    @ManyToOne
    @JoinColumn(name = "fk_id_teachers")
    private Teachers teachers;



    @ManyToMany
    @JoinTable(
            name = "fk_izdayot",
            joinColumns = @JoinColumn(name = "id_literature"),
            inverseJoinColumns = @JoinColumn(name = "id_departament")
    )
    private Set<Departaments> departaments = new HashSet<>();
}
