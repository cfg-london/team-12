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

    private RequestBuilder rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referee_details);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.genderOptions, R.layout.custom_spinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        genderOptions = (Spinner) findViewById(R.id.genderDropdown);
        genderOptions.setAdapter(adapter);

        rb = getIntent().getExtras().getParcelable("request");

        name = (EditText) findViewById(R.id.refereeInputName);
        phone = (EditText) findViewById(R.id.refereeInputPhone);
        age = (EditText) findViewById(R.id.refereeInputAge);
        address = (EditText) findViewById(R.id.refereeInputAddress);
        languages = (LinearLayout) findViewById(R.id.refereeInputLanguages);

        final List<String> languagesSpoken = new ArrayList<>();
        final AppCompatActivity context = this;

        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"English","বাঙালি","中文","Français", "Español", "Italiano", "Somali"};

                final ArrayList<Integer> seletedItems = new ArrayList<>();

                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Select languages you speak")
                        .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
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
                                ((TextView) findViewById(R.id.languagesSelect)).setText(sb.toString());
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        }).create();
                dialog.show();
            }
        });

        submit = (Button) findViewById(R.id.refereeInputNext);

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
        Toast.makeText(this, "Invalid age", Toast.LENGTH_LONG);
    }

    private void toIssues(){
        Intent toIssues = new Intent(this, IssueSelector.class);
        toIssues.putExtra("request", rb);
        startActivity(toIssues);
        this.finish();
    }
}
