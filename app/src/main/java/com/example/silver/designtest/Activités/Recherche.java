package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.silver.designtest.R;

public class Recherche extends AppCompatActivity {

    Button rech;
    Intent intent;
    Spinner section;
    EditText score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rech = findViewById(R.id.rech);
        score =  findViewById(R.id.scoreChanged);
        section =  findViewById(R.id.sectionRech);

        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        int scoreUser = sharedPreferences.getInt("scoreUser",150);
        CreateSpinner(section);
        score.setText(String.valueOf(scoreUser));



        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int scoreSelected = Integer.parseInt(score.getText().toString());
                intent = new Intent(getApplicationContext(), Resultats.class);
                intent.putExtra("score",scoreSelected);
                intent.putExtra("section",section.getSelectedItemPosition());
                intent.putExtra("Methode","perso");
                startActivity(intent);
            }
        });









    }

    private void CreateSpinner ( Spinner spinner)
    {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Section,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
    }
}
