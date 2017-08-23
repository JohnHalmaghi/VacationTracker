package VacationTracker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class VacationView extends JFrame {

    private JLabel depFlight = new JLabel("Departure Flight Information:   "); //extra spaces for alignment
    private JLabel destFlight = new JLabel("Destination Flight Information: ");
    private JLabel numberOfPassengersLabel = new JLabel("Number of Passengers: ");
    private JLabel enterPhoneNumber = new JLabel("Enter Phone Number: ");
    private JLabel date = new JLabel("Date: ");
    private JLabel date2 = new JLabel("Date: ");
    private DefaultListModel defListModel = new DefaultListModel();
    private JList depAirports, destAirports;
    private JScrollPane depScroller, destScroller;
    SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 15, 1);
    private JSpinner depDate, destDate, numOfPassengers = new JSpinner(model1);
    private JButton submitButton = new JButton("Submit");
    private JTextField phoneNumber = new JTextField();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String[] airports = {"SAN", "LAX", "FAT", "JFK", "SEA", "PAX"};


    VacationView(){
        JPanel vacPanel = new JPanel();
        vacPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        this.setSize(750, 400);
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
        SimpleDateFormat model = new SimpleDateFormat("yyyy-MM-dd");

        depDate = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        destDate = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));

        JSpinner.DateEditor depDateEditor = new JSpinner.DateEditor(depDate, model.toPattern());
        JSpinner.DateEditor destDateEditor = new JSpinner.DateEditor(destDate, model.toPattern());

        depDate.setEditor(depDateEditor);
        destDate.setEditor(destDateEditor);

        ListenForSubmit lForSubmit = new ListenForSubmit();
        submitButton.addActionListener(lForSubmit);

        MaxLengthTextDocument maxLength = new MaxLengthTextDocument();
        maxLength.setMaxChars(10);
        phoneNumber.setColumns(10);
        phoneNumber.setDocument(maxLength);

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
        vacPanel.add(enterPhoneNumber);
        vacPanel.add(phoneNumber);
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

    public String getDepDate() {
        String dateToStr = format.format(depDate.getValue());
        return (dateToStr);
    }

    public String getDestDate(){
        String dateToStr = format.format(destDate.getValue());
        return (dateToStr);
    }

    public String getPhoneNumer(){ return phoneNumber.getText();}

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

    public class MaxLengthTextDocument extends PlainDocument {
        private int maxChars;

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null && (getLength() + str.length() <= maxChars)){
                super.insertString(offs, str, a);
            }
        }

        public void setMaxChars(int maxCharacters) {
            this.maxChars = maxCharacters;
        }
    }


    //add error message/check?
}
