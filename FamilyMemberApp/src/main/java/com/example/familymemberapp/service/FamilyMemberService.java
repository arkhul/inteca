package com.example.familymemberapp.service;

import com.example.familymemberapp.domain.FamilyMember;
import com.example.familymemberapp.repository.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    public List<FamilyMember> findByFamilyId(final Long id) {
        return familyMemberRepository.findByFamilyId(id);
    }

    public void save(final FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
    }
}
