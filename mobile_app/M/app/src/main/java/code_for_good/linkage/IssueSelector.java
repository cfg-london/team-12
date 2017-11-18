package code_for_good.linkage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IssueSelector extends AppCompatActivity {

    private Button buttonIsolation;
    private Button buttonSafetyAtHome;
    private Button buttonLegal;
    private Button buttonCrisis;
    private Button buttonMedical;
    private Button buttonTransport;
    private Button buttonHelpAroundHouse;
    private Button buttonStayingInHome;
    private Button buttonMoney;

    private EditText additional;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_selector);

        buttonIsolation = (Button) findViewById(R.id.buttonIsolation);
        buttonSafetyAtHome = (Button) findViewById(R.id.buttonSafetyAtHome);
        buttonLegal = (Button) findViewById(R.id.buttonSafetyAtHome);
        buttonCrisis = (Button) findViewById(R.id.buttonCrisis);
        buttonMedical = (Button) findViewById(R.id.buttonMedical);
        buttonTransport = (Button) findViewById(R.id.buttonTransport);
        buttonHelpAroundHouse = (Button) findViewById(R.id.buttonHelpAroundTheHouse);
        buttonStayingInHome = (Button) findViewById(R.id.buttonStayingInTheirHome);
        buttonMoney = (Button) findViewById(R.id.buttonMoneyAndBenefits);

        additional = (EditText) findViewById(R.id.additional);
        confirm = (Button) findViewById(R.id.confirm);

        final RequestBuilder requestBuilder = getIntent().getParcelableExtra("request");

        buttonIsolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Isolation");
            }
        });

        buttonSafetyAtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Safety at home");
            }
        });

        buttonLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Legal");
            }
        });

        buttonCrisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Crisis / Mental Issues");
            }
        });

        buttonMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Medical Issue");
            }
        });

        buttonTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Transport / Mobility Issues");
            }
        });

        buttonStayingInHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Issues involving staying in their home");
            }
        });

        buttonMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Money / Benefits Issue");
            }
        });

        buttonHelpAroundHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Requires help around the house");
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.addIssue(additional.getText().toString());
                Request request = requestBuilder.build();
                // TODO: send
            }
        });

    }
}
