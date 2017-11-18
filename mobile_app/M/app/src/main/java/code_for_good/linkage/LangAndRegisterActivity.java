package code_for_good.linkage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

        TextView iama = (TextView) findViewById(R.id.i_am_a_view);
        Button toReg = (Button) findViewById(R.id.toProfile);
        Button noReg = (Button) findViewById(R.id.noRegister);

        switch (lang) {
            case ENG:
                iama.setText(getString(R.string.i_am_eng));
                toReg.setText(getString(R.string.register_eng));
                noReg.setText(getString(R.string.dont_register_eng));
                break;
            case BNG:
                iama.setText(getString(R.string.i_am_bng));
                toReg.setText(getString(R.string.register_bng));
                noReg.setText(getString(R.string.dont_register_bng));
                break;
            case CHI:
                iama.setText(getString(R.string.i_am_chi));
                toReg.setText(getString(R.string.register_chi));
                noReg.setText(getString(R.string.dont_register_chi));
                break;
            case FRA:
                iama.setText(getString(R.string.i_am_fra));
                toReg.setText(getString(R.string.register_fra));
                noReg.setText(getString(R.string.dont_register_fra));
                break;
            case ESP:
                iama.setText(getString(R.string.i_am_esp));
                toReg.setText(getString(R.string.register_esp));
                noReg.setText(getString(R.string.dont_register_esp));
                break;
            case ITA:
                iama.setText(getString(R.string.i_am_ita));
                toReg.setText(getString(R.string.register_ita));
                noReg.setText(getString(R.string.dont_register_ita));
                break;
            case SOM:
                iama.setText(getString(R.string.i_am_som));
                toReg.setText(getString(R.string.register_som));
                noReg.setText(getString(R.string.dont_register_som));
                break;
            default:
                iama.setText(getString(R.string.i_am_eng));
                toReg.setText(getString(R.string.register_eng));
                noReg.setText(getString(R.string.dont_register_eng));
        }

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
