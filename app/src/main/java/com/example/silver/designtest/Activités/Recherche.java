package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.silver.designtest.R;

public class Recherche extends AppCompatActivity {

    Button rech;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rech = findViewById(R.id.rech);

        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Resultats.class);
                startActivity(intent);
            }
        });

        Spinner spinner1 =  findViewById(R.id.domaine);
        Spinner spinner2 =  findViewById(R.id.etab);
        Spinner spinner3 =  findViewById(R.id.diplome);
        Spinner spinner4 =  findViewById(R.id.region);

        CreateSpinner(spinner4);
        CreateSpinner(spinner3);
        CreateSpinner(spinner2);
        CreateSpinner(spinner1);



    }

    private void CreateSpinner ( Spinner spinner)
    {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.regions,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
    }
}
