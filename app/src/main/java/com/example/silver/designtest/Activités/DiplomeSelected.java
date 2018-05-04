package com.example.silver.designtest.Activités;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.FavorisPOJO;
import com.example.silver.designtest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiplomeSelected extends AppCompatActivity {

    TextView cap,etab,score,filiere,section,code,domaine,param;
    String itemCode,itemDomaine,itemEtablissement,itemParam,itemSection,itemFilere;
    Integer itemCapacite,itemScore;
    Button ajouterFavoris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplome_selected);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String codeSelected = extras.getString("diplomeCode","0");

         cap = findViewById(R.id.cap);
         etab = findViewById(R.id.etablissement);
         score = findViewById(R.id.score);
         filiere = findViewById(R.id.filiere);
         section = findViewById(R.id.section);
         code = findViewById(R.id.code);
         domaine = findViewById(R.id.domaine);
         ajouterFavoris = findViewById(R.id.fav);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DiplomePOJO> call = apiInterface.getDiplomeByCode(codeSelected);
        call.enqueue(new Callback<DiplomePOJO>() {
            @Override
            public void onResponse(Call<DiplomePOJO> call, Response<DiplomePOJO> response) {

                if (response.isSuccessful()){

                    final DiplomePOJO diplome = response.body();

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

                    ajouterFavoris.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                            int userId = sharedPreferences.getInt("idUser",1);
                            addFav(diplome.getId(),userId);

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DiplomePOJO> call, Throwable t) {
                Log.v("klkl",t.getMessage());
            }
        });


    }

    private void addFav(final Integer idDiplome, final int userId ) {

        AlertDialog.Builder builder = new AlertDialog.Builder(DiplomeSelected.this);
        builder.setMessage("Choissisez l'emplacement du favoris ? ")
                .setTitle("Favoris")
                .setPositiveButton("Favoris : 1 ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(DiplomeSelected.this,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

                                ApiInterface apiInterface2= ApiClient.getApiClient().create(ApiInterface.class);
                                Call<FavorisPOJO> favorisPOJOCall = apiInterface2.patchFavoris(userId, idDiplome,null,null,null);
                                favorisPOJOCall.enqueue(new Callback<FavorisPOJO>() {
                                    @Override
                                    public void onResponse(Call<FavorisPOJO> call, Response<FavorisPOJO> response) {}
                                    @Override
                                    public void onFailure(Call<FavorisPOJO> call, Throwable t) {}
                                });
                            }
                        }
                )
                .setNegativeButton("Favoris : 2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(DiplomeSelected.this,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

                        ApiInterface apiInterface2= ApiClient.getApiClient().create(ApiInterface.class);
                        Call<FavorisPOJO> favorisPOJOCall = apiInterface2.patchFavoris(userId, null, idDiplome,null,null);
                        favorisPOJOCall.enqueue(new Callback<FavorisPOJO>() {
                            @Override
                            public void onResponse(Call<FavorisPOJO> call, Response<FavorisPOJO> response) {}
                            @Override
                            public void onFailure(Call<FavorisPOJO> call, Throwable t) {}
                        });
                    }
                });

        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            }
        });
        dialog.show();
    }
}
