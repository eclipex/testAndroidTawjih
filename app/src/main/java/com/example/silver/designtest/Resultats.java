package com.example.silver.designtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Resultats extends AppCompatActivity {

    ListView liste;
    private List<DomainePOJO> domaines;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        liste =  findViewById(R.id.listeRes);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        Call< List<DomainePOJO> > callListe = apiInterface.getDomaines();

        final Callback callback = new Callback<DomainePOJO>() {
            @Override
            public void onResponse(Call<DomainePOJO> call, Response<DomainePOJO> response) {
                DomainePOJO domainePOJO = response.body();

                Log.i("oui",response.raw().message() );

                if (domainePOJO != null)
                {
                    Log.i("oui",domainePOJO.toString());

                }

                Toast.makeText(getApplicationContext(),"Designation : "+ domainePOJO.getDesignation(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DomainePOJO> call, Throwable t) {
                Log.i("oui","denya s3iba"+t.getLocalizedMessage());

            }
        };
            callListe.enqueue(new Callback<List<DomainePOJO>>() {
            @Override
            public void onResponse(final Call<List<DomainePOJO>> call, Response<List<DomainePOJO>> response) {

                domaines = response.body();
                //Log.i("oui",domaines.get(0).getDesignation());
                OmarAdapter customAdapter = new OmarAdapter( domaines , getApplicationContext() );
                liste.setAdapter(customAdapter);
                liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Call<DomainePOJO> domainePOJOCall = apiInterface.getDomaine(i+1);
                        domainePOJOCall.enqueue(callback);

                    }
                });


            }

            @Override
            public void onFailure(Call<List<DomainePOJO>> call, Throwable t) {
                Log.i("oui",t.getMessage());

            }

        });




        //domaineCall.enqueue(callback);
    }


    class OmarAdapter extends BaseAdapter {

        private List<DomainePOJO> domaines;
        private Context context;
        private DomainePOJO domainePOJO;

        public OmarAdapter(List<DomainePOJO> domaines,Context context )
        {
            this.context = context;
            this.domaines = domaines;
            this.domainePOJO = null;
        }
        public OmarAdapter(DomainePOJO domainePOJO,Context context )
        {
            this.context = context;
            this.domainePOJO = domainePOJO;
            this.domaines = null;
        }

        @Override
        public int getCount() {

            if (domainePOJO != null )
                return 1;
            else if (domaines != null )
                return domaines.size();
            return 0;
        }

        @Override
        public Object getItem(int i) {

            if (domainePOJO != null)
                return domaines.get(i);
            else
                return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view =  getLayoutInflater().inflate(R.layout.list_view_custom_layout,null);

            TextView designation =  view.findViewById(R.id.nom);


            if( domaines != null)
            {
                if (domaines.size() > 0)
                {
                    DomainePOJO domaine = domaines.get(i);
                    designation.setText(domaine.getDesignation()); //deisgnation
                    Log.i("added",domaine.getDesignation());

                }else
                {

                    designation.setText("Erreur"); //deisgnation

                }
            }else if (domainePOJO != null)
            {
                designation.setText(domainePOJO.getDesignation());
            }

            return view;
        }
    }
}
