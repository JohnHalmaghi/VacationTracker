package VacationTracker;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MVCVacation {
    public static void main(String args[]) throws ClassNotFoundException, URISyntaxException {
        VacationView theView = new VacationView();
        final VacationModel theModel = new VacationModel();
        final VacationController theController = new VacationController(theView, theModel);
        final String filename = "data.bin";
        final Timer timer = new Timer();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename)); //will throw exception if data.bin is empty
            theModel.listOfFlights = (ArrayList<Flight>) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
                    outputStream.writeObject(theModel.listOfFlights);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }));
        theView.setVisible(true);

        TimerTask checkPrices = new TimerTask() {
            @Override
            public void run() {
                theModel.getSmsSender().sendMessage("8582049506", theModel.getSmsSender().alertMessage("This is a test of the timer function","","","",0.0));
                for(Flight flight : theModel.listOfFlights){
                    if(flight.hoursHavePassedSinceLastPriceCheck(2)){
                        //update price
                    }
                }
            }
        };
        timer.schedule(checkPrices, 01, 1000*60*60*2);
    }
}
