package VacationTracker;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class VacationModel {

    private String fromDate, toDate, depAirport, destAirport;
    private int numOfDays, numOfLayovers;
    private double cost;
    public Flight flight;
    protected ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
    protected SmsSender textMessage = new SmsSender(); //Get from theView

    public VacationModel() throws URISyntaxException {
    }

    public void addFlightToListOfFlights(Flight flight){
        listOfFlights.add(flight);
    }

    public String createAPICall(Flight f){
        return null;
    }

    public void sendUpdate(String toPhoneNumber) throws URISyntaxException {
        textMessage = new SmsSender();
    }
    public SmsSender getSmsSender(){
        return textMessage;
    }

    //Call API, get JSON

    //Use JSON to get price

    //Use JSON to get number of layovers?

    //Insert calls to API


}
