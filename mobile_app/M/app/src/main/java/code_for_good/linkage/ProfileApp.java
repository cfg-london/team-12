package code_for_good.linkage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileApp extends AppCompatActivity {

    private UserProfile profile;
    private Spinner referrerDropdown;
    private String type;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText work;
    private EditText address;
    private Button submit;

    private Langauges lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_app);

        this.lang = Langauges.ENG;

        if(getIntent().hasExtra("Language_Choice")){
            String languages = getIntent().getStringExtra("Language_Choice");
            switch (languages) {
                case "English":
                    lang = Langauges.ENG;
                    break;
                case "বাঙালি":
                    lang = Langauges.BNG;
                    break;
                case "中文":
                    lang = Langauges.CHI;
                    break;
                case "Français":
                    lang = Langauges.FRA;
                    break;
                case "Español":
                    lang = Langauges.ESP;
                    break;
                case "Italiano":
                    lang = Langauges.ITA;
                    break;
                case "Somali":
                    lang = Langauges.SOM;
                    break;
                default:
                    break;
            }
        }

        ArrayAdapter adapter;
        switch(lang) {
            case ENG:
                adapter = ArrayAdapter.createFromResource(this, R.array.engReferrerOptions, R.layout.custom_spinner);
                break;
            case BNG:
                adapter = ArrayAdapter.createFromResource(this, R.array.bngReferrerOptions, R.layout.custom_spinner);
                break;
            case CHI:
                adapter = ArrayAdapter.createFromResource(this, R.array.chiReferrerOptions, R.layout.custom_spinner);
                break;
            case FRA:
                adapter = ArrayAdapter.createFromResource(this, R.array.fraReferrerOptions, R.layout.custom_spinner);
                break;
            case ESP:
                adapter = ArrayAdapter.createFromResource(this, R.array.espReferrerOptions, R.layout.custom_spinner);
                break;
            case ITA:
                adapter = ArrayAdapter.createFromResource(this, R.array.itaReferrerOptions, R.layout.custom_spinner);
                break;
            case SOM:
                adapter = ArrayAdapter.createFromResource(this, R.array.somReferrerOptions, R.layout.custom_spinner);
                break;
            default:
                adapter = ArrayAdapter.createFromResource(this, R.array.engReferrerOptions, R.layout.custom_spinner);
        }

        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        referrerDropdown = (Spinner) findViewById(R.id.professionDropdown);
        referrerDropdown.setAdapter(adapter);

        referrerDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = ((TextView) findViewById(R.id.customSpinner)).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        name = (EditText) findViewById(R.id.profileInputName);
        phone = (EditText) findViewById(R.id.profileInputPhone);
        email = (EditText) findViewById(R.id.profileInputEmail);
        work = (EditText) findViewById(R.id.profileInputWorkAddress);
        address = (EditText) findViewById(R.id.profileInputAddress);
        submit = (Button) findViewById(R.id.profileInputNext);

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
        startActivity(toUrgent);
        this.finish();
    }
}
