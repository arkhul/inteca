package com.example.familymemberapp.mapper;

import com.example.familymemberapp.domain.FamilyMember;
import com.example.familymemberapp.dto.FamilyMemberDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyMemberMapper {

    public FamilyMember mapToFamilyMember(final FamilyMemberDto familyMemberDto) {
        return new FamilyMember(
                familyMemberDto.getFamilyName(),
                familyMemberDto.getGivenName(),
                familyMemberDto.getAge()
        );
    }

    public FamilyMemberDto mapToFamilyMemberDto(final FamilyMember familyMember) {
        return new FamilyMemberDto(
                familyMember.getGivenName(),
                familyMember.getFamilyName(),
                familyMember.getAge()
        );
    }

    public List<FamilyMemberDto> mapToFamilyMemberDtoList(final List<FamilyMember> familyMembers) {
        return familyMembers.stream()
                .map(this::mapToFamilyMemberDto)
                .collect(Collectors.toList());
    }
}
