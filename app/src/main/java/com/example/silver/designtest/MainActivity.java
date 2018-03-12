package com.example.silver.designtest;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView inscr,oublie;
    Button connect;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //font : "CodeLight"
        TextView tx = findViewById(R.id.title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/code.otf");
        tx.setTypeface(custom_font);
        //end font load


        inscr =  findViewById(R.id.inscription);
        oublie =  findViewById(R.id.motDePasseOublie);
        connect =  findViewById(R.id.connect);


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Test Button!", Toast.LENGTH_LONG).show();
                intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });

        inscr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Test Forgotten!", Toast.LENGTH_LONG).show();
                intent = new Intent(getApplicationContext(), PassOublie.class);
                startActivity(intent);

            }
        });

        oublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Test Inscription!", Toast.LENGTH_LONG).show();
                intent = new Intent(getApplicationContext(), Inscription.class);
                startActivity(intent);
            }
        });







    }
}
