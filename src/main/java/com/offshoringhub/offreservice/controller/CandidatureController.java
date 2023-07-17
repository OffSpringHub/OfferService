package com.offshoringhub.offreservice.controller;


import com.offshoringhub.offreservice.dto.CandidatureRequest;
import com.offshoringhub.offreservice.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/offerservice/candidature")
public class CandidatureController {
    @Autowired
    private CandidatureService candidatureService;

    @PostMapping("/proposal/{id}")
    public ResponseEntity<Void> affectCandidatureToProposal(@PathVariable("id") int id,
                                                            @RequestBody List<CandidatureRequest> candidatureRequest){
        candidatureService.affectCandidature(id,candidatureRequest);
        return ResponseEntity.ok().build();
    }
}
