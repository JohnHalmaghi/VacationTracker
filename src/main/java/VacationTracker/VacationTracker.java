package VacationTracker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by john on 7/20/17.
 */
public class VacationTracker extends JFrame {

    JButton submitButton;
    JTextArea departureFlight, destinationFlight;
    JTextField startDate, endDate;
    JComboBox month, day, year;
    JList departureAirport, destinationAirport;
    DefaultListModel defListModel = new DefaultListModel();
    JScrollPane depScroller, destScroller;
    JSpinner spinner1, spinner2, spinner3;

    public static void main2(String[] args){

        new VacationTracker();

    }

    public VacationTracker(){
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setTitle("Vacation Tracker");

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridLayout(0,2,2,2));

        departureFlight = new JTextArea("Departure Flight: ");


        thePanel.add(departureFlight);

        String[] airports = {"SAN", "LAX", "FAT", "JFK", "SEA", "PAX"};

        departureAirport = new JList(defListModel);

        destScroller = new JScrollPane(departureAirport, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        departureAirport.setFixedCellHeight(25);

        departureAirport.setFixedCellWidth(50);

        departureAirport.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        thePanel.add(destScroller);

        for(String airport: airports){
            defListModel.addElement(airport);
        }

        destinationAirport = new JList(defListModel);

        depScroller = new JScrollPane(destinationAirport, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        destinationAirport.setFixedCellHeight(25);

        destinationAirport.setFixedCellWidth(50);

        destinationAirport.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        thePanel.add(depScroller);

        Date todaysDate = new Date();

        spinner2 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner2, "MM/dd/yyyy");

        spinner2.setEditor(dateEditor);

        thePanel.add(spinner2);

        submitButton = new JButton("Submit");

        ListenForButton lForButton = new ListenForButton();

        submitButton.addActionListener(lForButton);

        thePanel.add(submitButton);

        this.add(thePanel);

        this.setVisible(true);


    }

    private class ListenForButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == submitButton){



            }
        }
    }


    private class ListenForWindow implements WindowListener{
        public void windowOpened(WindowEvent windowEvent) {

        }

        public void windowClosing(WindowEvent windowEvent) {

        }

        public void windowClosed(WindowEvent windowEvent) {

        }

        public void windowIconified(WindowEvent windowEvent) {

        }

        public void windowDeiconified(WindowEvent windowEvent) {

        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent windowEvent) {

        }
    }

}
