package com.example.familymemberapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private int age;

    @NotNull
    private Long familyId;

    public FamilyMember(String givenName, String familyName, int age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }
}

