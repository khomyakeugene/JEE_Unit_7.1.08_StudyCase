package com.company.model;

import javax.persistence.*;

/**
 * Created by Yevhen on 04.06.2016.
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private Position position;


    private Float salary;

}
