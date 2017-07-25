package VacationTracker;

/**
 * Created by john on 7/24/17.
 */
public class MVCVacation {
    public static void main(String args[]){

        VacationView theView = new VacationView();
        VacationModel theModel = new VacationModel();
        VacationController theController = new VacationController(theView, theModel);

        theView.setVisible(true);
    }
}
