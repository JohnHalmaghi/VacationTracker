package VacationTracker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 * Created by john on 7/24/17.
 */
public class VacationView extends JFrame {

    private JLabel depFlight = new JLabel("Departure Flight Information:   "); //extra spaces for alignment
    private JLabel destFlight = new JLabel("Destination Flight Information: ");
    private JLabel numberOfPassengersLabel = new JLabel("Number of Passengers: ");
    private JLabel date = new JLabel("Date: ");
    private JLabel date2 = new JLabel("Date: ");
    private DefaultListModel defListModel = new DefaultListModel();
    private JList depAirports, destAirports;
    private JScrollPane depScroller, destScroller;
    SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 15, 1);
    private JSpinner depDate, destDate, numOfPassengers = new JSpinner(model1);
    private JButton submitButton = new JButton("Submit");
    JRadioButton monthOrDate = new JRadioButton();
    //TO-DO add radio button that lets user choose a specific date, or cheapest flight within a month
    String[] airports = {"SAN", "LAX", "FAT", "JFK", "SEA", "PAX"};


    VacationView(){
        JPanel vacPanel = new JPanel();
        vacPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        this.setSize(700, 350);
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

        ListenForSubmit lForSubmit = new ListenForSubmit();
        submitButton.addActionListener(lForSubmit);

        vacPanel.add(depFlight);
        vacPanel.add(depScroller);
        vacPanel.add(date2);
        vacPanel.add(depDate);
        vacPanel.add(numberOfPassengersLabel);
        vacPanel.add(numOfPassengers);
        vacPanel.add(destFlight);
        vacPanel.add(destScroller);
        vacPanel.add(date);
        vacPanel.add(destDate);
        vacPanel.add(submitButton);

        this.add(vacPanel);
        this.setVisible(true);
    }

    public String getDepAirpot(){ //might not work?
        return (String) depAirports.getSelectedValue();
    }

    public String getDestAirpot(){ //might not work?
        return (String) destAirports.getSelectedValue();
    }

    public Date getDepDate() { //TEST to make sure this works
        return ((Date) depDate.getValue());
    }

    public Date getDestDate(){
        return ((Date) destDate.getValue());
    }

    public int getNumOfPassengers(){
        return (Integer) numOfPassengers.getValue();
    }

    void addSubmitListener(ActionListener listenerForSubmitButton){
        submitButton.addActionListener(listenerForSubmitButton);
    }

    private class ListenForSubmit implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            if(actionEvent.getSource() == submitButton){
                JOptionPane.showMessageDialog(VacationView.this, "Airport of Departure: "+ getDepAirpot() + "\nDeparture Date: " + getDepDate() + "\nDestination Airport: " + getDestAirpot() + "\nReturn Date: " + getDestDate()+ "\nNumber of Passengers: "+getNumOfPassengers());
            }

        }
    }


    //add error message/check?
}
