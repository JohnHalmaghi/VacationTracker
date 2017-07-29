package VacationTracker;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URISyntaxException;

    public class SmsSender {
        private static final String twilioAccountSID = "AC519fff50ccdd4c7276b310366f6b33c7";
        private static final String twilioAuthToken = "AuthTokenGoesHere";
        private static final PhoneNumber twilioPhoneNumber = new PhoneNumber("+16196484344 ");
        public PhoneNumber toPhoneNumber;
        private String messageString;


        public SmsSender() throws URISyntaxException{

        }
        public void setToPhoneNumber(String toPhoneNum){
            toPhoneNumber = new PhoneNumber(toPhoneNum);
        }
        public void setMessage(String message){
            messageString = message;
        }
        public String getMessage(){
            return messageString;
        }
        public void sendMessage(String toNumber){
            Twilio.init(twilioAccountSID, twilioAuthToken);
            Message message = Message.creator((new PhoneNumber(toNumber)),twilioPhoneNumber, getMessage()).create();
        }

    }
