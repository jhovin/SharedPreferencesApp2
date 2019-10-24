package pe.ebenites.sharedpreferencesapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import pe.ebenites.sharedpreferencesapp.R;

public class PollActivity extends AppCompatActivity {


    private TextView nombreInput;
    private SharedPreferences sp;

    private EditText carreraInput;

    private RadioGroup grupoRadios;

    private CheckBox aceptarCheckbox;

    private Button envButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);


        nombreInput=findViewById(R.id.nombre_text);


        sp = PreferenceManager.getDefaultSharedPreferences(this);



        grupoRadios = findViewById(R.id.grup_button);
        grupoRadios .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.m_radio:
                        sp.edit().putString("radio", "M").commit();
                        break;
                    case R.id.f_radio:
                        sp.edit().putString("radio", "F").commit();
                        break;
                }
            }
        });

        String gender = sp.getString("radio", null);
        if(gender != null) {
            if("M".equals(gender)) {
                grupoRadios .check(R.id.m_radio);
            }else if("F".equals(gender)) {
                grupoRadios .check(R.id.f_radio);
            }

        }


        aceptarCheckbox = findViewById(R.id.acep_checkbox);
        aceptarCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("aceptar", isChecked).commit();
            }
        });


        boolean acep = sp.getBoolean("aceptar", false);
        if(acep) {
            aceptarCheckbox.setChecked(acep);
        }


    }

}
