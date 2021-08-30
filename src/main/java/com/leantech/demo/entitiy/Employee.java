package com.leantech.demo.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "employee")
    private List<Person> personList;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    private float salary;

    private String name;

}
