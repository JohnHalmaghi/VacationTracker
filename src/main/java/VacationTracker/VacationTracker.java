package VacationTracker;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by john on 7/20/17.
 */
public class VacationTracker extends JFrame {

    JButton submitButton;
    JTextField startDate, endDate;
    JComboBox month, day, year;

    public static void main(String[] args){

        new VacationTracker();

    }

    public VacationTracker(){
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setTitle("Vacation Tracker");

        JPanel thePanel = new JPanel();


        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        Integer[] days = new Integer[31];
        for(Integer i = 0, j =1 ; i<31; j++, i++){ //make method?
            days[i] = j;
        }

        Integer[] years = new Integer[5];
        for(Integer i = 0, j = 2017; i<5; i++,j++){
            years[i] = j;
        }



        day = new JComboBox(days);

        month = new JComboBox(months);

        year = new JComboBox(years);

        JTextArea beginDate = new JTextArea("Begin Date: ");


        thePanel.add(beginDate);
        thePanel.add(month);
        thePanel.add(day);
        thePanel.add(year);

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
