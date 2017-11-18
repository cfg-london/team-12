package code_for_good.linkage;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LangAndRegisterActivity extends AppCompatActivity {

    private Language lang;
    private Spinner referrerDropdown;
    private String type;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ImageButton imageButton = (ImageButton) findViewById(R.id.languageFlag);

        TextView iama = (TextView) findViewById(R.id.i_am_a_view);

        this.lang = Language.ENG;

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.engReferrerOptions, R.layout.custom_spinner);

        Button toReg = (Button) findViewById(R.id.toProfile);
        Button noReg = (Button) findViewById(R.id.noRegister);

        message = (TextView) findViewById(R.id.messageOfTheDay);

        if(getIntent().hasExtra("Language_Choice")){
            String languages = getIntent().getStringExtra("Language_Choice");
            switch (languages) {
                case "English":
                    lang = Language.ENG;
                    imageButton.setImageResource(R.mipmap.gb);
                    iama.setText(getString(R.string.i_am_eng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.engReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_eng));
                    noReg.setText(getString(R.string.dont_register_eng));
                    break;
                case "বাঙালি":
                    lang = Language.BNG;
                    imageButton.setImageResource(R.mipmap.bd);
                    iama.setText(getString(R.string.i_am_bng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.bngReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_bng));
                    noReg.setText(getString(R.string.dont_register_bng));
                    break;
                case "中文":
                    lang = Language.CHI;
                    imageButton.setImageResource(R.mipmap.cn);
                    iama.setText(getString(R.string.i_am_chi));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.chiReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_chi));
                    noReg.setText(getString(R.string.dont_register_chi));
                    break;
                case "Français":
                    lang = Language.FRA;
                    imageButton.setImageResource(R.mipmap.fr);
                    iama.setText(getString(R.string.i_am_fra));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.fraReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_fra));
                    noReg.setText(getString(R.string.dont_register_fra));
                    break;
                case "Español":
                    lang = Language.ESP;
                    imageButton.setImageResource(R.mipmap.es);
                    iama.setText(getString(R.string.i_am_esp));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.espReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_esp));
                    noReg.setText(getString(R.string.dont_register_esp));
                    break;
                case "Italiano":
                    imageButton.setImageResource(R.mipmap.it);
                    lang = Language.ITA;
                    iama.setText(getString(R.string.i_am_ita));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.itaReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_ita));
                    noReg.setText(getString(R.string.dont_register_ita));
                    break;
                case "Somali":
                    lang = Language.SOM;
                    imageButton.setImageResource(R.mipmap.so);
                    iama.setText(getString(R.string.i_am_som));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.somReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_som));
                    noReg.setText(getString(R.string.dont_register_som));
                    break;
                default:
                    lang = Language.ENG;
                    imageButton.setImageResource(R.mipmap.gb);
                    iama.setText(getString(R.string.i_am_eng));
                    adapter = ArrayAdapter.createFromResource(this,
                            R.array.engReferrerOptions, R.layout.custom_spinner);
                    toReg.setText(getString(R.string.register_eng));
                    noReg.setText(getString(R.string.dont_register_eng));
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

    private void setMessage(String s){
        message.setText(s);
    }

    private class NotificationGetter extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            URL url = null;
            try {
                url = new URL("http://34.241.158.221/Admin/message.txt");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));
                String inputLine;
                StringBuilder sb = new StringBuilder();
                while ((inputLine = in.readLine()) != null){
                    System.out.println(inputLine);
                    sb.append(inputLine);
                }
                in.close();
                return sb.toString();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            setMessage(s);
        }
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
        intent.putExtra("profile", new UserProfile(type, "", "", "", "", ""));
        startActivity(intent);
        this.finish();
    }
}
