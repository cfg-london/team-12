package code_for_good.linkage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RefereeDetails extends AppCompatActivity {

    private Spinner genderOptions;

    private EditText name;
    private EditText phone;
    private EditText age;
    private EditText address;
    private LinearLayout languages;
    private Button submit;
    private Language lang;
    private RequestBuilder rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referee_details);

        this.lang = (Language) getIntent().getSerializableExtra("Language");

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.genderOptions, R.layout.custom_spinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        genderOptions = (Spinner) findViewById(R.id.genderDropdown);
        genderOptions.setAdapter(adapter);

        rb = getIntent().getExtras().getParcelable("request");

        name = (EditText) findViewById(R.id.refereeInputName);
        phone = (EditText) findViewById(R.id.refereeInputPhone);
        age = (EditText) findViewById(R.id.refereeInputAge);
        address = (EditText) findViewById(R.id.refereeInputAddress);
        languages = (LinearLayout) findViewById(R.id.refereeInputLanguages);

        TextView nameref = (TextView) findViewById(R.id.nameRef);
        TextView phoneref = (TextView) findViewById(R.id.phoneRef);
        TextView genderref = (TextView) findViewById(R.id.genderRef);
        TextView ageref = (TextView) findViewById(R.id.ageRef);
        TextView addrref = (TextView) findViewById(R.id.addrRef);
        TextView langref = (TextView) findViewById(R.id.langRef);
        TextView moreinforef = (TextView) findViewById(R.id.moreinfoRef);

        submit = (Button) findViewById(R.id.refereeInputNext);

        switch (lang) {
            case ENG:
                nameref.setText(getString(R.string.name_eng));
                phoneref.setText(getString(R.string.phone_eng));
                genderref.setText(getString(R.string.Gender_eng));
                ageref.setText(getString(R.string.age_eng));
                age.setHint(getString(R.string.approx_eng));
                addrref.setText(getString(R.string.addr_eng));
                langref.setText(getString(R.string.lang_eng));
                moreinforef.setText(getString(R.string.more_info_eng));
                submit.setText(getString(R.string.next_eng));
                break;
            case BNG:
                nameref.setText(getString(R.string.name_bng));
                phoneref.setText(getString(R.string.phone_bng));
                genderref.setText(getString(R.string.Gender_bng));
                ageref.setText(getString(R.string.age_bng));
                age.setHint(getString(R.string.approx_bng));
                addrref.setText(getString(R.string.addr_bng));
                langref.setText(getString(R.string.lang_bng));
                moreinforef.setText(getString(R.string.more_info_bng));
                submit.setText(getString(R.string.next_bng));
                ArrayAdapter bngadapter = ArrayAdapter.createFromResource(this,
                        R.array.bnggenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(bngadapter);
                break;
            case CHI:
                nameref.setText(getString(R.string.name_chi));
                phoneref.setText(getString(R.string.phone_chi));
                genderref.setText(getString(R.string.Gender_chi));
                ageref.setText(getString(R.string.age_chi));
                age.setHint(getString(R.string.approx_chi));
                addrref.setText(getString(R.string.addr_chi));
                langref.setText(getString(R.string.lang_chi));
                moreinforef.setText(getString(R.string.more_info_chi));
                submit.setText(getString(R.string.next_chi));
                ArrayAdapter chiadapter = ArrayAdapter.createFromResource(this,
                        R.array.chigenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(chiadapter);
                break;
            case FRA:
                nameref.setText(getString(R.string.name_fra));
                phoneref.setText(getString(R.string.phone_fra));
                genderref.setText(getString(R.string.Gender_fra));
                ageref.setText(getString(R.string.age_fra));
                age.setHint(getString(R.string.approx_fra));
                addrref.setText(getString(R.string.addr_fra));
                langref.setText(getString(R.string.lang_fra));
                moreinforef.setText(getString(R.string.more_info_fra));
                submit.setText(getString(R.string.next_fra));
                ArrayAdapter fraadapter = ArrayAdapter.createFromResource(this,
                        R.array.fragenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(fraadapter);
                break;
            case ESP:
                nameref.setText(getString(R.string.name_esp));
                phoneref.setText(getString(R.string.phone_esp));
                genderref.setText(getString(R.string.Gender_esp));
                ageref.setText(getString(R.string.age_esp));
                age.setHint(getString(R.string.approx_esp));
                addrref.setText(getString(R.string.addr_esp));
                langref.setText(getString(R.string.lang_esp));
                moreinforef.setText(getString(R.string.more_info_esp));
                submit.setText(getString(R.string.next_esp));
                ArrayAdapter espadapter = ArrayAdapter.createFromResource(this,
                        R.array.espgenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(espadapter);
                break;
            case ITA:
                nameref.setText(getString(R.string.name_ita));
                phoneref.setText(getString(R.string.phone_ita));
                genderref.setText(getString(R.string.Gender_ita));
                ageref.setText(getString(R.string.age_ita));
                age.setHint(getString(R.string.approx_ita));
                addrref.setText(getString(R.string.addr_ita));
                langref.setText(getString(R.string.lang_ita));
                moreinforef.setText(getString(R.string.more_info_ita));
                submit.setText(getString(R.string.next_ita));
                ArrayAdapter itaadapter = ArrayAdapter.createFromResource(this,
                        R.array.itagenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(itaadapter);
                break;
            case SOM:
                nameref.setText(getString(R.string.name_som));
                phoneref.setText(getString(R.string.phone_som));
                genderref.setText(getString(R.string.Gender_som));
                ageref.setText(getString(R.string.age_som));
                age.setHint(getString(R.string.approx_som));
                addrref.setText(getString(R.string.addr_som));
                langref.setText(getString(R.string.lang_som));
                moreinforef.setText(getString(R.string.more_info_som));
                submit.setText(getString(R.string.next_som));
                ArrayAdapter somadapter = ArrayAdapter.createFromResource(this,
                        R.array.somgenderOptions, R.layout.custom_spinner);
                adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
                genderOptions.setAdapter(somadapter);
                break;
            default:
                nameref.setText(getString(R.string.name_eng));
                phoneref.setText(getString(R.string.phone_eng));
                genderref.setText(getString(R.string.Gender_eng));
                ageref.setText(getString(R.string.age_eng));
                age.setHint(getString(R.string.approx_eng));
                addrref.setText(getString(R.string.addr_eng));
                langref.setText(getString(R.string.lang_eng));
                moreinforef.setText(getString(R.string.more_info_eng));
                submit.setText(getString(R.string.next_eng));
        }

        final List<String> languagesSpoken = new ArrayList<>();
        final AppCompatActivity context = this;

        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items =
                        {"English","বাঙালি","中文","Français", "Español", "Italiano", "Somali"};

                final ArrayList<Integer> seletedItems = new ArrayList<>();

                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Select languages you speak")
                        .setMultiChoiceItems(items,
                                null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    seletedItems.add(indexSelected);
                                } else if (seletedItems.contains(indexSelected)) {
                                    seletedItems.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                StringBuilder sb = new StringBuilder();
                                for(int pos : seletedItems){
                                    String language = items[pos].toString();
                                    languagesSpoken.add(language);
                                    sb.append(language).append(", ");
                                }
                                sb.setLength(sb.length() - 2);
                                ((TextView) findViewById(R.id.languagesSelect))
                                        .setText(sb.toString());
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        }).create();
                dialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int i = Integer.parseInt(age.getText().toString());
                    rb.setReferee(new Referee(name.getText().toString(),
                            address.getText().toString(),
                            ((TextView) findViewById(R.id.customSpinner)).getText().toString(),
                            phone.getText().toString(), i,
                            languagesSpoken
                    ));
                    toIssues();
                } catch (NumberFormatException e){
                    numberError();
                }
            }
        });

    }

    private void numberError() {
        Toast.makeText(this, "Invalid age", Toast.LENGTH_LONG).show();
    }

    private void toIssues(){
        Intent toIssues = new Intent(this, IssueSelector.class);
        toIssues.putExtra("Language", lang);
        toIssues.putExtra("request", rb);
        startActivity(toIssues);
        this.finish();
    }
}
