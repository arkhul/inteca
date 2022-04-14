package com.example.familymemberapp.controller;

import com.example.familymemberapp.domain.FamilyMember;
import com.example.familymemberapp.dto.FamilyMemberDto;
import com.example.familymemberapp.mapper.FamilyMemberMapper;
import com.example.familymemberapp.service.FamilyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FamilyMemberConrtoller {

    private final FamilyMemberMapper familyMemberMapper;

    private final FamilyMemberService familyMemberService;

    @GetMapping("/{id}")
    public List<FamilyMemberDto> searchFamilyMember(@PathVariable Long id) {
        return familyMemberMapper.mapToFamilyMemberDtoList(familyMemberService.findByFamilyId(id));
    }

    @PostMapping("/{id}")
    public void createFamilyMember(@PathVariable Long id, @RequestBody FamilyMemberDto familyMemberDto) {
        FamilyMember familyMember = familyMemberMapper.mapToFamilyMember(familyMemberDto);
        familyMember.setFamilyId(id);
        familyMemberService.save(familyMember);
    }
}
