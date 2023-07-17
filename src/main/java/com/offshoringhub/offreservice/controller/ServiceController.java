package com.offshoringhub.offreservice.controller;


import com.offshoringhub.offreservice.dto.DemandeServiceRequest;
import com.offshoringhub.offreservice.dto.DemandeServiceResponse;
import com.offshoringhub.offreservice.dto.OfferServiceRequest;
import com.offshoringhub.offreservice.dto.OfferServiceResponse;
import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offerservice/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;


    //Offer Controller
    @GetMapping("/offer")
    public ResponseEntity<List<OfferServiceResponse>> getAllOffer(){
        List<OfferServiceResponse> offerServiceResponses = serviceService.getAllOffer();
        if(offerServiceResponses.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(offerServiceResponses);
    }

    @GetMapping("/offer/{id}")
    public ResponseEntity<OfferServiceResponse> getOfferById(@PathVariable("id") int id){
        OfferServiceResponse offerServiceResponse = serviceService.getOfferById(id);
        return ResponseEntity.ok().body(offerServiceResponse);
    }

    @GetMapping("/offer/{company_id}")
    public ResponseEntity<List<OfferServiceResponse>> getOfferByCompany(@PathVariable("company_id") int id){
        List<OfferServiceResponse> offerServiceResponses = serviceService.getOfferByCompany(id);
        return ResponseEntity.ok().body(offerServiceResponses);
    }

    @PostMapping("/offer")
    public ResponseEntity<Void> createOffer(@RequestBody OfferServiceRequest offerServiceRequest){
        serviceService.addOffer(offerServiceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/offer/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable("id") int id){
        serviceService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/offer/{id}")
    public ResponseEntity<Void> updateOffer(@PathVariable("id") int id,@RequestBody OfferServiceRequest offerServiceRequest){
        serviceService.updateOffer(id,offerServiceRequest);
        return ResponseEntity.ok().build();
    }

    //Demande Controller

    @GetMapping("/demand")
    public ResponseEntity<List<DemandeServiceResponse>> getAllDemand(){
        List<DemandeServiceResponse> demandeServices = serviceService.getAllDemands();
        if(demandeServices.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(demandeServices);
    }

    @GetMapping("/demand/{id}")
    public ResponseEntity<DemandeServiceResponse> getDemandById(@PathVariable("id") int id){
        DemandeServiceResponse demandeServiceResponse = serviceService.getDemandById(id);
        return ResponseEntity.ok().body(demandeServiceResponse);
    }

    @GetMapping("/demand/{company_id}")
    public ResponseEntity<List<DemandeServiceResponse>> getDemandByCompany(@PathVariable("company_id") int id){
        List<DemandeServiceResponse> demandeServiceResponse = serviceService.getDemandByCompany(id);
        return ResponseEntity.ok().body(demandeServiceResponse);
    }

    @PostMapping("/demand")
    public ResponseEntity<Void> createDemand(@RequestBody DemandeServiceRequest demandeServiceRequest){
        serviceService.addDemand(demandeServiceRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("demand/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable("id") int id){
        serviceService.deleteDemand(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("demand/{id}")
    public ResponseEntity<Void> updateDemand(@PathVariable("id") int id,
                                             @RequestBody DemandeServiceRequest demandeServiceRequest){
        serviceService.updateDemand(id,demandeServiceRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/demand/{test_id}")
    public ResponseEntity<Void> affectTestToDemand(@RequestParam("demand_id") int demand,
                                                   @PathVariable("test_id") int test){
        serviceService.affectTestToDemand(demand,test);
        return ResponseEntity.ok().build();
    }
}
