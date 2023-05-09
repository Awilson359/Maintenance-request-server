package com.codedifferently.maintanencerequestserver.domain.maintenanceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class MaintenanceRequestTest {
    @Test
    public void constructorTest01(){
        MaintenanceRequest mainRequest = new MaintenanceRequest("Demo","User","demo@user.com", "1A", "broken sink");
        mainRequest.setId(1L);

        String expected = "1 Demo User demo@user.com 1A broken sink 05/08/2023";
        String actual = mainRequest.toString();

        Assertions.assertEquals(expected, actual);
    }
}
