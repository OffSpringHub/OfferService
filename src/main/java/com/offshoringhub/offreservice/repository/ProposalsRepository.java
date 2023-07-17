package com.offshoringhub.offreservice.repository;

import com.offshoringhub.offreservice.models.Proposals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProposalsRepository extends JpaRepository<Proposals,Integer> {
    @Query("SELECT proposal FROM Proposals proposal JOIN proposal.demandeService dp JOIN proposal.offreService op WHERE dp.company_id=:id OR op.company_id=:id")
    public List<Proposals> getByCompany(@Param("id") int id);
}
