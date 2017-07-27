package VacationTracker;

import java.io.*;
import java.util.ArrayList;

public class MVCVacation {
    public static void main(String args[]) throws ClassNotFoundException {
        VacationView theView = new VacationView();
        final VacationModel theModel = new VacationModel();
        VacationController theController = new VacationController(theView, theModel);
        final String filename = "data.bin";

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename)); //will throw exception if data.bin is empty
            theModel.listOfFlight = (ArrayList<Flight>) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
                    outputStream.writeObject(theModel.listOfFlight);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }));
        theView.setVisible(true);
    }
}
