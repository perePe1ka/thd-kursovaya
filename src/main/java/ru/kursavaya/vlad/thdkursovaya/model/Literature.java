package ru.kursavaya.vlad.thdkursovaya.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private char type_of_material;
    @Column
    private int fk_id_speciality;
    @Column
    private int fk_id_discipline;
    @Column
    private int fk_id_teachers;
}
