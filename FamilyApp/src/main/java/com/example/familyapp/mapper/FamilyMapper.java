package com.example.familyapp.mapper;

import com.example.familyapp.domain.Family;
import com.example.familyapp.dto.FamilyDto;
import org.springframework.stereotype.Service;

@Service
public class FamilyMapper {

    public FamilyDto mapToFamilyDto(final Family family) {
        return new FamilyDto(
                family.getId(),
                family.getFamilyName(),
                family.getNrOfInfants(),
                family.getNrOfChildren(),
                family.getNrOfAdults()
        );
    }

    public Family mapToFamily(final FamilyDto familyDto) {
        return new Family(
                familyDto.getId(),
                familyDto.getFamilyName(),
                familyDto.getNrOfInfants(),
                familyDto.getNrOfChildren(),
                familyDto.getNrOfAdults()
        );
    }
}
