package ru.kursavaya.thdkursovaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "plan_of_work")
public class PlanOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @Column
    private char name;
    @Column
    private char deadline;
    @Column
    private char workload;
    @Column
    private int fk_departament_id;



}
