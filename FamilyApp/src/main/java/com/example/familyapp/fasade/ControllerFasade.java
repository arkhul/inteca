package com.example.familyapp.fasade;

import com.example.familyapp.config.EndpointConfig;
import com.example.familyapp.dto.FamilyDto;
import com.example.familyapp.dto.FamilyMemberDto;
import com.example.familyapp.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ControllerFasade {

    private final FamilyService familyService;

    private final RestTemplate restTemplate;

    private final EndpointConfig endpointConfig;

    public long getTableSize() {
        long size = familyService.getAll().size();
        size++;
        return size;
    }

    public FamilyMemberDto[] getFamilyMemberDtoObjects(final Long id) {
        ResponseEntity<FamilyMemberDto[]> responseEntity = restTemplate
                .getForEntity(
                        endpointConfig.getEndpoint() + id,
                        FamilyMemberDto[].class);
        return responseEntity.getBody();
    }

    public void postFamilyMemberDtoObjects(final FamilyDto familyDto) {
        for (FamilyMemberDto familyMemberDto : familyDto.getFamilyMemberDtoList()) {
            restTemplate
                    .postForObject(
                            endpointConfig.getEndpoint() + getTableSize(),
                            familyMemberDto,
                            FamilyMemberDto.class);
        }
    }
}
