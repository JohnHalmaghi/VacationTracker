package VacationTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.Date;

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
            f.setSourceCity(theView.getDepAirpot());
            f.setDestinationCity(theView.getDestAirpot());
            f.setDepDate(theView.getDepDate());
            f.setRetDate(theView.getDestDate());
            f.setNumberOfPassengers(theView.getNumOfPassengers());
            theModel.addFlightToListOfFlights(f);
            theModel.getSmsSender().setMessage(f.getSourceCity(),f.getDepDate().toString(),f.getDestinationCity(),f.getRetDate().toString(), 1.1);
            theModel.getSmsSender().sendMessage(theView.getPhoneNumer());
            try {
                theModel.sendUpdate(theView.getPhoneNumer());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
