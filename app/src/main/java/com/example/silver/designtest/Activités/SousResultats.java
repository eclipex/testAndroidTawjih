package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.silver.designtest.Adapters.DiplomeAdapter;
import com.example.silver.designtest.Adapters.EtablissementAdapter;
import com.example.silver.designtest.Adapters.FiliereAdapter;
import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.EtablissementPOJO;
import com.example.silver.designtest.Modeles.FilierePOJO;
import com.example.silver.designtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SousResultats extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sous_resultats);

        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        listView = findViewById(R.id.listeRes);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String racineRecherche = extras.getString("sousRech");

        if (racineRecherche.equals("domaine"))
        {
            String codeDomaine = extras.getString("domaineCode");


            final Call<List<FilierePOJO>> listCall = apiInterface.getFilieres(codeDomaine);
            listCall.enqueue(new Callback<List<FilierePOJO>>() {
                @Override
                public void onResponse(Call<List<FilierePOJO>> call, Response<List<FilierePOJO>> response) {
                    if (response.isSuccessful()){
                        final List<FilierePOJO> filieres = response.body();
                        final FiliereAdapter filiereAdapter = new FiliereAdapter(filieres,getApplicationContext());
                        listView.setAdapter(filiereAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String idFiliere = filieres.get(i).getId();
                                Intent intentFiliere = new Intent(getApplicationContext(),SousResultats.class);
                                intentFiliere.putExtra("sousRech","filiere");
                                intentFiliere.putExtra("filiereId",idFiliere);
                                startActivity(intentFiliere);
                            }
                        });
                    }

                }

                @Override
                public void onFailure(Call<List<FilierePOJO>> call, Throwable t) {

                }
            });
        }else if (racineRecherche.equals("filiere")){

            String idFiliere = extras.getString("filiereId");
            final Call<List<DiplomePOJO>> listCall = apiInterface.getDiplomes(idFiliere);

            listCall.enqueue(new Callback<List<DiplomePOJO>>() {
                @Override
                public void onResponse(Call<List<DiplomePOJO>> call, Response<List<DiplomePOJO>> response) {
                    if (response.isSuccessful())
                    {
                        final List<DiplomePOJO> diplomes = response.body();
                        DiplomeAdapter customAdapter = new DiplomeAdapter(diplomes, getApplicationContext());
                        listView.setAdapter(customAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                String codeSelected = diplomes.get(i).getCode();
                                Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                                intentDiplome.putExtra("diplomeCode",codeSelected);
                                startActivity(intentDiplome);
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {

                }
            });




        }else if (racineRecherche.equals("etablissement")){
            String idEtablissement = extras.getString("idEtablissement");
            final Call<List<DiplomePOJO>> listCall = apiInterface.getDiplomesByEtab(idEtablissement);

            listCall.enqueue(new Callback<List<DiplomePOJO>>() {
                @Override
                public void onResponse(Call<List<DiplomePOJO>> call, Response<List<DiplomePOJO>> response) {
                    if (response.isSuccessful())
                    {
                        final List<DiplomePOJO> diplomes = response.body();
                        DiplomeAdapter customAdapter = new DiplomeAdapter(diplomes, getApplicationContext());
                        listView.setAdapter(customAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                String codeSelected = diplomes.get(i).getCode();
                                Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                                intentDiplome.putExtra("diplomeCode",codeSelected);
                                startActivity(intentDiplome);
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {

                }
            });

        }else if (racineRecherche.equals("region"))
        {

            String idRegion = extras.getString("idRegion");

            Call<List<EtablissementPOJO>> listCall = apiInterface.getEtablissementByRegion(idRegion);
            listCall.enqueue(new Callback<List<EtablissementPOJO>>() {
                @Override
                public void onResponse(Call<List<EtablissementPOJO>> call, Response<List<EtablissementPOJO>> response) {

                    if (response.isSuccessful()){
                        final List<EtablissementPOJO> etablissements = response.body();
                        EtablissementAdapter etablissementAdapter = new EtablissementAdapter(etablissements,getApplicationContext());
                        listView.setAdapter(etablissementAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                String idSelected =  etablissements.get(i).getId();
                                Intent intentFiliere = new Intent(getApplicationContext(),SousResultats.class);
                                intentFiliere.putExtra("sousRech","etablissement");
                                intentFiliere.putExtra("idEtablissement",idSelected);
                                startActivity(intentFiliere);

                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<EtablissementPOJO>> call, Throwable t) {}
            });
        }

    }

}
