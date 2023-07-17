package com.offshoringhub.offreservice.dto;


import com.offshoringhub.offreservice.models.Experience;
import com.offshoringhub.offreservice.models.JobType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationRequest {
    private Experience experience;
    private JobType jobType;
    private int nbr_participant;
    private double budget;
    private int duration;
}
