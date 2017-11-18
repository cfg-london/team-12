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

import org.w3c.dom.Text;

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

        TextView nameV = (TextView) findViewById(R.id.nameView);
        TextView phoneV = (TextView) findViewById(R.id.phoneView);
        TextView emailV = (TextView) findViewById(R.id.emailView);
        TextView addrV = (TextView) findViewById(R.id.addrView);
        TextView workV = (TextView) findViewById(R.id.workView);
        TextView moreinfoV = (TextView) findViewById(R.id.moreinfoView);

        switch (lang) {
            case ENG:
                nameV.setText(getString(R.string.name_eng));
                phoneV.setText(getString(R.string.phone_eng));
                emailV.setText(getString(R.string.email_eng));
                addrV.setText(getString(R.string.addr_eng));
                workV.setText(getString(R.string.work_eng));
                moreinfoV.setText(getString(R.string.more_info_eng));
                submit.setText(getString(R.string.next_eng));
                break;
            case BNG:
                nameV.setText(getString(R.string.name_bng));
                phoneV.setText(getString(R.string.phone_bng));
                emailV.setText(getString(R.string.email_bng));
                addrV.setText(getString(R.string.addr_bng));
                workV.setText(getString(R.string.work_bng));
                moreinfoV.setText(getString(R.string.more_info_bng));
                submit.setText(getString(R.string.next_bng));
                break;
            case CHI:
                nameV.setText(getString(R.string.name_chi));
                phoneV.setText(getString(R.string.phone_chi));
                emailV.setText(getString(R.string.email_chi));
                addrV.setText(getString(R.string.addr_chi));
                workV.setText(getString(R.string.work_chi));
                moreinfoV.setText(getString(R.string.more_info_chi));
                submit.setText(getString(R.string.next_chi));
                break;
            case FRA:
                nameV.setText(getString(R.string.name_fra));
                phoneV.setText(getString(R.string.phone_fra));
                emailV.setText(getString(R.string.email_fra));
                addrV.setText(getString(R.string.addr_fra));
                workV.setText(getString(R.string.work_fra));
                moreinfoV.setText(getString(R.string.more_info_fra));
                submit.setText(getString(R.string.next_fra));
                break;
            case ESP:
                nameV.setText(getString(R.string.name_esp));
                phoneV.setText(getString(R.string.phone_esp));
                emailV.setText(getString(R.string.email_esp));
                addrV.setText(getString(R.string.addr_esp));
                workV.setText(getString(R.string.work_esp));
                moreinfoV.setText(getString(R.string.more_info_esp));
                submit.setText(getString(R.string.next_esp));
                break;
            case ITA:
                nameV.setText(getString(R.string.name_ita));
                phoneV.setText(getString(R.string.phone_ita));
                emailV.setText(getString(R.string.email_ita));
                addrV.setText(getString(R.string.addr_ita));
                workV.setText(getString(R.string.work_ita));
                moreinfoV.setText(getString(R.string.more_info_ita));
                submit.setText(getString(R.string.next_ita));
                break;
            case SOM:
                nameV.setText(getString(R.string.name_som));
                phoneV.setText(getString(R.string.phone_som));
                emailV.setText(getString(R.string.email_som));
                addrV.setText(getString(R.string.addr_som));
                workV.setText(getString(R.string.work_som));
                moreinfoV.setText(getString(R.string.more_info_som));
                submit.setText(getString(R.string.next_som));
                break;
            default:
                nameV.setText(getString(R.string.name_eng));
                phoneV.setText(getString(R.string.phone_eng));
                emailV.setText(getString(R.string.email_eng));
                addrV.setText(getString(R.string.addr_eng));
                workV.setText(getString(R.string.work_eng));
                moreinfoV.setText(getString(R.string.more_info_eng));
                submit.setText(getString(R.string.next_eng));
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
