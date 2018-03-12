package com.example.silver.designtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {


    ImageView rech,param,profil,disc;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        rech =  findViewById(R.id.icRech);
        param =  findViewById(R.id.icSetting);
        profil =  findViewById(R.id.icProfil);
        disc =  findViewById(R.id.icDisc);

        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Parametres.class);
                startActivity(intent);
            }
        });


        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Recherche.class);
                startActivity(intent);
            }
        });
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
            }
        });




    }
}
