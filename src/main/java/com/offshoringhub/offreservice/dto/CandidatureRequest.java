package com.offshoringhub.offreservice.dto;


import com.offshoringhub.offreservice.models.CandidatureStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidatureRequest {
    private int id;
    private int employee_id;
}
