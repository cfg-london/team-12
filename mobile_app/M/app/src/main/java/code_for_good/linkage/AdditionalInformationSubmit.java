package code_for_good.linkage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class AdditionalInformationSubmit extends AppCompatActivity {

    private Request request;
    private Button submit;
    private CheckBox consent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information_submit);

        request = getIntent().getExtras().getParcelable("request");
        submit = findViewById(R.id.finalSubmit);
        consent = findViewById(R.id.consentCheck);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(consent.isChecked()){
                    //TODO
                } else {
                    remindAccept();
                }
            }
        });
    }

    private void remindAccept(){
        Toast.makeText(this, "Please tick the checkbox", Toast.LENGTH_LONG);
    }

}
