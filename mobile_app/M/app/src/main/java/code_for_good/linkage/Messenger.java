package code_for_good.linkage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Properties;

/**
 * Created by dimarammfire on 17.11.17.
 */

public class Messenger extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_selector);}

//        Button startBtn = (Button) findViewById(R.id);
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                sendEmail();
//            }
//        });
//    }

    private static void sendEmail() {
        String to = "cfg-team12@mail.com";
        String from = "anon.mystery@mail.ru";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Testing");

            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
