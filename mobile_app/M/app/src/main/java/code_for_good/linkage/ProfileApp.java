package code_for_good.linkage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ProfileApp extends AppCompatActivity {

    private UserProfile profile;

    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText work;
    private EditText address;
    private Button submit;

    private Languages lang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_app);

        this.lang = (Languages) getIntent().getSerializableExtra("Language");

        final String type = getIntent().getExtras().getString("type");

        name = (EditText) findViewById(R.id.profileInputName);
        phone = (EditText) findViewById(R.id.profileInputPhone);
        email = (EditText) findViewById(R.id.profileInputEmail);
        work = (EditText) findViewById(R.id.profileInputWorkAddress);
        address = (EditText) findViewById(R.id.profileInputAddress);
        submit = (Button) findViewById(R.id.profileInputNext);

        switch (lang) {
            case ENG:
                break;
            case BNG:
                break;
            case CHI:
                break;
            case FRA:
                break;
            case ESP:
                break;
            case ITA:
                break;
            case SOM:
                break;
            default:
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile = new UserProfile(type, name.getText().toString(),
                        phone.getText().toString(), email.getText().toString(),
                        address.getText().toString(), work.getText().toString());
                setupProfile(profile);
            }
        });
    }

    private void setupProfile(UserProfile profile){
        Intent toUrgent = new Intent(this, UrgentCheck.class);
        toUrgent.putExtra("profile", profile);
        toUrgent.putExtra("Language", lang);
        startActivity(toUrgent);
        this.finish();
    }
}
