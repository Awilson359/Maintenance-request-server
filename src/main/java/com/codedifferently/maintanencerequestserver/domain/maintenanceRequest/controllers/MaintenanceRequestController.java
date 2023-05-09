package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.controllers;

import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class MaintenanceRequestController {
    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @GetMapping
    ResponseEntity<List<MaintenanceRequest>> getAll(){
        List<MaintenanceRequest> requests = maintenanceRequestService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<MaintenanceRequest> create(@RequestBody MaintenanceRequest request){
        request = maintenanceRequestService.create(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<MaintenanceRequest> getById(@PathVariable("id") Long id){
        MaintenanceRequest request = maintenanceRequestService.getById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("email-lookup")
    ResponseEntity<MaintenanceRequest> getByEmail(@RequestParam String email){
        MaintenanceRequest request = maintenanceRequestService.getByEmail(email);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
    
    @GetMapping("apt-lookup")
    ResponseEntity<MaintenanceRequest> getByAptNumber(@RequestParam String aptNumber){
        MaintenanceRequest request = maintenanceRequestService.getByAptNumber(aptNumber);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<MaintenanceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenanceRequest request){
        request = maintenanceRequestService.update(id, request);
        return new ResponseEntity<>(request, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    ResponseEntity delete(@PathVariable("id") Long id){
        maintenanceRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
