package code_for_good.linkage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IssueSelector extends AppCompatActivity {

    private Button buttonIsolation;
    private Button buttonSafetyAtHome;
    private Button buttonLegal;
    private Button buttonCrisis;
    private Button buttonMedical;
    private Button buttonTransport;
    private Button buttonHelpAroundHouse;
    private Button buttonStayingInHome;
    private Button buttonMoney;

    private Languages lang;

    private EditText additional;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_selector);

        lang = (Languages) getIntent().getSerializableExtra("Language");

        buttonIsolation = (Button) findViewById(R.id.buttonIsolation);
        buttonSafetyAtHome = (Button) findViewById(R.id.buttonSafetyAtHome);
        buttonLegal = (Button) findViewById(R.id.buttonSafetyAtHome);
        buttonCrisis = (Button) findViewById(R.id.buttonCrisis);
        buttonMedical = (Button) findViewById(R.id.buttonMedical);
        buttonTransport = (Button) findViewById(R.id.buttonTransport);
        buttonHelpAroundHouse = (Button) findViewById(R.id.buttonHelpAroundTheHouse);
        buttonStayingInHome = (Button) findViewById(R.id.buttonStayingInTheirHome);
        buttonMoney = (Button) findViewById(R.id.buttonMoneyAndBenefits);

        buttonIsolation.setTag(0);
        buttonSafetyAtHome.setTag(0);
        buttonLegal.setTag(0);
        buttonCrisis.setTag(0);
        buttonMedical.setTag(0);
        buttonTransport.setTag(0);
        buttonHelpAroundHouse.setTag(0);
        buttonStayingInHome.setTag(0);
        buttonMoney.setTag(0);

        additional = (EditText) findViewById(R.id.additional);
        confirm = (Button) findViewById(R.id.confirm);

        switch (lang) {
            case ENG:
                additional.setHint(getString(R.string.addInfo_eng));
                confirm.setText(getString(R.string.cfm_eng));
                break;
            case BNG:
                additional.setHint(getString(R.string.addInfo_bng));
                confirm.setText(getString(R.string.cfm_bng));
                buttonIsolation.setText("Sāmājika bicchinnatā (nirbācita naẏa)");
                buttonSafetyAtHome.setText("Bāṛitē nirāpattā (nirbācita naẏa)");
                buttonLegal.setText("Ā\'ini sahāẏatā (nirbācita naẏa)");
                buttonCrisis.setText("Saṅkaṭa (nirbācita naẏa)");
                buttonMedical.setText("Mēḍikēla isyu (nirbācita naẏa)");
                buttonTransport.setText("Paribahana ēbaṁ gatiśīlatā (nirbācita naẏa)");
                buttonHelpAroundHouse.setText("Bāṛira cārapāśē sāhāyya karuna (nirbācita naẏa)");
                buttonStayingInHome.setText("Tādēra bāṛitē thākuna (nirbācita naẏa)");
                buttonMoney.setText("Artha ēbaṁ upakāritā (nirbācita naẏa)");
                break;
            case CHI:
                additional.setHint(getString(R.string.addInfo_chi));
                confirm.setText(getString(R.string.cfm_chi));
                buttonIsolation.setText("社会隔离（未选择）");
                buttonSafetyAtHome.setText("家中安全（未选择）");
                buttonLegal.setText("法律帮助（未选择）");
                buttonCrisis.setText("危机（未选定）");
                buttonMedical.setText("医疗问题（未选择）");
                buttonTransport.setText("运输与流动（未选择）");
                buttonHelpAroundHouse.setText("帮助周围的房子（未选定）");
                buttonStayingInHome.setText("留在家里（未选定）");
                buttonMoney.setText("金钱和福利（未选择）");
                break;
            case FRA:
                additional.setHint(getString(R.string.addInfo_fra));
                confirm.setText(getString(R.string.cfm_fra));
                buttonIsolation.setText("Isolement social (non sélectionné)");
                buttonSafetyAtHome.setText("Sécurité à la maison (non sélectionné)");
                buttonLegal.setText("Aide juridique (non sélectionnée)");
                buttonCrisis.setText("Crise (non sélectionnée)");
                buttonMedical.setText("Problème médical (non sélectionné)");
                buttonTransport.setText("Transport et mobilité (non sélectionné)");
                buttonHelpAroundHouse.setText("Aide autour de la maison (Non sélectionné)");
                buttonStayingInHome.setText("Rester dans leur maison (non sélectionné)");
                buttonMoney.setText("Argent et avantages (non sélectionné)");
                break;
            case ESP:
                additional.setHint(getString(R.string.addInfo_esp));
                confirm.setText(getString(R.string.cfm_esp));
                buttonIsolation.setText("Aislamiento social (No seleccionado)");
                buttonSafetyAtHome.setText("Seguridad en el hogar (No seleccionado)");
                buttonLegal.setText("Ayuda legal (no seleccionada)");
                buttonCrisis.setText("Crisis (no seleccionada)");
                buttonMedical.setText("Problema médico (no seleccionado)");
                buttonTransport.setText("Transporte y movilidad (No seleccionado)");
                buttonHelpAroundHouse.setText("Ayudando en la casa (No seleccionado)");
                buttonStayingInHome.setText("Alojarse en su casa (No seleccionado)");
                buttonMoney.setText("Dinero y beneficios (No seleccionado)");
                break;
            case ITA:
                additional.setHint(getString(R.string.addInfo_ita));
                confirm.setText(getString(R.string.cfm_ita));
                buttonIsolation.setText("Isolamento sociale (non selezionato)");
                buttonSafetyAtHome.setText("Sicurezza a casa (non selezionato)");
                buttonLegal.setText("Guida legale (non selezionata)");
                buttonCrisis.setText("Crisi (non selezionato)");
                buttonMedical.setText("Problema medico (non selezionato)");
                buttonTransport.setText("Trasporto e mobilità (non selezionato)");
                buttonHelpAroundHouse.setText("Aiutare in casa (non selezionato)");
                buttonStayingInHome.setText("Stare nella propria casa (non selezionato)");
                buttonMoney.setText("Soldi e vantaggi (non selezionato)");
                break;
            case SOM:
                additional.setHint(getString(R.string.addInfo_som));
                confirm.setText(getString(R.string.cfm_som));
                buttonIsolation.setText("Iskudarinta Bulshada (Looma dooran)");
                buttonSafetyAtHome.setText("Ammaanka Guriga (Looma Xushay)");
                buttonLegal.setText("Caawin sharci (Lama doorto)");
                buttonCrisis.setText("Dhibaato (Lama doorto)");
                buttonMedical.setText("Warqadda Caafimaadka (Looma dooran)");
                buttonTransport.setText("Gaadiidka iyo socodka (Looma doorto)");
                buttonHelpAroundHouse.setText("Ka caawi hareeraha guriga (Lama doorto)");
                buttonStayingInHome.setText("Joogitaanka guryahooda (Lama doorto)");
                buttonMoney.setText("Lacagta iyo faa'iidooyinka (Looma dooran)");
                break;
            default:
                additional.setHint(getString(R.string.addInfo_eng));
                confirm.setText(getString(R.string.cfm_eng));
        }

        final RequestBuilder requestBuilder = getIntent().getParcelableExtra("request");

        buttonIsolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Isolation");
                if((Integer) buttonIsolation.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonIsolation.setText("Sāmājika bicchinnatā (nirbācita)");
                            break;
                        case CHI:
                            buttonIsolation.setText("社会隔离（选定）");
                            break;
                        case FRA:
                            buttonIsolation.setText("Isolement social (sélectionné)");
                            break;
                        case ESP:
                            buttonIsolation.setText("Aislamiento social (Seleccionado)");
                            break;
                        case ITA:
                            buttonIsolation.setText("Isolamento sociale (selezionato)");
                            break;
                        case SOM:
                            buttonIsolation.setText("Iskudarinta Bulshada (la xushay)");
                            break;
                        default:
                            break;
                    }
                    buttonIsolation.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonIsolation.setText("Sāmājika bicchinnatā (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonIsolation.setText("社会隔离（未选择）");
                            break;
                        case FRA:
                            buttonIsolation.setText("Isolement social (non sélectionné)");
                            break;
                        case ESP:
                            buttonIsolation.setText("Aislamiento social (No seleccionado)");
                            break;
                        case ITA:
                            buttonIsolation.setText("Isolamento sociale (non selezionato)");
                            break;
                        case SOM:
                            buttonIsolation.setText("Iskudarinta Bulshada (Looma dooran)");
                            break;
                        default:
                            break;
                    }
                    buttonIsolation.setTag(0);
                }
            }
        });

        buttonSafetyAtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Safety at home");
                if((Integer) buttonSafetyAtHome.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonSafetyAtHome.setText("Bāṛitē nirāpattā (nirbācita)");
                            break;
                        case CHI:
                            buttonSafetyAtHome.setText("家中安全（选择）");
                            break;
                        case FRA:
                            buttonSafetyAtHome.setText("Sécurité à la maison (sélectionné)");
                            break;
                        case ESP:
                            buttonSafetyAtHome.setText("Seguridad en el hogar (seleccionado)");
                            break;
                        case ITA:
                            buttonSafetyAtHome.setText("Sicurezza a casa (selezionato)");
                            break;
                        case SOM:
                            buttonSafetyAtHome.setText("Badbaadada guriga (xulay)");
                            break;
                        default:
                            break;
                    }
                    buttonSafetyAtHome.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonSafetyAtHome.setText("Bāṛitē nirāpattā (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonSafetyAtHome.setText("家中安全（未选择）");
                            break;
                        case FRA:
                            buttonSafetyAtHome.setText("Sécurité à la maison (non sélectionné)");
                            break;
                        case ESP:
                            buttonSafetyAtHome.setText("Seguridad en el hogar (No seleccionado)");
                            break;
                        case ITA:
                            buttonSafetyAtHome.setText("Sicurezza a casa (non selezionato)");
                            break;
                        case SOM:
                            buttonSafetyAtHome.setText("Ammaanka Guriga (Looma Xushay)");
                            break;
                        default:
                            break;
                    }
                    buttonSafetyAtHome.setTag(0);
                }
            }
        });

        buttonLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Legal");
                if((Integer) buttonLegal.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonLegal.setText("Ā\'ini sahāẏatā (nirbācita)");
                            break;
                        case CHI:
                            buttonLegal.setText("法律帮助（选择）");
                            break;
                        case FRA:
                            buttonLegal.setText("Aide juridique (sélectionnée)");
                            break;
                        case ESP:
                            buttonLegal.setText("Ayuda legal (seleccionada)");
                            break;
                        case ITA:
                            buttonLegal.setText("Guida legale (selezionata)");
                            break;
                        case SOM:
                            buttonLegal.setText("Kaalmo sharci (doorasho)");
                            break;
                        default:
                            break;
                    }
                    buttonLegal.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonLegal.setText("Ā\'ini sahāẏatā (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonLegal.setText("法律帮助（未选择）");
                            break;
                        case FRA:
                            buttonLegal.setText("Aide juridique (non sélectionnée)");
                            break;
                        case ESP:
                            buttonLegal.setText("Ayuda legal (no seleccionada)");
                            break;
                        case ITA:
                            buttonLegal.setText("Guida legale (non selezionata)");
                            break;
                        case SOM:
                            buttonLegal.setText("Caawin sharci (Lama doorto)");
                            break;
                        default:
                            break;
                    }
                    buttonLegal.setTag(0);
                }
            }
        });

        buttonCrisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Crisis / Mental Issues");
                if((Integer) buttonCrisis.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonCrisis.setText("Saṅkaṭa (nirbācita)");
                            break;
                        case CHI:
                            buttonCrisis.setText("危机（选定）");
                            break;
                        case FRA:
                            buttonCrisis.setText("Crise (sélectionnée)");
                            break;
                        case ESP:
                            buttonCrisis.setText("Crisis (seleccionada)");
                            break;
                        case ITA:
                            buttonCrisis.setText("Crisi (selezionato)");
                            break;
                        case SOM:
                            buttonCrisis.setText("Xiisad (doorasho)");
                            break;
                        default:
                            break;
                    }
                    buttonCrisis.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonCrisis.setText("Saṅkaṭa (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonCrisis.setText("危机（未选定）");
                            break;
                        case FRA:
                            buttonCrisis.setText("Crise (non sélectionnée)");
                            break;
                        case ESP:
                            buttonCrisis.setText("Crisis (no seleccionada)");
                            break;
                        case ITA:
                            buttonCrisis.setText("Crisi (non selezionato)");
                            break;
                        case SOM:
                            buttonCrisis.setText("Dhibaato (Lama doorto)");
                            break;
                        default:
                            break;
                    }
                    buttonCrisis.setTag(0);
                }
            }
        });

        buttonMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Medical Issue");
                if((Integer) buttonMedical.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonMedical.setText("Mēḍikēla isyu (nirbācita)");
                            break;
                        case CHI:
                            buttonMedical.setText("医疗问题（选择）");
                            break;
                        case FRA:
                            buttonMedical.setText("Problème médical (sélectionné)");
                            break;
                        case ESP:
                            buttonMedical.setText("Problema médico (seleccionado)");
                            break;
                        case ITA:
                            buttonMedical.setText("Problema medico (selezionato)");
                            break;
                        case SOM:
                            buttonMedical.setText("Arrin caafimaad (doorasho)");
                            break;
                        default:
                            break;
                    }
                    buttonMedical.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonMedical.setText("Mēḍikēla isyu (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonMedical.setText("医疗问题（未选择）");
                            break;
                        case FRA:
                            buttonMedical.setText("Problème médical (non sélectionné)");
                            break;
                        case ESP:
                            buttonMedical.setText("Problema médico (no seleccionado)");
                            break;
                        case ITA:
                            buttonMedical.setText("Problema medico (non selezionato)");
                            break;
                        case SOM:
                            buttonMedical.setText("Warqadda Caafimaadka (Looma dooran)");
                            break;
                        default:
                            break;
                    }
                    buttonMedical.setTag(0);
                }
            }
        });

        buttonTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Transport / Mobility Issues");
                if((Integer) buttonTransport.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonTransport.setText("Paribahana ēbaṁ gatiśīlatā (nirbācita)");
                            break;
                        case CHI:
                            buttonTransport.setText("运输与流动（选择）");
                            break;
                        case FRA:
                            buttonTransport.setText("Transport et mobilité (sélectionné)");
                            break;
                        case ESP:
                            buttonTransport.setText("Transporte y movilidad (seleccionado)");
                            break;
                        case ITA:
                            buttonTransport.setText("Trasporto e mobilità (selezionato)");
                            break;
                        case SOM:
                            buttonTransport.setText("Gaadiidka iyo dhaqdhaqaaqa (doorasho)");
                            break;
                        default:
                            break;
                    }
                    buttonTransport.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonTransport.setText("Paribahana ēbaṁ gatiśīlatā (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonTransport.setText("运输与流动（未选择）");
                            break;
                        case FRA:
                            buttonTransport.setText("Transport et mobilité (non sélectionné)");
                            break;
                        case ESP:
                            buttonTransport.setText("Transporte y movilidad (No seleccionado)");
                            break;
                        case ITA:
                            buttonTransport.setText("Trasporto e mobilità (non selezionato)");
                            break;
                        case SOM:
                            buttonTransport.setText("Gaadiidka iyo socodka (Looma doorto)");
                            break;
                        default:
                            break;
                    }
                    buttonTransport.setTag(0);
                }
            }
        });

        buttonStayingInHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Issues involving staying in their home");
                if((Integer) buttonStayingInHome.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonStayingInHome.setText("Tādēra bāṛitē thākuna (nirbācita)");
                            break;
                        case CHI:
                            buttonStayingInHome.setText("留在家里（选定）");
                            break;
                        case FRA:
                            buttonStayingInHome.setText("Rester dans leur maison (sélectionné)");
                            break;
                        case ESP:
                            buttonStayingInHome.setText("Alojarse en su casa (seleccionado)");
                            break;
                        case ITA:
                            buttonStayingInHome.setText("Stare nella propria casa (selezionato)");
                            break;
                        case SOM:
                            buttonStayingInHome.setText("Joogitaanka guryahooda (xulay)");
                            break;
                        default:
                            break;
                    }
                    buttonStayingInHome.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonStayingInHome.setText("Tādēra bāṛitē thākuna (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonStayingInHome.setText("留在家里（未选定）");
                            break;
                        case FRA:
                            buttonStayingInHome.setText("Rester dans leur maison (non sélectionné)");
                            break;
                        case ESP:
                            buttonStayingInHome.setText("Alojarse en su casa (No seleccionado)");
                            break;
                        case ITA:
                            buttonStayingInHome.setText("Stare nella propria casa (non selezionato)");
                            break;
                        case SOM:
                            buttonStayingInHome.setText("Joogitaanka guryahooda (Lama doorto)");
                            break;
                        default:
                            break;
                    }
                    buttonStayingInHome.setTag(0);
                }
            }
        });

        buttonMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Money / Benefits Issue");
                if((Integer) buttonMoney.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonMoney.setText("Artha ēbaṁ upakāritā (nirbācita)");
                            break;
                        case CHI:
                            buttonMoney.setText("金钱和福利（选择）");
                            break;
                        case FRA:
                            buttonMoney.setText("Argent et avantages (sélectionné)");
                            break;
                        case ESP:
                            buttonMoney.setText("Dinero y beneficios (seleccionado)");
                            break;
                        case ITA:
                            buttonMoney.setText("Soldi e vantaggi (selezionato)");
                            break;
                        case SOM:
                            buttonMoney.setText("Lacagta iyo faa'iidooyinka (doorashada)");
                            break;
                        default:
                            break;
                    }
                    buttonMoney.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonMoney.setText("Artha ēbaṁ upakāritā (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonMoney.setText("金钱和福利（未选择）");
                            break;
                        case FRA:
                            buttonMoney.setText("Argent et avantages (non sélectionné)");
                            break;
                        case ESP:
                            buttonMoney.setText("Dinero y beneficios (No seleccionado)");
                            break;
                        case ITA:
                            buttonMoney.setText("Soldi e vantaggi (non selezionato)");
                            break;
                        case SOM:
                            buttonMoney.setText("Lacagta iyo faa'iidooyinka (Looma dooran)");
                            break;
                        default:
                            break;
                    }
                    buttonMoney.setTag(0);
                }
            }
        });

        buttonHelpAroundHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.toggleIssue("Requires help around the house");
                if((Integer) buttonHelpAroundHouse.getTag() == 0){
                    switch (lang) {
                        case BNG:
                            buttonHelpAroundHouse.setText("Bāṛira cārapāśē sāhāyya karuna (nirbācita)");
                            break;
                        case CHI:
                            buttonHelpAroundHouse.setText("帮助周围的房子（选定）");
                            break;
                        case FRA:
                            buttonHelpAroundHouse.setText("Aide autour de la maison (sélectionné)");
                            break;
                        case ESP:
                            buttonHelpAroundHouse.setText("Ayudando en la casa (seleccionado)");
                            break;
                        case ITA:
                            buttonHelpAroundHouse.setText("Aiutare in casa (selezionato)");
                            break;
                        case SOM:
                            buttonHelpAroundHouse.setText("Ka caawi hareeraha guriga (xulay)");
                            break;
                        default:
                            break;
                    }
                    buttonHelpAroundHouse.setTag(1);
                }
                else {
                    switch (lang) {
                        case BNG:
                            buttonHelpAroundHouse.setText("Bāṛira cārapāśē sāhāyya karuna (nirbācita naẏa)");
                            break;
                        case CHI:
                            buttonHelpAroundHouse.setText("帮助周围的房子（未选定）");
                            break;
                        case FRA:
                            buttonHelpAroundHouse.setText("Aide autour de la maison (Non sélectionné)");
                            break;
                        case ESP:
                            buttonHelpAroundHouse.setText("Ayudando en la casa (No seleccionado)");
                            break;
                        case ITA:
                            buttonHelpAroundHouse.setText("Aiutare in casa (non selezionato)");
                            break;
                        case SOM:
                            buttonHelpAroundHouse.setText("Ka caawi hareeraha guriga (Lama doorto)");
                            break;
                        default:
                            break;
                    }
                    buttonHelpAroundHouse.setTag(0);
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestBuilder.addIssue(additional.getText().toString());
                Request request = requestBuilder.build();
                toSubmit(request);
            }
        });
    }

    private void toSubmit(Request request){
        Intent intent = new Intent(this, AdditionalInformationSubmit.class);
        intent.putExtra("request", request);
        startActivity(intent);
        this.finish();
    }
}
