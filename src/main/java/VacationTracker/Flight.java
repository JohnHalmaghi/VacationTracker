package VacationTracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by john on 7/18/17.
 */
public class Flight implements Serializable{

    public void Flight(){}
    private Date depDate, retDate;
    private String destinationCity;
    private String sourceCity;
    private int numberOfLayovers;
    private String airline;
    private int numberOfPassengers;
    private double price;

    public void setDepDate(Date depDate){ this.depDate = depDate;}

    public void setRetDate(Date retDate){ this.retDate = retDate;}

    public Date getDepDate(){return depDate;}

    public Date getRetDate(){return  retDate;}

    public String getDateAsString(Date date){ //TEST to make sure this works
        String stringDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
        stringDate = stringDate.replaceAll("/", "-");

        return (stringDate);
    }

    public void setDestinationCity(String destCity){ this.destinationCity = destCity; }

    public String getDestinationCity(){ return destinationCity; }

    public void setSourceCity(String sourceCity) { this.sourceCity = sourceCity; }

    public String getSourceCity() { return this.sourceCity; }

    public void setNumberOfLayovers(int layoverCount) { numberOfLayovers = layoverCount; }

    public int getNumberOfLayovers(){ return numberOfLayovers; }

    public void setAirline(String airline){ this.airline = airline; }

    public String getAirline(){ return airline; }

    public void setNumberOfPassengers(int numOfPassengers){ numberOfPassengers = numOfPassengers; }

    public int getNumberOfPassengers(){ return numberOfPassengers; }

    public void setPrice(double flightPrice){ price = flightPrice; }

    public double getPrice(){ return price; }


}
