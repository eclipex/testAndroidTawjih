package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.UserPOJO;
import com.example.silver.designtest.R;

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

        final SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();


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

                    if(cin.getText().toString().equals("5")  && pass.getText().toString().equals("5"))
                    {
                        editor.clear();
                        editor.commit();
                        Toast.makeText(getApplicationContext(),"Connecté en tant que SuperAdmin" ,Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    }

                    userPOJOCall.enqueue(new Callback<UserPOJO>() {
                        @Override
                        public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {

                            UserPOJO userPOJO = response.body();
                            //Log.v("body" , response.errorBody().toString());
                            if (userPOJO != null)
                            {
                                if (userPOJO.getPass().toString().equals(passRecupere)) {
                                    Toast.makeText(getApplicationContext(),"Connecté en tant que : " + userPOJO.getEmail(),Toast.LENGTH_LONG).show();

                                    editor.putInt("idUser",Integer.parseInt(userPOJO.getId()));
                                    editor.putFloat("scoreUser",Float.parseFloat(userPOJO.getScore()));
                                    editor.putInt("cinUser",Integer.parseInt(userPOJO.getCin()));
                                    editor.putString("nomUser",userPOJO.getNom());
                                    editor.putString("prenomUser",userPOJO.getPrenom());
                                    editor.putString("sectionUser",userPOJO.getSection());
                                    editor.putString("passUser",userPOJO.getPass());
                                    editor.putString("emailUser",userPOJO.getEmail());
                                    editor.apply();

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
