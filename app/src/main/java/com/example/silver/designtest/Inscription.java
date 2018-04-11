package com.example.silver.designtest;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscription extends AppCompatActivity {

    EditText cin,mail,nom,prenom,pass,section,score;
    Button valider;
    ApiInterface apiInterface;
    String mailContent,nomContent,prenomContent,passContent;
    int cinContent,sectionContent,scoreContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        cin = findViewById(R.id.cin);
        mail = findViewById(R.id.mail);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        pass = findViewById(R.id.pass);
        section = findViewById(R.id.section);
        score = findViewById(R.id.score);
        valider = findViewById(R.id.valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                mailContent = mail.getText().toString();
                nomContent = nom.getText().toString();
                prenomContent = prenom.getText().toString();
                passContent = pass.getText().toString();
                if ( !cin.getText().toString().equals(""))
                    cinContent = Integer.parseInt( cin.getText().toString());
                if ( !section.getText().toString().equals(""))
                    sectionContent = Integer.parseInt( section.getText().toString());
                if ( !score.getText().toString().equals(""))
                    scoreContent = Integer.parseInt( score.getText().toString());

                if ( checkNotEmpty(mailContent,nomContent,prenomContent,passContent   ) == true && scoreContent != 0
                        && sectionContent != 0 && cinContent != 0 ) {
                    Call<UserPOJO> userPOJOCall = apiInterface.addUser(cinContent,passContent,nomContent,prenomContent,mailContent,sectionContent,
                            scoreContent);
                    userPOJOCall.enqueue(new Callback<UserPOJO>() {
                                             @Override
                                             public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                                                 Toast.makeText(getApplicationContext(), "Compte crée", Toast.LENGTH_SHORT).show();
                                             }

                                             @Override
                                             public void onFailure(Call<UserPOJO> call, Throwable t) {

                                             }
                                         }
                    );
                } else
                    Toast.makeText(getApplicationContext(), "Veilez remplir tous les champs", Toast.LENGTH_SHORT).show();

            }
        });





    }


    public boolean checkNotEmpty(String param, String param1,
                                 String param2, String param3
                                 )
    {
        if ( !param.equals("") && !param1.equals("") && !param2.equals("") && !param3.equals("") )
            return true;
        else
            return false;
    }
}
