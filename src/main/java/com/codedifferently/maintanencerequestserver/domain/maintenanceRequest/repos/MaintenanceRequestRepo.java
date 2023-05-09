package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.repos;

import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);
    Optional<MaintenanceRequest> findByAptNumber(String aptNumber);
}
