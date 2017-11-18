package code_for_good.linkage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AdditionalInformationSubmit extends AppCompatActivity {

    private Request request;
    private Button submit;
    private CheckBox consent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information_submit);

        request = getIntent().getExtras().getParcelable("request");
        submit = findViewById(R.id.finalSubmit);
        consent = findViewById(R.id.consentCheck);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(consent.isChecked()){

                } else {
                    remindAccept();
                }
            }
        });
    }

    private void remindAccept(){
        Toast.makeText(this, "Please tick the checkbox", Toast.LENGTH_LONG);
    }

    private class DatabaseConnector extends AsyncTask<Request, Void, Void> {

        @Override
        protected Void doInBackground(Request... requests) {
            URL url = null;
            try {
                url = new URL("http://34.241.158.221/");
                String data  = URLEncoder.encode("username", "UTF-8")
                        + "=" + URLEncoder.encode("root", "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8")
                        + "=" + URLEncoder.encode("Pa55w0rd", "UTF-8");
                URLConnection conn = url.openConnection();
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
