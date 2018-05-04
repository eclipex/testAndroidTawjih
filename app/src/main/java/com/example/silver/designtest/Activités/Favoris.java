package com.example.silver.designtest.Activités;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
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

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);



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
            public void onResponse(Call<FavorisPOJO> call, final Response<FavorisPOJO> response) {

                if (response.isSuccessful())
                {

                    String section = response.body().getSectionFav1();
                    String filiere = response.body().getFiliereFav1();
                    String etablissement = response.body().getEtablissementFav1();
                    String score = String.valueOf(response.body().getScoreFav1());
                    final String code = response.body().getCodeFav1();


                    section1.setText("Section : " + section);
                    filiere1.setText("Filiere : " +filiere );
                    etab1.setText("Etablissement : " +etablissement );
                    score1.setText("Score :" + score);
                    code1.setText("Code :" + code);

                    String section23 = response.body().getSectionFav2();
                    String filiere23 = response.body().getFiliereFav2();
                    String etablissement23 = response.body().getEtablissementFav2();
                    String score23 = String.valueOf(response.body().getScoreFav2());
                    final String code23 = response.body().getCodeFav2();

                    section2.setText("Section : " + section23);
                    filiere2.setText("Filiere : " +filiere23 );
                    etab2.setText("Etablissement : " +etablissement23 );
                    score2.setText("Score :" + score23);
                    code2.setText("Code :" + code23);

                    consult1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                            intentDiplome.putExtra("diplomeCode",code);
                            startActivity(intentDiplome);

                        }
                    });

                    consult2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                            intentDiplome.putExtra("diplomeCode",  code23);
                            startActivity(intentDiplome);

                        }
                    });

                    del1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                            int userId = sharedPreferences.getInt("idUser",1);
                            delFav(response.body().getIdDiplome1(),null,userId);

                        }
                    });

                    del2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                            int userId = sharedPreferences.getInt("idUser",1);
                            delFav(null,response.body().getIdDiplome2(),userId);

                        }
                    });


                }


            }

            @Override
            public void onFailure(Call<FavorisPOJO> call, Throwable t) {


            }
        });






    }


    private void delFav(final Integer idDiplome1,final Integer idDiplome2, final Integer userId ) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Favoris.this);
        builder.setMessage("Vous etes sur de vouloir supprimer ce diplome de la liste de favoris ? ")
                .setTitle("Confirmation de Suppression")
                .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(Favoris.this,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

                                ApiInterface apiInterface2= ApiClient.getApiClient().create(ApiInterface.class);
                                Call<FavorisPOJO> favorisPOJOCall = apiInterface2.patchFavoris(userId, null,null,idDiplome1,idDiplome2);
                                favorisPOJOCall.enqueue(new Callback<FavorisPOJO>() {
                                    @Override
                                    public void onResponse(Call<FavorisPOJO> call, Response<FavorisPOJO> response) {
                                        
                                    }
                                    @Override
                                    public void onFailure(Call<FavorisPOJO> call, Throwable t) {}
                                });
                            }
                        }
                )
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(Favoris.this,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

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
