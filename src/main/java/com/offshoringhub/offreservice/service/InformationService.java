package com.offshoringhub.offreservice.service;

import com.offshoringhub.offreservice.dto.InformationRequest;
import com.offshoringhub.offreservice.dto.InformationResponse;
import com.offshoringhub.offreservice.exception.NotFoundException;
import com.offshoringhub.offreservice.models.Information;
import com.offshoringhub.offreservice.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;


    public List<InformationResponse> getAll() {
        List<Information> information = informationRepository.findAll();
        return information.stream().map(this::mapToInformationResponse).toList();
    }

    private InformationResponse mapToInformationResponse(Information information) {
        return InformationResponse.builder()
                .id(information.getId())
                .budget(information.getBudget())
                .duration(information.getDuration())
                .experience(information.getExperience())
                .jobType(information.getJobType())
                .nbr_participant(information.getNbr_participant())
                .build();
    }

    public void createInfo(InformationRequest informationRequest) {
        Information information = mapToInformation(informationRequest);
        informationRepository.save(information);
    }

    private Information mapToInformation(InformationRequest informationRequest) {
        return Information.builder()
                .budget(informationRequest.getBudget())
                .duration(informationRequest.getDuration())
                .experience(informationRequest.getExperience())
                .nbr_participant(informationRequest.getNbr_participant())
                .jobType(informationRequest.getJobType())
                .build();
    }

    public void deleteInfo(int id) {
        Information information = informationRepository.findById(id).orElseThrow(()->new NotFoundException(("Invalid Information Id")));
        informationRepository.delete(information);
    }

    public void updateInfo(int id, InformationRequest informationRequest) {
        Information information = informationRepository.findById(id).orElseThrow(()->new NotFoundException(("Invalid Information Id")));
        information.setBudget(informationRequest.getBudget());
        information.setDuration(informationRequest.getDuration());
        information.setExperience(informationRequest.getExperience());
        information.setNbr_participant(informationRequest.getNbr_participant());
        information.setJobType(informationRequest.getJobType());
        informationRepository.save(information);
    }
}
