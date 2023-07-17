package com.offshoringhub.offreservice.service;


import com.offshoringhub.offreservice.dto.CandidatureRequest;
import com.offshoringhub.offreservice.exception.NotFoundException;
import com.offshoringhub.offreservice.models.Candidature;
import com.offshoringhub.offreservice.models.CandidatureStatus;
import com.offshoringhub.offreservice.models.Proposals;
import com.offshoringhub.offreservice.repository.CandidatureRepository;
import com.offshoringhub.offreservice.repository.ProposalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private ProposalsRepository proposalsRepository;


    public void affectCandidature(int id, List<CandidatureRequest> candidatureRequest) {
        Proposals proposals = proposalsRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Proposal Id"));
        proposals.getOffreService().setCandidatures(candidatureRequest.stream().map(this::mapToCandidature).toList());
        proposalsRepository.save(proposals);
    }

    private Candidature mapToCandidature(CandidatureRequest candidatureRequest) {
        return Candidature.builder()
                .employee_id(candidatureRequest.getEmployee_id())
                .status(CandidatureStatus.AVAILABLE)
                .id(candidatureRequest.getId())
                .build();
    }
}
