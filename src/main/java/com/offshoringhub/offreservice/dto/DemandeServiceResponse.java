package com.offshoringhub.offreservice.dto;


import com.offshoringhub.offreservice.models.Candidature;
import com.offshoringhub.offreservice.models.Information;
import com.offshoringhub.offreservice.models.ServiceStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandeServiceResponse {
    private int id;
    private int company_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String name;
    private String description;
    private ServiceStatus serviceStatus;
    private List<Information> information;
    private int test_id;
}
