package com.offshoringhub.offreservice.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private Experience experience;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private int nbr_participant;
    private double budget;
    private int duration;
}
