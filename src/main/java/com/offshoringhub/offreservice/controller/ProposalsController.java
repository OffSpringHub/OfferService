package com.offshoringhub.offreservice.controller;


import com.offshoringhub.offreservice.dto.ProposalsRequest;
import com.offshoringhub.offreservice.dto.ProposalsResponse;
import com.offshoringhub.offreservice.repository.ProposalsRepository;
import com.offshoringhub.offreservice.service.ProposalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offerservice/proposals")
public class ProposalsController {
    @Autowired
    private ProposalsService proposalsService;

    @GetMapping
    public ResponseEntity<List<ProposalsResponse>> getProposalsByCompany(@RequestParam("company_id") int id){
        List<ProposalsResponse> proposalsResponses = proposalsService.getByCompany(id);
        return ResponseEntity.ok().body(proposalsResponses);
    }


    @PostMapping
    public ResponseEntity<Void> makeAProposal(@RequestBody ProposalsRequest proposalsRequest){
        proposalsService.makeProposal(proposalsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/selection/{id}")
    public ResponseEntity<Void> preSelectionPhase(@PathVariable("id") int id){
        proposalsService.preSelection(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/testing/{id}")
    public ResponseEntity<Void> testingPhase (@PathVariable("id") int id){
        proposalsService.testing(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<Void> donePhase(@PathVariable("id") int id){
        proposalsService.done(id);
        return ResponseEntity.ok().build();
    }

}
