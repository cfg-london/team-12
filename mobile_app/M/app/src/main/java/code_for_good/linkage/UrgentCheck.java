package code_for_good.linkage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UrgentCheck extends AppCompatActivity {

    private Button urgent;
    private Button notUrgent;
    private Button volunteer;
    private Languages lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_check);

        this.lang = (Languages) getIntent().getSerializableExtra("Language");
        final RequestBuilder rb = new RequestBuilder();
        final UserProfile userProfile = getIntent().getParcelableExtra("profile");

        urgent = (Button) findViewById(R.id.urgentCheckUrgent);
        notUrgent = (Button) findViewById(R.id.urgentCheckNotUrgent);

        switch (lang) {
            case ENG:
                urgent.setText(getString(R.string.urgent_eng));
                notUrgent.setText(getString(R.string.nonurgent_eng));
                break;
            case BNG:
                urgent.setText(getString(R.string.urgent_bng));
                notUrgent.setText(getString(R.string.nonurgent_bng));
                break;
            case CHI:
                urgent.setText(getString(R.string.urgent_chi));
                notUrgent.setText(getString(R.string.nonurgent_chi));
                break;
            case FRA:
                urgent.setText(getString(R.string.urgent_fra));
                notUrgent.setText(getString(R.string.nonurgent_fra));
                break;
            case ESP:
                urgent.setText(getString(R.string.urgent_esp));
                notUrgent.setText(getString(R.string.nonurgent_esp));
                break;
            case ITA:
                urgent.setText(getString(R.string.urgent_ita));
                notUrgent.setText(getString(R.string.nonurgent_ita));
                break;
            case SOM:
                urgent.setText(getString(R.string.urgent_som));
                notUrgent.setText(getString(R.string.nonurgent_som));
                break;
            default:
                urgent.setText(getString(R.string.urgent_eng));
                notUrgent.setText(getString(R.string.nonurgent_eng));
                break;
        }

        urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setUrgency(true);
                rb.setReferrer(userProfile);
                toRefDetails(rb, userProfile);
            }
        });

        notUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setUrgency(false);
                rb.setReferrer(userProfile);
                toRefDetails(rb, userProfile);
            }
        });

    }

    public void toRefDetails(RequestBuilder rb, UserProfile userProfile){
        Intent intent = new Intent(this, RefereeDetails.class);
        intent.putExtra("Language", lang);
        intent.putExtra("request", rb);
        startActivity(intent);
        this.finish();
    }
}
