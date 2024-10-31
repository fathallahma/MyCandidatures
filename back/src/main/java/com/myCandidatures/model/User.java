package com.myCandidatures.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

//for hibernate
@Entity
//for database
@Table(name = "User")
@Data
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "USER_SEQUENCE_ID",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
