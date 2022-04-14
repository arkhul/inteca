package com.example.familyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMemberDto {

    private String givenName;

    private String familyName;

    private int age;
}