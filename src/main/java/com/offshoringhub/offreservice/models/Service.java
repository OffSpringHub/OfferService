package com.offshoringhub.offreservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "service_type",discriminatorType = DiscriminatorType.STRING)
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int company_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceStatus serviceStatus;
    @OneToMany
    private List<Information> information;
}
