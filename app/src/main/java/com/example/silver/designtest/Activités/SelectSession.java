package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.silver.designtest.R;

public class SelectSession extends AppCompatActivity {

    Button controle,principale;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_session);

        controle = findViewById(R.id.controle);
        principale = findViewById(R.id.principale);


        principale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(SelectSession.this, CalculScorePrincipale.class);
                intent.putExtra("session","controle");
                startActivity(intent);

            }
        });

        controle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(SelectSession.this, CalculScoreControle.class);
                intent.putExtra("session","principale");
                startActivity(intent);

            }
        });

    }
}
