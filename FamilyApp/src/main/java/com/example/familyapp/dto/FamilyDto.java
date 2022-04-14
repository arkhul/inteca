package com.example.familyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDto {

    private Long id;

    private String familyName;

    private int nrOfInfants;

    private int nrOfChildren;

    private int nrOfAdults;

    private List<FamilyMemberDto> familyMemberDtoList = new ArrayList<>();

    public FamilyDto(Long id, String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        this.id = id;
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
    }
}
