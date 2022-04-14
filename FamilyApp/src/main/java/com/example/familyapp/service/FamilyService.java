package com.example.familyapp.service;

import com.example.familyapp.domain.Family;
import com.example.familyapp.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    public List<Family> getAll() {
        return familyRepository.findAll();
    }

    public Optional<Family> findById(final Long id) {
        return familyRepository.findById(id);
    }

    public void save(final Family family) {
        familyRepository.save(family);
    }
}
