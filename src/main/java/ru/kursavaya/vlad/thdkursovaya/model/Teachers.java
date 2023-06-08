    package ru.kursavaya.vlad.thdkursovaya.model;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "teachers")
    public class Teachers {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "full_name")
        private String fullName;

        @ManyToOne
        @JoinColumn(name = "fk_id_plan_of_work")
        private PlanOfWork planOfWork;

        @ManyToMany
        @JoinTable(
                name = "fk_teacher_dep",
                joinColumns = @JoinColumn(name = "id_teacher"),
                inverseJoinColumns = @JoinColumn(name = "id_departament")
        )
        private Set<Departaments> departaments = new HashSet<>();

        @ManyToMany(mappedBy = "teachers")
        private Set<Discipline> discipline  = new HashSet<>();


    }
