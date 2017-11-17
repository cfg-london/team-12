package code_for_good.linkage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProfileApp extends AppCompatActivity {

    private Spinner referrerDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_app);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.referrerOptions, R.layout.custom_spinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        referrerDropdown = (Spinner) findViewById(R.id.professionDropdown);
        referrerDropdown.setAdapter(adapter);
    }
}
