package com.offshoringhub.offreservice.service;


import com.offshoringhub.offreservice.dto.ProposalsRequest;
import com.offshoringhub.offreservice.dto.ProposalsResponse;
import com.offshoringhub.offreservice.exception.NotAuthorizedException;
import com.offshoringhub.offreservice.exception.NotFoundException;
import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.models.ProposalStatus;
import com.offshoringhub.offreservice.models.Proposals;
import com.offshoringhub.offreservice.repository.ProposalsRepository;
import com.offshoringhub.offreservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProposalsService {
    @Autowired
    private ProposalsRepository proposalsRepository;
    @Autowired
    private ServiceRepository serviceRepository;


    public List<ProposalsResponse> getByCompany(int id) {
        List<Proposals> proposals = proposalsRepository.getByCompany(id);
        return  proposals.stream().map(this::mapToProposalResponse).toList();
    }

    private ProposalsResponse mapToProposalResponse(Proposals proposals) {
        return ProposalsResponse.builder()
                .proposalStatus(proposals.getProposalStatus())
                .demandeService(proposals.getDemandeService())
                .offreService(proposals.getOffreService())
                .quiz_startDate(proposals.getQuiz_startDate())
                .quizDuration(proposals.getQuizDuration())
                .quiz_endDate(proposals.getQuiz_endDate())
                .id(proposals.getId())
                .build();
    }

    public void makeProposal(ProposalsRequest proposalsRequest) {
        OfferService offerService = (OfferService) serviceRepository.findById(proposalsRequest.getOffreService()).orElseThrow(()-> new NotFoundException("Invalid Offer Id"));
        DemandeService demandeService = (DemandeService) serviceRepository.findById(proposalsRequest.getDemandeService()).orElseThrow(()->new NotFoundException("Invalid Demand Id"));
        Proposals proposals = new Proposals();
        proposals.setQuiz_endDate(proposalsRequest.getQuiz_endDate());
        proposals.setProposalStatus(ProposalStatus.PENDING);
        proposals.setOffreService(offerService);
        proposals.setDemandeService(demandeService);
        proposals.setQuizDuration(proposalsRequest.getQuizDuration());
        proposals.setQuiz_endDate(proposalsRequest.getQuiz_endDate());
        proposalsRepository.save(proposals);
    }

    public void preSelection(int id) {
        Proposals proposals = proposalsRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Proposal Id"));
        if(proposals.getProposalStatus() == ProposalStatus.SELECTION || proposals.getProposalStatus() == ProposalStatus.TESTING || proposals.getProposalStatus() == ProposalStatus.DONE){
            throw new NotAuthorizedException("Proposal Already in Selection or Testing or Finished!");
        }
        proposals.setProposalStatus(ProposalStatus.SELECTION);
        proposalsRepository.save(proposals);
    }

    public void testing(int id) {
        Proposals proposals = proposalsRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Proposal Id"));
        if(proposals.getProposalStatus() == ProposalStatus.TESTING ||  proposals.getProposalStatus() == ProposalStatus.DONE){
            throw new NotAuthorizedException("Proposal Already in Testing or Finished !");
        }
        proposals.setProposalStatus(ProposalStatus.TESTING);
        proposalsRepository.save(proposals);
    }

    public void done(int id) {
        Proposals proposals = proposalsRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Proposal Id"));
        if(proposals.getProposalStatus() == ProposalStatus.DONE){
            throw new NotAuthorizedException("Proposal Already Finished !");
        }
        proposals.setProposalStatus(ProposalStatus.DONE);
        proposalsRepository.save(proposals);
    }
}
