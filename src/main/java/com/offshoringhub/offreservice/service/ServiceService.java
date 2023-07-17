package com.offshoringhub.offreservice.service;


import com.offshoringhub.offreservice.dto.DemandeServiceRequest;
import com.offshoringhub.offreservice.dto.DemandeServiceResponse;
import com.offshoringhub.offreservice.dto.OfferServiceRequest;
import com.offshoringhub.offreservice.dto.OfferServiceResponse;
import com.offshoringhub.offreservice.exception.NotFoundException;
import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<OfferServiceResponse> getAllOffer() {
        List<OfferService> offerServices = serviceRepository.getAllOfferService();
        return offerServices.stream().map(this::mapToOfferServiceResponse).toList();
    }

    private OfferServiceResponse mapToOfferServiceResponse(OfferService service) {
        return OfferServiceResponse.builder()
                .serviceStatus(service.getServiceStatus())
                .id(service.getId())
                .name(service.getName())
                .start_date(service.getStart_date())
                .description(service.getDescription())
                .candidatures(service.getCandidatures())
                .information(service.getInformation())
                .company_id(service.getCompany_id())
                .end_date(service.getEnd_date())
                .build();
    }

    public OfferServiceResponse getOfferById(int id) {
        OfferService offerService = (OfferService) serviceRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Offer Id"));
        return mapToOfferServiceResponse(offerService);
    }

    public void addOffer(OfferServiceRequest offerServiceRequest) {
        OfferService offerService = mapToOfferService(offerServiceRequest);
        serviceRepository.save(offerService);
    }

    private OfferService mapToOfferService(OfferServiceRequest offerServiceRequest) {
        return OfferService.builder()
                .serviceStatus(offerServiceRequest.getServiceStatus())
                .candidatures(offerServiceRequest.getCandidatures())
                .company_id(offerServiceRequest.getCompany_id())
                .description(offerServiceRequest.getDescription())
                .end_date(offerServiceRequest.getEnd_date())
                .start_date(offerServiceRequest.getStart_date())
                .name(offerServiceRequest.getName())
                .information(offerServiceRequest.getInformation())
                .build();
    }

    public void deleteOffer(int id) {
        OfferService offerService = (OfferService) serviceRepository.findById(id).orElseThrow(()-> new NotFoundException("Invalid Offer Id"));
        serviceRepository.delete(offerService);
    }

    public void updateOffer(int id, OfferServiceRequest offerServiceRequest) {
        OfferService offerService = (OfferService) serviceRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Offer Id"));
        offerService.setServiceStatus(offerServiceRequest.getServiceStatus());
        offerService.setDescription(offerServiceRequest.getDescription());
        offerService.setName(offerServiceRequest.getName());
        offerService.setInformation(offerServiceRequest.getInformation());
        offerService.setCompany_id(offerServiceRequest.getCompany_id());
        offerService.setEnd_date(offerServiceRequest.getEnd_date());
        offerService.setStart_date(offerServiceRequest.getStart_date());
        offerService.setCandidatures(offerServiceRequest.getCandidatures());
        serviceRepository.save(offerService);
    }

    public List<DemandeServiceResponse> getAllDemands() {
        List<DemandeService> demandServices = serviceRepository.getAllDemandService();
        return demandServices.stream().map(this::mapToDemandeServiceResponse).toList();
    }

    private DemandeServiceResponse mapToDemandeServiceResponse(DemandeService demandeService) {
        return DemandeServiceResponse.builder()
                .serviceStatus(demandeService.getServiceStatus())
                .test_id(demandeService.getTest_id())
                .company_id(demandeService.getCompany_id())
                .description(demandeService.getDescription())
                .end_date(demandeService.getEnd_date())
                .id(demandeService.getId())
                .information(demandeService.getInformation())
                .name(demandeService.getName())
                .start_date(demandeService.getStart_date())
                .build();
    }

    public DemandeServiceResponse getDemandById(int id) {
        DemandeService demandeService = (DemandeService) serviceRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Demand Id"));
        return mapToDemandeServiceResponse(demandeService);
    }

    public void addDemand(DemandeServiceRequest demandeServiceRequest) {
        DemandeService demandeService = mapToDemandeService(demandeServiceRequest);
        serviceRepository.save(demandeService);
    }

    private DemandeService mapToDemandeService(DemandeServiceRequest demandeServiceRequest) {
        return DemandeService.builder()
                .serviceStatus(demandeServiceRequest.getServiceStatus())
                .name(demandeServiceRequest.getName())
                .company_id(demandeServiceRequest.getCompany_id())
                .description(demandeServiceRequest.getDescription())
                .test_id(demandeServiceRequest.getTest_id())
                .end_date(demandeServiceRequest.getEnd_date())
                .start_date(demandeServiceRequest.getStart_date())
                .information(demandeServiceRequest.getInformation())
                .build();
    }

    public void deleteDemand(int id) {
        DemandeService demandeService = (DemandeService) serviceRepository.findById(id).orElseThrow(()-> new NotFoundException("Invalid Demand Id"));
        serviceRepository.delete(demandeService);
    }

    public void updateDemand(int id, DemandeServiceRequest demandeServiceRequest) {
        DemandeService demandeService = (DemandeService) serviceRepository.findById(id).orElseThrow(()->new NotFoundException("Invalid Demand Id"));
        demandeService.setServiceStatus(demandeServiceRequest.getServiceStatus());
        demandeService.setTest_id(demandeServiceRequest.getTest_id());
        demandeService.setDescription(demandeServiceRequest.getDescription());
        demandeService.setInformation(demandeServiceRequest.getInformation());
        demandeService.setEnd_date(demandeServiceRequest.getEnd_date());
        demandeService.setStart_date(demandeServiceRequest.getStart_date());
        demandeService.setName(demandeServiceRequest.getName());
        demandeService.setCompany_id(demandeServiceRequest.getCompany_id());
        serviceRepository.save(demandeService);
    }

    public List<DemandeServiceResponse> getDemandByCompany(int id) {
        List<DemandeService> demandeService = serviceRepository.getDemandByCompany(id);
        return demandeService.stream().map(this::mapToDemandeServiceResponse).toList();
    }

    public List<OfferServiceResponse> getOfferByCompany(int id) {
        List<OfferService> offerServices = serviceRepository.getOfferByCompany(id);
        return offerServices.stream().map(this::mapToOfferServiceResponse).toList();
    }

    public void affectTestToDemand(int demand, int test) {
        DemandeService demandeService = (DemandeService) serviceRepository.findById(demand).orElseThrow(()->new NotFoundException("Invalid Demand id"));
        demandeService.setTest_id(test);
        serviceRepository.save(demandeService);
    }
}
