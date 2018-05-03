package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.silver.designtest.R;

public class SelectSearchMethod extends AppCompatActivity {

    Button sections,etablissements,domaines,filieres,all;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_search_method);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sections = findViewById(R.id.etablissements);
        all = findViewById(R.id.all);
        filieres = findViewById(R.id.filieres);
        etablissements = findViewById(R.id.etablissements);
        domaines = findViewById(R.id.domaines);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(getApplicationContext(),Resultats.class);
                intent.putExtra("Methode","diplomes");
                startActivity(intent);
            }
        });

        sections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Resultats.class);
                intent.putExtra("Methode","section");
                startActivity(intent);
            }
        });

        etablissements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Resultats.class);
                intent.putExtra("Methode","etablissement");
                startActivity(intent);
            }
        });

        domaines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Resultats.class);
                intent.putExtra("Methode","domaine");
                startActivity(intent);
            }
        });
        filieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),Resultats.class);
                intent.putExtra("Methode","filiere");
                startActivity(intent);
            }
        });



    }
}
