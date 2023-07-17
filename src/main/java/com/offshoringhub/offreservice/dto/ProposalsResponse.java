package com.offshoringhub.offreservice.dto;


import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.models.ProposalStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalsResponse {
    private int id;
    private OfferService offreService;
    private DemandeService demandeService;
    private ProposalStatus proposalStatus;
    private LocalDateTime quiz_startDate;
    private LocalDateTime quiz_endDate;
    private int quizDuration;
}
