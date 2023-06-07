package ru.kursavaya.vlad.thdkursovaya.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "plan_of_works")
public class PlanOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String deadline;

    @Column
    private String workload;

    @ManyToOne
    @JoinColumn(name = "fk_departaments_id")
    private Departaments department;

}
