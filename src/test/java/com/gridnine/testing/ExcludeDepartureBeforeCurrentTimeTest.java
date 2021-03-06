package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExcludeDepartureBeforeCurrentTimeTest {

    @Test
    public void whenDepartureBeforeCurrentTime() {
        List<Flight> flightList = FlightBuilder.createFlights(); // все полеты с помошью фабрики
        List<Flight> flights = new ArrayList<Flight>(); // ручной лист полетов для тестирования
        List<Segment> segmentList = Arrays.asList(
                new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(3))
        );

        Flight flight = new Flight(segmentList);
        flights.add(flight);
        assertEquals(new ExcludeDepartureBeforeCurrentTime().filter(flightList).toString(),
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
        List<Flight> outfightList = new ExcludeDepartureBeforeCurrentTime().filter(flightList);
        flights.add(flight);
        assertEquals(outfightList.size(), flights.size());
    }
}