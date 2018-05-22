package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.silver.designtest.Adapters.DiplomeAdapter;
import com.example.silver.designtest.Adapters.DomaineAdapter;
import com.example.silver.designtest.Adapters.RegionAdapter;
import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.DomainePOJO;
import com.example.silver.designtest.Modeles.RegionPOJO;
import com.example.silver.designtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Resultats extends AppCompatActivity {

    ListView liste;
    TextView titreRecherche;
    private ApiInterface apiInterface;
    ConstraintLayout loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);


        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String racineRecherche = extras.getString("Methode");

        liste = findViewById(R.id.listeRes);
        loading = findViewById(R.id.loading);

        titreRecherche = findViewById(R.id.titreRech);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        if (racineRecherche.equals("diplomes")) {
            titreRecherche.setText("Liste des diplomes : ");
            Call<List<DiplomePOJO>> callListe = apiInterface.getDiplomes();
            callListe.enqueue(new Callback<List<DiplomePOJO>>() {
                @Override
                public void onResponse(final Call<List<DiplomePOJO>> call, Response<List<DiplomePOJO>> response) {


                    if (response.isSuccessful()){
                        final List<DiplomePOJO> diplomes = response.body();
                        if (diplomes.size() == 0)
                            liste.setEmptyView(findViewById(R.id.notfound));
                        else
                        {
                            loading.setVisibility(View.GONE);
                            DiplomeAdapter customAdapter = new DiplomeAdapter(diplomes, getApplicationContext());
                            liste.setAdapter(customAdapter);
                            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                }

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {
                    loading.setVisibility(View.GONE);
                    liste.setEmptyView(findViewById(R.id.empty));
                }

            });


        }else if (racineRecherche.equals("domaine"))
        {
            titreRecherche.setText("Liste des domaines : ");
            Call<List<DomainePOJO>> callListe = apiInterface.getDomaines();
            callListe.enqueue(new Callback<List<DomainePOJO>>() {
                @Override
                public void onResponse(final Call<List<DomainePOJO>> call, Response<List<DomainePOJO>> response) {


                    if (response.isSuccessful()){
                        final List<DomainePOJO> domaines = response.body();
                        if(domaines.size() == 0)
                            liste.setEmptyView(findViewById(R.id.notfound));

                        else{
                            loading.setVisibility(View.GONE);
                            DomaineAdapter customAdapter = new DomaineAdapter(domaines, getApplicationContext());

                            liste.setAdapter(customAdapter);
                            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    String codeSelected = domaines.get(i).getId();
                                    Intent intentFiliere = new Intent(getApplicationContext(),SousResultats.class);
                                    intentFiliere.putExtra("sousRech","domaine");
                                    intentFiliere.putExtra("domaineCode",codeSelected);
                                    startActivity(intentFiliere);

                                }
                            });
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<DomainePOJO>> call, Throwable t) {
                    liste.setEmptyView(findViewById(R.id.empty));
                }

            });
        }
        else if (racineRecherche.equals("etablissement")){

            titreRecherche.setText("Liste des regions : ");

            Call<List<RegionPOJO>> callListe = apiInterface.getRegions();
            callListe.enqueue(new Callback<List<RegionPOJO>>() {
                @Override
                public void onResponse(final Call<List<RegionPOJO>> call, Response<List<RegionPOJO>> response) {


                    if (response.isSuccessful()) {
                        final List<RegionPOJO> regions = response.body();
                        if (regions.size() == 0)
                            liste.setEmptyView(findViewById(R.id.notfound));
                        else{
                            loading.setVisibility(View.GONE);
                            RegionAdapter customAdapter = new RegionAdapter(regions, getApplicationContext());

                            liste.setAdapter(customAdapter);
                            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    String codeSelected = regions.get(i).getId();
                                    Intent intentFiliere = new Intent(getApplicationContext(), SousResultats.class);
                                    intentFiliere.putExtra("sousRech", "region");
                                    intentFiliere.putExtra("idRegion", codeSelected);
                                    startActivity(intentFiliere);


                                }
                            });
                        }
                    }
                }
                @Override
                    public void onFailure(Call<List<RegionPOJO>> call, Throwable t) {
                    liste.setEmptyView(findViewById(R.id.empty));
                }
                });



        }
        else if (racineRecherche.equals("perso")){


            int score= extras.getInt("score");
            int section = extras.getInt("section");
            titreRecherche.setText("Score : "+score);

            Call<List<DiplomePOJO>> callListe = apiInterface.getDiplomesCustom(score,section+1);
            callListe.enqueue(new Callback<List<DiplomePOJO>>() {

                @Override
                public void onResponse(final Call<List<DiplomePOJO>> call, Response<List<DiplomePOJO>> response) {


                    if (response.isSuccessful()){

                        final List<DiplomePOJO> diplomes = response.body();
                        if (diplomes.size() == 0) {
                            liste.setEmptyView(findViewById(R.id.notfound));
                        } else{
                            loading.setVisibility(View.GONE);
                            DiplomeAdapter customAdapter = new DiplomeAdapter(diplomes, getApplicationContext());
                            liste.setAdapter(customAdapter);
                            liste.setEmptyView(findViewById(R.id.notfound));
                            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    String codeSelected = diplomes.get(i).getCode();
                                    Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                                    intentDiplome.putExtra("diplomeCode",codeSelected);
                                    startActivity(intentDiplome);
                                }
                            });
                        }
                    }else{
                    }
                }

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {
                    liste.setEmptyView(findViewById(R.id.empty));
                }

            });
        }
    }
}
