package com.offshoringhub.offreservice.dto;


import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.models.ProposalStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalsRequest {
    private int offreService;
    private int demandeService;
    private LocalDateTime quiz_startDate;
    private LocalDateTime quiz_endDate;
    private int quizDuration;
}
