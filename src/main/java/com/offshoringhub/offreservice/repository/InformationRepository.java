package com.offshoringhub.offreservice.repository;

import com.offshoringhub.offreservice.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Integer> {
}
