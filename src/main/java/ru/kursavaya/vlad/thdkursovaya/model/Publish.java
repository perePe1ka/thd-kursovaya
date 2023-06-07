package ru.kursavaya.vlad.thdkursovaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fk_izdayot")
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_departament")
    private Departaments departaments;

    @ManyToOne
    @JoinColumn(name = "id_literature")
    private Literature literature;

    @Column
    private String date;
}
