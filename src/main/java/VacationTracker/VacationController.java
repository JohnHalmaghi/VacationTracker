package VacationTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

public class VacationController {

    private VacationView theView;
    private VacationModel theModel;

    public VacationController(VacationView theView, VacationModel theModel){
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addSubmitListener(new SubmitListener());
    }


    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            Flight f = new Flight();
            f.setDepAirport(theView.getDepAirpot()); //maybe create in constructor?
            f.setDestAirport(theView.getDestAirpot());
            f.setDepDate(theView.getDepDate());
            f.setRetDate(theView.getDestDate());
            f.setNumberOfPassengers(theView.getNumOfPassengers());
            theModel.addFlightToListOfFlights(f);
            theModel.getSmsSender().sendMessage(theView.getPhoneNumer(), theModel.getSmsSender().alertMessage(f.getDepAirport(), f.getDateAsString(f.getDepDate()), f.getDestAirport(), f.getDateAsString(f.getRetDate()), f.getLowestPriceToDate()));
            try {
                theModel.sendUpdate(theView.getPhoneNumer());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
