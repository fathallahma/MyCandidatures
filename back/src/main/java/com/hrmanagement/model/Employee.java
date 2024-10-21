package com.hrmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

//for hibernate
@Entity
//for database
@Table(name = "Employee")
@Data
@AllArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "EMPLOYEE_SEQUENCE_ID",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "employee_sequence"
    )
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
