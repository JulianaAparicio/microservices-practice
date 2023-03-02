package com.example.apicustomer.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String IdType;

    @NotNull
    @Column
    private String idNumber;

    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private String genre;

    @NotNull
    @Column
    private LocalDate birthDate;
}
