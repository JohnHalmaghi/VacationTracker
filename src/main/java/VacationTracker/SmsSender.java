package VacationTracker;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URISyntaxException;

    public class SmsSender {
        private static final String twilioAccountSID = "AC519fff50ccdd4c7276b310366f6b33c7";
        private static final String twilioAuthToken = "totallylegitauthenticationtoken";
        private static final PhoneNumber twilioPhoneNumber = new PhoneNumber("+16196484344 ");

        public SmsSender() throws URISyntaxException{

        }

        public void sendMessage(String toNumber, String messageToSend){
            Twilio.init(twilioAccountSID, twilioAuthToken);
            Message message = Message.creator((new PhoneNumber(toNumber)),twilioPhoneNumber, messageToSend).create();
        }
        public String alertMessage(String depAirport, String depDate, String destCity, String retDate, double newLowPrice){
            String messageString = "You're tracked flight from "+ depAirport +" departing on "+ depDate + " to "+ destCity + " returning on "+ retDate +" has a new low price of $" + newLowPrice+".";
            return messageString;
        }

    }
