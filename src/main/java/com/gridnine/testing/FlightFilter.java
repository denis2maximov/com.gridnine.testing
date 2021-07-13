package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {
    LocalDateTime CURRENT_MOMENT = LocalDateTime.now();
    int TIME_WAITING = 2;

    List<Flight> filter(List<Flight> flightList);
}