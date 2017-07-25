package VacationTracker;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 * Created by john on 7/24/17.
 */
public class VacationView extends JFrame {

    private JLabel depFlight = new JLabel("Departure Flight Information: ");
    private JLabel destFlight = new JLabel("Destination Flight Information: ");
    private JLabel numberOfPassengersLabel = new JLabel("Number of Passengers: ");
    private DefaultListModel defListModel = new DefaultListModel();
    private JList depAirports, destAirports;
    private JScrollPane depScroller, destScroller;
    private JSpinner depDate, destDate, numOfPassengers = new JSpinner();
    private JButton submitButton = new JButton("Submit");
    JRadioButton monthOrDate = new JRadioButton(); //TO-DO add radio button that lets user choose a specific date, or cheapest flight within a month
    String[] airports = {"SAN", "LAX", "FAT", "JFK", "SEA", "PAX"};


    VacationView(){
        JPanel vacPanel = new JPanel();
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Vacation Tracker");

        for(String airport: airports){
            defListModel.addElement(airport);
        }

        depAirports = new JList(defListModel);
        depScroller = new JScrollPane(depAirports, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        destAirports = new JList(defListModel);
        destScroller = new JScrollPane(destAirports, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Date todaysDate = new Date();

        depDate = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        destDate = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));

        JSpinner.DateEditor depDateEditor = new JSpinner.DateEditor(depDate, "MM/dd/yyyy");
        JSpinner.DateEditor destDateEditor = new JSpinner.DateEditor(destDate, "MM/dd/yyyy");

        depDate.setEditor(depDateEditor);
        destDate.setEditor(destDateEditor);

        vacPanel.add(depFlight);
        vacPanel.add(depScroller);
        vacPanel.add(depDate);
        vacPanel.add(numberOfPassengersLabel);
        vacPanel.add(numOfPassengers);
        vacPanel.add(destFlight);
        vacPanel.add(destScroller);
        vacPanel.add(destDate);

        this.add(vacPanel);
        this.setVisible(true);
    }

    public String getDepAirpot(){ //might not work?
        return (String) depAirports.getSelectedValue();
    }

    public String getDestAirpot(){ //might not work?
        return (String) destAirports.getSelectedValue();
    }

    public String getDepDate(){
        return (new SimpleDateFormat("mm/dd/yyyy").format(depDate.getValue()));
    }

    public String getDestDate(){
        return (new SimpleDateFormat("mm/dd/yyyy").format(destDate.getValue()));
    }

    public int getNumOfPassengers(){
        return (Integer) numOfPassengers.getValue();
    }

    void addSubmitListener(ActionListener listenerForSubmitButton){
        submitButton.addActionListener(listenerForSubmitButton);
    }

    //add error message/check?
}
