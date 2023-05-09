package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.services;

import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestImpl implements MaintenanceRequestService{
    private MaintenanceRequestRepo maintenceRequestRepo;

    @Autowired
    public MaintenanceRequestImpl(MaintenanceRequestRepo maintenanceRequestRepo) {
        this.maintenceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest request) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenceRequestRepo.findByEmail(request.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Request with this email already exists: " + request.getEmail());
        return maintenceRequestRepo.save(request);
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest request = maintenceRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No request with email: " + email));
        return request;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest request = maintenceRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No request with id: " + id));
        return request;
    }

    @Override
    public MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        MaintenanceRequest request = maintenceRequestRepo.findByAptNumber(aptNumber)
                .orElseThrow(() -> new ResourceNotFoundException("No request with apt number: " + aptNumber));
        return request;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest requestDetails) throws ResourceNotFoundException {
        MaintenanceRequest request = getById(id);
        request.setFirstName(requestDetails.getFirstName());
        request.setLastName(requestDetails.getLastName());
        request.setAptNumber(requestDetails.getAptNumber());
        request.setEmail(requestDetails.getEmail());
        return maintenceRequestRepo.save(request);
    }

    @Override
    public void delete(Long id) {
        MaintenanceRequest request = getById(id);
        maintenceRequestRepo.delete(request);
    }
}
