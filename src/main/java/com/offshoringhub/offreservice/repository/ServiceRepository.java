package com.offshoringhub.offreservice.repository;

import com.offshoringhub.offreservice.models.DemandeService;
import com.offshoringhub.offreservice.models.OfferService;
import com.offshoringhub.offreservice.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    @Query("SELECT offer FROM OfferService offer")
    public List<OfferService> getAllOfferService();

    @Query("SELECT demand FROM DemandeService demand")
    public List<DemandeService> getAllDemandService();

    @Query("SELECT demand FROM DemandeService demand WHERE demand.company_id=:id")
    List<DemandeService> getDemandByCompany(@Param("id") int id);

    @Query("SELECT offer FROM OfferService offer WHERE offer.company_id=:id")
    List<OfferService> getOfferByCompany(@Param("id") int id);
}
