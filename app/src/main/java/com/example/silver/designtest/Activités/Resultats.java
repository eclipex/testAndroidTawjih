package com.example.silver.designtest.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.silver.designtest.Adapters.DiplomeAdapter;
import com.example.silver.designtest.Adapters.DomaineAdapter;
import com.example.silver.designtest.Adapters.EtablissementAdapter;
import com.example.silver.designtest.Adapters.FiliereAdapter;
import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.DomainePOJO;
import com.example.silver.designtest.Modeles.EtablissementPOJO;
import com.example.silver.designtest.Modeles.FilierePOJO;
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


                    final List<DiplomePOJO> domaines = response.body();
                    DiplomeAdapter customAdapter = new DiplomeAdapter(domaines, getApplicationContext());
                    liste.setAdapter(customAdapter);
                    liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            int idSelected = domaines.get(i).getId();
                            Intent intentDiplome = new Intent(getApplicationContext(),DiplomeSelected.class);
                            intentDiplome.putExtra("diplomeId",idSelected);
                            startActivity(intentDiplome);




                        }
                    });
                }

                @Override
                public void onFailure(Call<List<DiplomePOJO>> call, Throwable t) {
                    Log.i("oui", t.getMessage());

                }

            });


        }else if (racineRecherche.equals("domaine"))
        {
            Call<List<DomainePOJO>> callListe = apiInterface.getDomaines();
            callListe.enqueue(new Callback<List<DomainePOJO>>() {
                @Override
                public void onResponse(final Call<List<DomainePOJO>> call, Response<List<DomainePOJO>> response) {


                    List<DomainePOJO> domaines = response.body();

                    //Log.i("oui",domaines.get(0).getDesignation());

                    DomaineAdapter customAdapter = new DomaineAdapter(domaines, getApplicationContext());

                    liste.setAdapter(customAdapter);
                    liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Call<DomainePOJO> domainePOJOCall = apiInterface.getDomaine(i + 1);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<DomainePOJO>> call, Throwable t) {
                    Log.i("oui", t.getMessage());

                }

            });
        }
        else if (racineRecherche.equals("etablissement")){

            Call<List<EtablissementPOJO>> listCall = apiInterface.getEtablissements();
            listCall.enqueue(new Callback<List<EtablissementPOJO>>() {
                @Override
                public void onResponse(Call<List<EtablissementPOJO>> call, Response<List<EtablissementPOJO>> response) {

                    List<EtablissementPOJO> etablissements = response.body();
                    final EtablissementAdapter etablissementAdapter = new EtablissementAdapter( etablissements , getApplicationContext());
                    liste.setAdapter(etablissementAdapter);
                    liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            EtablissementPOJO selectedItem = (EtablissementPOJO) etablissementAdapter.getItem(i);

                        }
                    });
                }

                @Override
                public void onFailure(Call<List<EtablissementPOJO>> call, Throwable t) {

                }
            });

        }else if (racineRecherche.equals("filiere"))
        {
            Call<List<FilierePOJO>> listCall = apiInterface.getFilieres();
            listCall.enqueue(new Callback<List<FilierePOJO>>() {
                @Override
                public void onResponse(Call<List<FilierePOJO>> call, Response<List<FilierePOJO>> response) {

                    List<FilierePOJO> filieres = response.body();
                    FiliereAdapter filiereAdapter = new FiliereAdapter (filieres, getApplicationContext());
                    liste.setAdapter(filiereAdapter);
                }

                @Override
                public void onFailure(Call<List<FilierePOJO>> call, Throwable t) {

                }
            });

        }
        else{
            Toast.makeText(getApplicationContext(),"Pas encore implementé",Toast.LENGTH_SHORT).show();
        }
    }


}
