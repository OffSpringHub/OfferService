package com.offshoringhub.offreservice.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int employee_id;
    @Enumerated(EnumType.STRING)
    private CandidatureStatus status;
}
