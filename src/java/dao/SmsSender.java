/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author samoy
 */
public class SmsSender {

    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID
            = "AC5755ec921d96e4af84e5304a209d6761";
    public static final String AUTH_TOKEN
            = "520c6ef70215139258675d7e9456b22c";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+50670445772"), // to
                        new PhoneNumber("+18186503624"), // from
                        "Cita cancelada confirmación")
                .create();

        System.out.println(message.getSid());
    }
}

