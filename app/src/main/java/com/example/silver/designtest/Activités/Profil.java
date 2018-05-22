package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.R;

public class Profil extends AppCompatActivity {
    //ToDo : Review textviews, bold

    Button rech,mod,score;
    TextView nom,scr,section,mail,cin;
    Intent intent;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        nom = findViewById(R.id.name);
        mail=  findViewById(R.id.mail);
        scr = findViewById(R.id.scr);
        section = findViewById(R.id.bac);

        score = findViewById(R.id.changeScore);
        rech = findViewById(R.id.rech);
        mod = findViewById(R.id.modifier);
        cin = findViewById(R.id.cin);

        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);

        nom.setText("Nom : "+sharedPreferences.getString("nomUser","SuperAdmin")+" "+sharedPreferences.getString("prenomUser"," "));
        scr.setText( "Score : "+ sharedPreferences.getInt("scoreUser",150));
        section.setText("Section : "+sharedPreferences.getString("sectionUser","SuperAdmin"));
        mail.setText("Email : "+sharedPreferences.getString("emailUser","SuperAdmin@root.Su"));
        cin.setText("Cin : " +sharedPreferences.getInt("cinUser",0));



        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SelectSearchMethod.class);
                startActivity(intent);
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Parametres.class);
                startActivity(intent);
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SelectSession.class);
                startActivity(intent);
            }
        });


    }
}
