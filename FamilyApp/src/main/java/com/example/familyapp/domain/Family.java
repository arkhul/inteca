package com.example.familyapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Family {

    @Id
    private Long id;

    @NotNull
    private String familyName;

    @NotNull
    private int nrOfInfants;

    @NotNull
    private int nrOfChildren;

    @NotNull
    private int nrOfAdults;
}
