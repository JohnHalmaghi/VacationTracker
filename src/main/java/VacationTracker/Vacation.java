package VacationTracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by john on 7/18/17.
 */
public class Vacation {
    private String homeCity;
    private Date startDate;
    private Date endDate;
    private int numberOfDays;
    private ArrayList<Flight> flights;

    public Vacation (){
        flights = new ArrayList<Flight>();
    }

    public void setHomeCity(String city){ this.homeCity = city; }

    public String getHomeCity(){ return homeCity; }

    public void setStart(Date start){ this.startDate = start; }

    public void setEndDate(Date end){ this.endDate = end; }

    public void setNumberOfDays(int days){ this.numberOfDays = days; }

    public int getNumberOfDays(){ return this.numberOfDays; }

    public double getAvgCostofFlight(){
        double average = 0.0;
        for(Flight i : flights){
            average += i.getPrice();
        }
        average = average/ flights.size();
        return average;
    }

    public double getLowestCostofFlight(){
        double lowest = Double.MAX_VALUE;
        for(Flight i: flights){
            if(i.getPrice() < lowest){
                lowest = i.getPrice();
            }
        }
        return lowest;
    }

    public void addFlight(Flight flightToAdd){
        flights.add(flightToAdd);
    }
}
