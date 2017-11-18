package code_for_good.linkage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LangAndRegisterActivity extends AppCompatActivity {

    private Languages lang;
    private Spinner referrerDropdown;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        this.lang = Languages.ENG;

        if(getIntent().hasExtra("Language_Choice")){
            String languages = getIntent().getStringExtra("Language_Choice");
            switch (languages) {
                case "English":
                    lang = Languages.ENG;
                    break;
                case "বাঙালি":
                    lang = Languages.BNG;
                    break;
                case "中文":
                    lang = Languages.CHI;
                    break;
                case "Français":
                    lang = Languages.FRA;
                    break;
                case "Español":
                    lang = Languages.ESP;
                    break;
                case "Italiano":
                    lang = Languages.ITA;
                    break;
                case "Somali":
                    lang = Languages.SOM;
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

    }


    public void changeLangActivity(View view){
        Intent intent = new Intent(this, LanguagesActivity.class);
        startActivity(intent);
    }

    public void toProfileAct(View view) {
        Intent intent = new Intent(this, ProfileApp.class);
        intent.putExtra("Language", lang);
        intent.putExtra("type", type);
        startActivity(intent);
        this.finish();
    }

    public void toUrgent(View view) {
        Intent intent = new Intent(this, UrgentCheck.class);
        intent.putExtra("Language", lang);
        intent.putExtra("type", type);
        startActivity(intent);
        this.finish();
    }
}
