package com.example.silver.designtest;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {


    TextView inscr,oublie;
    Button connect;
    Intent intent;
    ApiInterface apiInterface;
    EditText cin,pass;



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
        cin = findViewById(R.id.cin);
        pass = findViewById(R.id.pass);


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {


                if ( cin.getText().toString().equals("") == false && pass.getText().toString().equals("") == false)
                {

                    int cinRecupere = Integer.parseInt(cin.getText().toString());
                    final String passRecupere = pass.getText().toString();

                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    Call <UserPOJO> userPOJOCall = apiInterface.getUser(cinRecupere, passRecupere);

                    userPOJOCall.enqueue(new Callback<UserPOJO>() {
                        @Override
                        public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {

                            UserPOJO userPOJO = response.body();
                            //Log.v("body" , response.errorBody().toString());
                            if (userPOJO != null)
                            {
                                if (userPOJO.getPass().toString().equals(passRecupere)) {
                                    Toast.makeText(getApplicationContext(),"Connected as : " + userPOJO.getNom(),Toast.LENGTH_LONG).show();
                                    intent = new Intent(getApplicationContext(), Menu.class);
                                    startActivity(intent);

                                } else
                                    Toast.makeText(getApplicationContext(),"Veillez Verifier vos coordonnées",Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(getApplicationContext(),"Cin n'exsite pas",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<UserPOJO> call, Throwable t) {

                        }
                    });
                }else
                    Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs",Toast.LENGTH_LONG).show();


            }
        });

        inscr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                intent = new Intent(getApplicationContext(), PassOublie.class);
                startActivity(intent);

            }
        });

        oublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                intent = new Intent(getApplicationContext(), Inscription.class);
                startActivity(intent);
            }
        });







    }
}
