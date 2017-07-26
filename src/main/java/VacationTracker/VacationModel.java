package VacationTracker;

import java.util.ArrayList;

public class VacationModel {

    private String fromDate, toDate, depAirport, destAirport;
    private int numOfDays, numOfLayovers;
    private double cost;
    public Flight flight;
    private ArrayList<Flight> listOfFlight = new ArrayList<Flight>();

    public void addFlightToListOfFlights(Flight flight){
        listOfFlight.add(flight);
    }

    public String createAPICall(Flight f){
        return null;
    }

    //Call API, get JSON

    //Use JSON to get price

    //Use JSON to get number of layovers?

    //Insert calls to API


}
