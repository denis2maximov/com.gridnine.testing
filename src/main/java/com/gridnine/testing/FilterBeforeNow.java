package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class FilterBeforeNow implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList.stream()
                .filter(s -> s.getSegments()
                         .stream()
                         .anyMatch(x -> x.getDepartureDate().isBefore(CURRENT_MOMENT)))
                .collect(Collectors.toList());
    }
}
