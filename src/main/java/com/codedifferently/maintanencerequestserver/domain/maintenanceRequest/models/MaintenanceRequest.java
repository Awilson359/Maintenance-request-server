package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName, lastName, email, aptNumber, description;

    @NonNull
    final private LocalDate createdAt = LocalDate.now();

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return String.format("%d %s %s %s %s %s %s", id, firstName, lastName, email, aptNumber, description, createdAt.format(formatter));
    }
}
