package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest create(MaintenanceRequest request) throws ResourceCreationException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest requestDetails) throws ResourceNotFoundException;
    void delete(Long id);
}
