package com.offshoringhub.offreservice.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("offreservice")
public class OfferService extends Service{
    @OneToMany
    private List<Candidature> candidatures;

    @Builder
    public OfferService(int id, int company_id, LocalDateTime start_date, LocalDateTime end_date, String name, String description, ServiceStatus serviceStatus, List<Information> information, List<Candidature> candidatures) {
        super(id, company_id, start_date, end_date, name, description, serviceStatus, information);
        this.candidatures = candidatures;
    }

    public OfferService() {

    }
}
