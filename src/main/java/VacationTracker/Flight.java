package VacationTracker;

/**
 * Created by john on 7/18/17.
 */
public class Flight {

    public void Flight(){}
    private String destinationCity;
    private String sourceCity;
    private int numberOfLayovers;
    private String airline;
    private int numberOfPassengers;
    private double price;

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
