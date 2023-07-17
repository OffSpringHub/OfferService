package com.offshoringhub.offreservice.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("demandeservice")
@Getter
@Setter
@NoArgsConstructor
public class DemandeService extends Service{
    private int test_id;


    @Builder
    public DemandeService(int id, int company_id, LocalDateTime start_date, LocalDateTime end_date, String name, String description, ServiceStatus serviceStatus, List<Information> information, int test_id) {
        super(id, company_id, start_date, end_date, name, description, serviceStatus, information);
        this.test_id = test_id;
    }
}
