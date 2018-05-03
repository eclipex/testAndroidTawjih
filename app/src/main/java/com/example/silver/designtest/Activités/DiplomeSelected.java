package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiplomeSelected extends AppCompatActivity {

    TextView cap,etab,score,filiere,section,code,domaine,param;
    String itemCode,itemDomaine,itemEtablissement,itemParam,itemSection,itemFilere;
    Integer itemCapacite,itemScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplome_selected);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int idSelected = extras.getInt("diplomeId",1);

         cap = findViewById(R.id.cap);
         etab = findViewById(R.id.etablissement);
         score = findViewById(R.id.score);
         filiere = findViewById(R.id.filiere);
         section = findViewById(R.id.section);
         code = findViewById(R.id.code);
         domaine = findViewById(R.id.domaine);





        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DiplomePOJO> call = apiInterface.getDiplome(idSelected);
        call.enqueue(new Callback<DiplomePOJO>() {
            @Override
            public void onResponse(Call<DiplomePOJO> call, Response<DiplomePOJO> response) {

                DiplomePOJO diplome = response.body();

                itemCode = diplome.getCode();
                itemDomaine = diplome.getDomaine();
                itemEtablissement = diplome.getEtablissement().toLowerCase();
                itemCapacite = diplome.getCapacite();
                itemScore = diplome.getScore();
                itemParam = diplome.getParam();
                itemFilere = diplome.getFiliere();
                itemSection= diplome.getSection();

                code.setText("Code : "+itemCode);
                domaine.setText("Domaine : "+itemDomaine);
                etab.setText("Etablissement : "+itemEtablissement);
                cap.setText("Capacité : "+itemCapacite);
                score.setText("Score : "+itemScore);
                filiere.setText("Filiere : "+ itemFilere);
                section.setText("Section : "+itemSection);


            }

            @Override
            public void onFailure(Call<DiplomePOJO> call, Throwable t) {
                Log.v("klkl",t.getMessage());
            }
        });


    }
}
