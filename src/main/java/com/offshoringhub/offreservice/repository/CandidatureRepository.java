package com.offshoringhub.offreservice.repository;

import com.offshoringhub.offreservice.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature,Integer> {
}
