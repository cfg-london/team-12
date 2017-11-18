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

        TextView iama = (TextView) findViewById(R.id.i_am_a_view);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.engReferrerOptions, R.layout.custom_spinner);

        if(getIntent().hasExtra("Language_Choice")){
            String languages = getIntent().getStringExtra("Language_Choice");
            switch (languages) {
                case "English":
                    lang = Languages.ENG;
                    iama.setText(getString(R.string.i_am_eng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.engReferrerOptions, R.layout.custom_spinner);
                    break;
                case "বাঙালি":
                    lang = Languages.BNG;
                    iama.setText(getString(R.string.i_am_bng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.bngReferrerOptions, R.layout.custom_spinner);
                    break;
                case "中文":
                    lang = Languages.CHI;
                    iama.setText(getString(R.string.i_am_chi));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.chiReferrerOptions, R.layout.custom_spinner);
                    break;
                case "Français":
                    lang = Languages.FRA;
                    iama.setText(getString(R.string.i_am_fra));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.fraReferrerOptions, R.layout.custom_spinner);
                    break;
                case "Español":
                    lang = Languages.ESP;
                    iama.setText(getString(R.string.i_am_esp));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.espReferrerOptions, R.layout.custom_spinner);
                    break;
                case "Italiano":
                    lang = Languages.ITA;
                    iama.setText(getString(R.string.i_am_ita));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.itaReferrerOptions, R.layout.custom_spinner);
                    break;
                case "Somali":
                    lang = Languages.SOM;
                    iama.setText(getString(R.string.i_am_som));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.somReferrerOptions, R.layout.custom_spinner);
                    break;
                default:
                    lang = Languages.ENG;
                    iama.setText(getString(R.string.i_am_eng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.engReferrerOptions, R.layout.custom_spinner);
                    break;
            }
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
