package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SegmentsArrivalEarlierDepartureTest {

    @Test
    public void whenIsArrivalEarlierDeparture() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<Flight>();
        List<Segment> segmentList = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).minusHours(6))
        );
        Flight flight = new Flight(segmentList);
        flights.add(flight);
        assertEquals(new SegmentsArrivalEarlierDeparture().filter(flightList).toString(),
                flights.toString());
    }

    @Test
    public void whenDepartureBeforeCurrentTimeSizeCheck() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<Flight>();
        List<Segment> segmentList = Arrays.asList(
                new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(3))
        );

        Flight flight = new Flight(segmentList);
        List<Flight> outfightList = new SegmentsArrivalEarlierDeparture().filter(flightList);
        flights.add(flight);
        assertEquals(outfightList.size(), flights.size());
    }
}