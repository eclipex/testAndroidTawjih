package com.example.silver.designtest.Activités;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.FavorisPOJO;
import com.example.silver.designtest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favoris extends AppCompatActivity {

    Button consult1, consult2, del1,del2;
    TextView section1,filiere1,etab1,score1,code1,section2,filiere2,etab2,score2,code2;
    SharedPreferences sharedPreferences;
    ApiInterface apiInterface;
    int test1,test2;

    LinearLayout linearLayout1, linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);


        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("idUser",1);
         test1 = 0;
         test2 = 0;

        section1 = findViewById(R.id.section1);
        filiere1 = findViewById(R.id.filiere1);
        etab1 = findViewById(R.id.etab1);
        score1 = findViewById(R.id.scr1);
        code1 = findViewById(R.id.code1);

        section2 = findViewById(R.id.section2);
        filiere2 = findViewById(R.id.filiere2);
        etab2 = findViewById(R.id.etab2);
        score2 = findViewById(R.id.scr2);
        code2 = findViewById(R.id.code2);

        consult1 = findViewById(R.id.consult1);
        del1 = findViewById(R.id.delete1);

        consult2 = findViewById(R.id.consult2);
        del2 = findViewById(R.id.delete2);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<FavorisPOJO> call = apiInterface.getFavoris(userId);
        call.enqueue(new Callback<FavorisPOJO>() {
            @Override
            public void onResponse(Call<FavorisPOJO> call, Response<FavorisPOJO> response) {

                Log.v("faveee",response.message());

                test1= response.body().getFav1();
                test2 = response.body().getFav2();

                if ( test1 != 0  ) {
                    Call<DiplomePOJO> callDiplome = apiInterface.getDiplomeByCode(response.body().getFav1());
                    callDiplome.enqueue(new Callback<DiplomePOJO>() {

                        @Override
                        public void onResponse(Call<DiplomePOJO> call, Response<DiplomePOJO> response) {

                            DiplomePOJO diplome = response.body();

                            String section = diplome.getSection();
                            String filiere = diplome.getFiliere();
                            String etablissement = diplome.getEtablissement();
                            String score = diplome.getScore().toString();
                            String code = diplome.getCode();

                            section1.setText("Section : " + section);
                            filiere1.setText("Filiere : " +filiere );
                            etab1.setText("Etablissement : " +etablissement );
                            score1.setText("Score :" + score);
                            code1.setText("Code :" + code);

                        }

                        @Override
                        public void onFailure(Call<DiplomePOJO> call, Throwable t) {
                            Log.v("faveee", t.getMessage());


                        }
                    });
                }
                if( test2 != 0)
                {
                    Call<DiplomePOJO> callDiplome2 = apiInterface.getDiplomeByCode(response.body().getFav2());
                    callDiplome2.enqueue(new Callback<DiplomePOJO>() {

                        @Override
                        public void onResponse(Call<DiplomePOJO> call, Response<DiplomePOJO> response) {

                            DiplomePOJO diplome = response.body();

                            String section = diplome.getSection();
                            String filiere = diplome.getFiliere();
                            String etablissement = diplome.getEtablissement();
                            String score = diplome.getScore().toString();
                            String code = diplome.getCode();


                            section2.setText("Section : " + section);
                            filiere2.setText("Filiere : " +filiere );
                            etab2.setText("Etablissement : " +etablissement );
                            score2.setText("Score :" + score);
                            code2.setText("Code :" + code);

                        }

                        @Override
                        public void onFailure(Call<DiplomePOJO> call, Throwable t) {
                            Log.v("faveee",t.getMessage());


                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<FavorisPOJO> call, Throwable t) {


            }
        });






    }
}
