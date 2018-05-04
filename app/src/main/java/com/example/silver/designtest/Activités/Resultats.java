package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String racineRecherche = extras.getString("Methode");

        liste = findViewById(R.id.listeRes);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        if (racineRecherche.equals("diplomes")) {

            Call<List<DiplomePOJO>> callListe = apiInterface.getDiplomes();
            callListe.enqueue(new Callback<List<DiplomePOJO>>() {
                @Override
                public void onResponse(final Call<List<DiplomePOJO>> call, Response<List<DiplomePOJO>> response) {


                    if (response.isSuccessful()){
                        final List<DiplomePOJO> diplomes = response.body();
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

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {}

            });


        }else if (racineRecherche.equals("domaine"))
        {
            Call<List<DomainePOJO>> callListe = apiInterface.getDomaines();
            callListe.enqueue(new Callback<List<DomainePOJO>>() {
                @Override
                public void onResponse(final Call<List<DomainePOJO>> call, Response<List<DomainePOJO>> response) {


                    if (response.isSuccessful()){
                        final List<DomainePOJO> domaines = response.body();

                        //Log.i("oui",domaines.get(0).getDesignation());

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

                @Override
                public void onFailure(Call<List<DomainePOJO>> call, Throwable t) {}

            });
        }
        else if (racineRecherche.equals("etablissement")){
            Call<List<RegionPOJO>> callListe = apiInterface.getRegions();
            callListe.enqueue(new Callback<List<RegionPOJO>>() {
                @Override
                public void onResponse(final Call<List<RegionPOJO>> call, Response<List<RegionPOJO>> response) {


                    if (response.isSuccessful()) {
                        final List<RegionPOJO> regions = response.body();

                        //Log.i("oui",domaines.get(0).getDesignation());

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
                @Override
                    public void onFailure(Call<List<RegionPOJO>> call, Throwable t) {}
                });



        }
        else{
            Toast.makeText(getApplicationContext(),"Pas encore implementé",Toast.LENGTH_SHORT).show();
        }
    }
}
