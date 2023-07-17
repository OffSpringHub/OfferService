package com.offshoringhub.offreservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Proposals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private OfferService offreService;
    @ManyToOne
    private DemandeService demandeService;
    @Enumerated(EnumType.STRING)
    private ProposalStatus proposalStatus;
    private LocalDateTime quiz_startDate;
    private LocalDateTime quiz_endDate;
    private int quizDuration;
}
