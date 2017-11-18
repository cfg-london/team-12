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
        urgent = (Button) findViewById(R.id.urgentCheckUrgent);
        notUrgent = (Button) findViewById(R.id.urgentCheckNotUrgent);
        volunteer = (Button) findViewById(R.id.urgentCheckVolunteer);

    }

    public void urgent() {

    }

    public void nonUrgent() {

    }
}
