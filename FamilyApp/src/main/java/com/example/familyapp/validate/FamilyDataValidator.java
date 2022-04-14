package com.example.familyapp.validate;

import com.example.familyapp.dto.FamilyDto;
import com.example.familyapp.dto.FamilyMemberDto;
import org.springframework.stereotype.Service;

@Service
public class FamilyDataValidator {

    public int validateFamilyData(final FamilyDto familyDto) {
        return adultsAgeChecker(familyDto) + childrenAgeChecker(familyDto) + infantsAgeChecker(familyDto);
    }

    private int adultsAgeChecker(final FamilyDto familyDto) {
        int adults = familyDto.getNrOfAdults();
        long result = familyDto.getFamilyMemberDtoList().stream()
                .map(FamilyMemberDto::getAge)
                .filter(f -> f >= 16)
                .count();
        return adults == result ? 1 : 0;
    }

    private int childrenAgeChecker(final FamilyDto familyDto) {
        int adults = familyDto.getNrOfChildren();
        long result = familyDto.getFamilyMemberDtoList().stream()
                .map(FamilyMemberDto::getAge)
                .filter(f -> f >= 4 && f < 16)
                .count();
        return adults == result ? 1 : 0;
    }

    private int infantsAgeChecker(final FamilyDto familyDto) {
        int adults = familyDto.getNrOfInfants();
        long result = familyDto.getFamilyMemberDtoList().stream()
                .map(FamilyMemberDto::getAge)
                .filter(f -> f > 0 && f < 4)
                .count();
        return adults == result ? 1 : 0;
    }
}
