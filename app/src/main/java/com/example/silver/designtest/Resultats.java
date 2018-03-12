package com.example.silver.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Resultats extends AppCompatActivity {

    ListView liste;
    int image = R.drawable.logoiset;
    String nomFiliere = "Licence Appliquée en Technologie  Informatiques" ;
    String nomEtab = "Institut Supérieur des Etudes Technologiques de Zaghouan" ;
    int scoreMin = 125;
    int capacite = 1100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        liste =  findViewById(R.id.listeRes);
        CustomAdapter customAdapter = new CustomAdapter();
        liste.setAdapter(customAdapter );
    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
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

            view =  getLayoutInflater().inflate(R.layout.list_view_custom_layout,null);

            ImageView imageView =  view.findViewById(R.id.img);
            TextView nom =  view.findViewById(R.id.nom);
            TextView desc =  view.findViewById(R.id.desc);
            TextView cap =  view.findViewById(R.id.capacite);
            TextView score =  view.findViewById(R.id.score);


            imageView.setImageResource(image);
            nom.setText(nomFiliere);
            desc.setText(nomEtab);
            cap.setText("Capacité : "+ capacite);
            score.setText("Score Min : "+ scoreMin);

            return view;
        }
    }
}
