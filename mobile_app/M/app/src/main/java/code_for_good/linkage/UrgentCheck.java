package code_for_good.linkage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UrgentCheck extends AppCompatActivity {


    private Languages lang;
    private boolean urgency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_check);

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
    }

    public void urgent() {

    }

    public void nonUrgent() {

    }
}
