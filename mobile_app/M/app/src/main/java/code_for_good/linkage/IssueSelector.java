package code_for_good.linkage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_selector);

        buttonIsolation = (Button) findViewById(R.id.buttonIsolation);

    }
}
