package code_for_good.linkage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class RefereeDetails extends AppCompatActivity {

    private Spinner genderOptions;

    private EditText name;
    private EditText phone;
    private EditText age;
    private EditText address;
    private TextView languages;
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
        languages = (TextView) findViewById(R.id.refereeInputLanguages);

        final Context context = this;

        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Select the languages you speak");
            }
        });

        submit = (Button) findViewById(R.id.refereeInputNext);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setReferee(new Referee(name.getText().toString(),
                        address.getText().toString(),
                        ((TextView) findViewById(R.id.customSpinner)).getText().toString(),
                        phone.getText().toString(), Integer.parseInt(age.getText().toString()),
                        new ArrayList<String>()
                        ));
                //TODO lanuages
                toIssues();
            }
        });

    }

    private void toIssues(){
        Intent toIssues = new Intent(this, IssueSelector.class);
        toIssues.putExtra("request", rb);
        startActivity(toIssues);
        this.finish();
    }
}
