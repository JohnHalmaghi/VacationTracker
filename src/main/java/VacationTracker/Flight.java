package VacationTracker;

import org.joda.time.LocalDateTime;
import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight implements Serializable{

    private String depDate, retDate;
    private String destAirport;
    private String depAirport;
    private int numberOfLayovers;
    private String airline;
    private int numberOfPassengers;
    private double lowestPriceToDate;
    private LocalDateTime priceLastChecked;
    private QPXAccessor qpx;
    private ArrayList<Double> listOfPrices = new ArrayList<Double>();

    public Flight(){}

    public void setDepDate(String depDate){ this.depDate = depDate;}

    public void setRetDate(String retDate){ this.retDate = retDate;}

    public String getDepDate(){
        return depDate;
    }

    public String getRetDate(){return  retDate;}


    public LocalDateTime getPriceLastChecked(){
        return priceLastChecked;
    }

    public void setDestAirport(String destCity){ this.destAirport = destCity; }

    public String getDestAirport(){ return destAirport; }

    public void setDepAirport(String depAirport) { this.depAirport = depAirport; }

    public String getDepAirport() { return this.depAirport; }

    public void setNumberOfLayovers(int layoverCount) { numberOfLayovers = layoverCount; }

    public int getNumberOfLayovers(){ return numberOfLayovers; }

    public void setAirline(String airline){ this.airline = airline; }

    public String getAirline(){ return airline; }

    public void setNumberOfPassengers(int numOfPassengers){ numberOfPassengers = numOfPassengers; }

    public int getNumberOfPassengers(){ return numberOfPassengers; }

    public void setLowestPriceToDate(double flightPrice){
        lowestPriceToDate = flightPrice;
    }

    public double getLowestPriceToDate() throws IOException, JSONException {
        qpx = new QPXAccessor(this);
        return qpx.getLowestPrice(); }

    public void addToListOfPricesandUpdatepriceLastChecked(Double price){
        priceLastChecked = LocalDateTime.now();
        listOfPrices.add(price);
    }

    public Double getAvgPriceOfFlight(){
        Double avg = 0.0;
        for(Double price : listOfPrices){
            avg += price;
        }
        avg = avg/listOfPrices.size();
        return avg;
    }

    public boolean hoursHavePassedSinceLastPriceCheck(int hours){
        if(priceLastChecked.plusHours(hours).isBefore(LocalDateTime.now())){
            return true;
        } else return false;
    }

}
