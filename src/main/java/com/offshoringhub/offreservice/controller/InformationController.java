package com.offshoringhub.offreservice.controller;


import com.offshoringhub.offreservice.dto.InformationRequest;
import com.offshoringhub.offreservice.dto.InformationResponse;
import com.offshoringhub.offreservice.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offerservice/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    @GetMapping
    public ResponseEntity<List<InformationResponse>> informationList(){
        List<InformationResponse> informationResponses = informationService.getAll();
        return ResponseEntity.ok().body(informationResponses);
    }
    @PostMapping
    public ResponseEntity<Void> createInformation(@RequestBody InformationRequest informationRequest){
        informationService.createInfo(informationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformation(@PathVariable("id") int id){
        informationService.deleteInfo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInformation(@PathVariable int id,
                                                  @RequestBody InformationRequest informationRequest){
        informationService.updateInfo(id,informationRequest);
        return ResponseEntity.ok().build();
    }
}
