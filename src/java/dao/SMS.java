package dao;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import static dao.SmsSender.ACCOUNT_SID;
import static dao.SmsSender.AUTH_TOKEN;

public class SMS {
    // Find your Account Sid and Token at twilio.com/user/account

    public static final String ACCOUNT_SID = "AC5755ec921d96e4af84e5304a209d6761";
    public static final String AUTH_TOKEN = "520c6ef70215139258675d7e9456b22c";

    public void enviarSMS(int phone) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String phoneS = String.valueOf(phone);

        Message message = Message
                .creator(new PhoneNumber("+506" + phoneS), // to
                        new PhoneNumber("+18186503624"), // from
                        "Confimación de solicitud")
                .create();

        System.out.println(message.getSid());
    }
}
