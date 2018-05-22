package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.UserPOJO;
import com.example.silver.designtest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscription extends AppCompatActivity {

    EditText cin,mail,nom,prenom,pass,score;
    Spinner section;
    Button valider;
    ApiInterface apiInterface;
    String mailContent,nomContent,prenomContent,passContent;
    int cinContent,sectionContent,scoreContent;

    private void CreateSpinner ( Spinner spinner)
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Section,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
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

        CreateSpinner(section);

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
                if ( section.getSelectedItemPosition() != 0)
                    sectionContent = section.getSelectedItemPosition()+1;
                if ( !score.getText().toString().equals(""))
                    scoreContent = Integer.parseInt( score.getText().toString());

                if (checkNotEmpty(mailContent, nomContent, prenomContent, passContent) && scoreContent != 0
                         && cinContent != 0 ) {
                    Call<UserPOJO> userPOJOCall = apiInterface.addUser(cinContent,passContent,nomContent,prenomContent,mailContent,sectionContent,
                            scoreContent);
                    userPOJOCall.enqueue(new Callback<UserPOJO>() {
                                             @Override
                                             public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {

                                                 Log.v("abx",response.code()+"");

                                                 if(response.code() == 226)
                                                 {
                                                     cin.setError("Cette CIN est deja utilisée.");
                                                     mail.setError("Cette adresse mail est deja utilisée.");
                                                     Toast.makeText(getApplicationContext(), "CIN/Email existe deja, Veillez verifier vos données.", Toast.LENGTH_SHORT).show();


                                                 }else if( response.code() == 201)
                                                 {
                                                     Toast.makeText(getApplicationContext(), "Compte crée, Veillez vous connecter a votre compte.", Toast.LENGTH_SHORT).show();
                                                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                     startActivity(intent);
                                                 }
                                             }

                                             @Override
                                             public void onFailure(Call<UserPOJO> call, Throwable t) {

                                                 Log.v("abxt",t.getLocalizedMessage());
                                             }
                                         }
                    );
                } else
                    Toast.makeText(getApplicationContext(), "Veillez remplir tous les champs", Toast.LENGTH_SHORT).show();

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
