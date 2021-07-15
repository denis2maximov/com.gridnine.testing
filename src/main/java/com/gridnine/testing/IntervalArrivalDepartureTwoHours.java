package com.gridnine.testing;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalArrivalDepartureTwoHours implements FilterFlight, TimeSpentEarth {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList.stream()
                .filter(s -> s.getSegments().size() > 1)
                .filter(x -> segment(x.getSegments()))
                .collect(Collectors.toList());

    }

    @Override
    public boolean segment(List<Segment> segment) {
        int timeWaiting = 2;
        long time = 0;
        for (int i = 0; i < segment.size() - 1; i++) {
            time +=  Duration.between(segment.get(i).getArrivalDate(),
                    segment.get(i + 1).getDepartureDate()).toHours();
        }
        return time > timeWaiting;
    }
}

