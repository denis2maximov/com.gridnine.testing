package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IntervalArrivalDepartureTwoHoursTest {

    @Test
    public void whenMoreTwoHours() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<Flight>();
        List<Segment> segmentListTwo = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                        new Segment(LocalDateTime.now().plusDays(3).plusHours(5),
                                LocalDateTime.now().plusDays(3).plusHours(6))
        );
        List<Segment> segmentListTree = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3).plusHours(0),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(3),
                        LocalDateTime.now().plusDays(3).plusHours(4)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(6),
                        LocalDateTime.now().plusDays(3).plusHours(7))
        );

        Flight flight = new Flight(segmentListTwo);
        Flight flight2 = new Flight(segmentListTree);
        flights.add(flight);
        flights.add(flight2);
        assertEquals(new IntervalArrivalDepartureTwoHours().filter(flightList).toString(),
                flights.toString());
    }

    @Test
    public void whenMoreTwoHoursSizeCheck() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flights = new ArrayList<Flight>();
        List<Segment> segmentListTwo = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(5),
                        LocalDateTime.now().plusDays(3).plusHours(6))
        );
        List<Segment> segmentListTree = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3).plusHours(0),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(3),
                        LocalDateTime.now().plusDays(3).plusHours(4)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(6),
                        LocalDateTime.now().plusDays(3).plusHours(7))
        );

        Flight flight = new Flight(segmentListTwo);
        Flight flight2 = new Flight(segmentListTree);
         flights.add(flight);
        flights.add(flight2);
        assertEquals(new IntervalArrivalDepartureTwoHours().filter(flightList).size(),
                flights.size());
    }

    @Test
    public void whenSegmentLargerTwo() {
        IntervalArrivalDepartureTwoHours out = new IntervalArrivalDepartureTwoHours();
        List<Segment> segmentListTree = Arrays.asList(
                new Segment(LocalDateTime.now().plusDays(3).plusHours(0),
                        LocalDateTime.now().plusDays(3).plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(3),
                        LocalDateTime.now().plusDays(3).plusHours(4)),
                new Segment(LocalDateTime.now().plusDays(3).plusHours(6),
                        LocalDateTime.now().plusDays(3).plusHours(7))
        );
        assertTrue(out.segment(segmentListTree));

    }
}