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
        volunteer = (Button) findViewById(R.id.urgentCheckVolunteer);

        urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setUrgency(true);
                toRefDetails(rb, userProfile);
            }
        });

        notUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setUrgency(false);
                toRefDetails(rb, userProfile);
            }
        });

    }

    public void toRefDetails(RequestBuilder rb, UserProfile userProfile){
        Intent intent = new Intent(this, RefereeDetails.class);
        intent.putExtra("request", rb);
        intent.putExtra("profile", userProfile);
        startActivity(intent);
    }
}
