package com.example.familyapp.controller;

import com.example.familyapp.domain.Family;
import com.example.familyapp.dto.FamilyDto;
import com.example.familyapp.exception.FamilyNotFoundException;
import com.example.familyapp.exception.InvalidInputException;
import com.example.familyapp.fasade.ControllerFasade;
import com.example.familyapp.mapper.FamilyMapper;
import com.example.familyapp.service.FamilyService;
import com.example.familyapp.validate.FamilyDataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FamilyController {

    private final FamilyMapper familyMapper;

    private final FamilyService familyService;

    private final FamilyDataValidator familyDataValidate;

    private final ControllerFasade controllerFasade;

    @GetMapping("/{id}")
    public FamilyDto getFamily(@PathVariable Long id) throws FamilyNotFoundException {
        FamilyDto familyDto = familyMapper.mapToFamilyDto(familyService.findById(id)
                .orElseThrow(FamilyNotFoundException::new));

        familyDto.setFamilyMemberDtoList(Arrays.stream(controllerFasade.getFamilyMemberDtoObjects(id))
                .collect(Collectors.toList()));

        return familyDto;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createFamily(@RequestBody FamilyDto familyDto) throws InvalidInputException {
        Family family = familyMapper.mapToFamily(familyDto);
        family.setId(controllerFasade.getTableSize());

        if (familyDataValidate.validateFamilyData(familyDto) != 3) {
            throw new InvalidInputException();
        } else {
            controllerFasade.postFamilyMemberDtoObjects(familyDto);
            long idValue = controllerFasade.getTableSize();
            familyService.save(family);
            return idValue;
        }
    }
}
