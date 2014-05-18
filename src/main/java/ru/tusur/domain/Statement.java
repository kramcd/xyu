package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Statement {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private applicationType applicationType;

    @Enumerated(EnumType.STRING)
    private applicationStatus applicationStatus;

    @ManyToOne
    @JoinColumn(name = "idEmployees")
    private Employees employees;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;


}
