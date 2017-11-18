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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                    new DatabaseConnector().execute(request);
                } else {
                    remindAccept();
                }
            }
        });
    }

    private void complete() {
        this.finish();
    }

    private void remindAccept(){
        Toast.makeText(this, "Please tick the checkbox", Toast.LENGTH_LONG);
    }

    private class DatabaseConnector extends AsyncTask<Request, Void, Void> {

        @Override
        protected Void doInBackground(Request... requests) {
            URL url = null;
            try {
                requests[0].send();
                String b = requests[0].getJobType().replace(" ", "_").replace(",", "");
                StringBuilder sb = new StringBuilder();
                for(String s : requests[0].getIssues()){
                    if(s.equals("Issues involving staying in their home")
                            || s.equals("Requires help around the house")){
                        s = "help_round_the_house";
                    } else {
                        s = s.replace(" Issues", "");
                        s = s.toLowerCase().replace(" ", "_");
                        s = s.replace("/", "_and_");
                    }
                    sb.append(s).append(",");
                }
                sb.setLength(sb.length() - 2);
                url = new URL("http://34.241.158.221/Admin/register.php?type=increment&contents="
                        + b + "," + sb.toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null){
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            complete();
        }
    }



}
