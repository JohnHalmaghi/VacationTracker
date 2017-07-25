package VacationTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VacationController {

    private VacationView theView;
    private VacationModel theModel;

    public VacationController(VacationView theView, VacationModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addSubmitListener(new SubmitListener());
    }


    private class SubmitListener implements ActionListener {
        String depAirport, destAirport, depDate, destDate;
        int numOfPassenger;
        public void actionPerformed(ActionEvent actionEvent) {
            depAirport = theView.getDepAirpot();
            destAirport = theView.getDestAirpot();
            depDate = theView.getDepDate();
            destDate = theView.getDestDate();
            numOfPassenger = theView.getNumOfPassengers();
        }
    }
}
