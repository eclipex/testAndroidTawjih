package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.UserPOJO;
import com.example.silver.designtest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parametres extends AppCompatActivity {

    ApiInterface apiInterface;

    Spinner spinner;
    EditText ancien,nouv;
    Button savePass,sectionchange;
    Intent intent;
    String Bac[]= {"Changer de section :" ,"Mathematiques","Sciences experimentales","Sciences Informatiques"
            ,"Lettres","Economie et gestion","Sport","Technique"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        spinner = findViewById(R.id.spinnerSection);
        sectionchange = findViewById(R.id.saveSection);
        savePass = findViewById(R.id.savePassword);
        ancien = findViewById(R.id.passWord);
        nouv = findViewById(R.id.newPass);

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter();
        spinner.setAdapter(customSpinnerAdapter);


        savePass.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String old = ancien.getText().toString();
                String newPass = nouv.getText().toString();


                if (old.equals(sharedPreferences.getString("passUser","default")) )
                {
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                        Call <UserPOJO> call = apiInterface.ModifyUser(sharedPreferences.getInt("idUser",1),null,newPass,
                                null,null,null, null,null);
                        call.enqueue(new Callback<UserPOJO>() {
                            @Override
                            public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {


                            }

                            @Override
                            public void onFailure(Call<UserPOJO> call, Throwable t) {


                            }
                        });
                    intent = new Intent(getApplicationContext(), Menu.class);
                    //Toast.makeText(getApplicationContext(), "Parametres sauvegardés", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else
                {
                    ancien.setError("Veillez verifier le mot de passe");
                }


            }
        });

        sectionchange.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Integer spin = spinner.getSelectedItemPosition();
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                if(spin == 0){
                    Toast.makeText(getApplicationContext(), "Veillez Selectionner une section", Toast.LENGTH_SHORT).show();
                }else
                    {

                    Call <UserPOJO> call = apiInterface.ModifyUser(sharedPreferences.getInt("idUser",1),null,null,
                            null,null,null, spin,null);
                    call.enqueue(new Callback<UserPOJO>() {
                        @Override
                        public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {


                        }

                        @Override
                        public void onFailure(Call<UserPOJO> call, Throwable t) {


                        }
                    });
                    intent = new Intent(getApplicationContext(), Menu.class);
                    Toast.makeText(getApplicationContext(), "Parametres sauvegardés", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });




    }

    class CustomSpinnerAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Bac.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            view =  getLayoutInflater().inflate(R.layout.spinner_custom_layout,null);
            TextView text = view.findViewById(R.id.textView);
            text.setText(Bac[i]);
            return view;
        }
    }
}
