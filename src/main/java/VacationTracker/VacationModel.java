package VacationTracker;

import org.joda.time.LocalDateTime;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class VacationModel {

    private Flight flight;
    protected ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
    private LocalDateTime creationTime = new LocalDateTime();
    protected SmsSender textMessage = new SmsSender(); //Get from theView
    private QPXAccessor qpx;

    public VacationModel() throws URISyntaxException {
        creationTime = LocalDateTime.now();
    }

    public Flight getFlight(){
        return this.flight;
    }

    public void setFlight(Flight f){
        flight = f;
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
