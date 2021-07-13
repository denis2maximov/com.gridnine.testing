package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilterArrivalBeforeDepartureTest {

    @Test
    public void whenAllFlights() {
/*        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(new Segment(start, finish));
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);
        return flightList;*/
        List<com.gridnine.testing.Flight> flightList = FlightBuilder.createFlights();

    }
}