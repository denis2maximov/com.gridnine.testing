package com.gridnine.testing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlights;
import static com.gridnine.testing.FlightFilter.CURRENT_MOMENT;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class FilterBeforeNowTest {

    @Test
    public void whenAllFlights() {
        FilterBeforeNow now = new FilterBeforeNow();
       List<Flight> flightList = new ArrayList<>();
       List<Segment> segmentList = List.of(
       new Segment(CURRENT_MOMENT.plusDays(3), CURRENT_MOMENT.plusDays(3).plusHours(3))
      // new Segment(CURRENT_MOMENT, CURRENT_MOMENT.plusHours(6))
        );
        Flight flight = new Flight(segmentList);
        flightList.add(flight);
        System.out.println(flightList);
        assertThat(now.filter(flightList), equalTo(new ArrayList<Flight>()));
    }
}