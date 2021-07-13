package com.gridnine.testing;

import java.util.List;

import static com.gridnine.testing.FlightFilter.CURRENT_MOMENT;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("//All flights");
        System.out.println(flightList);

        System.out.println("//Already flown");
        System.out.println((new FilterBeforeNow().filter(flightList)).toString());

        System.out.println("//Arrival before departure");
        System.out.println((new FilterArrivalBeforeDeparture().filter(flightList)).toString());
        System.out.println(CURRENT_MOMENT);

       System.out.println("//Long time waiting");
       System.out.println((new FilterLongTimeWaiting().filter(flightList)).toString());
    }
    }
