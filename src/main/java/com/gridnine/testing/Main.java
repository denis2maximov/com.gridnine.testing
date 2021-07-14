package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("All flights");
        System.out.println(flightList);

        System.out.println("Departed flights for today");
        System.out.println((new ExcludeDepartureBeforeCurrentTime().filter(flightList)).toString());

        System.out.println("There are segments with the arrival "
                         + "date earlier than the departure date");
        System.out.println((new SegmentsArrivalEarlierDeparture().filter(flightList)).toString());

        /*       System.out.println("Long time waiting");
       System.out.println((new FilterLongTimeWaiting().filter(flightList)).toString());*/
    }
    }
