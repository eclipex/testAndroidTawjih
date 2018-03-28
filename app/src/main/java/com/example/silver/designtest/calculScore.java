package com.example.silver.designtest;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.InputDevice;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.support.constraint.ConstraintSet.WRAP_CONTENT;

public class calculScore extends AppCompatActivity {


    Spinner spinner;
    ConstraintLayout layout;
    Button show;
    int oldPos;
    String Bac[]= {"Section Bac : ","Mathematiques","Lettres","Informatique","Sciences","Technique","Sport"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner = findViewById(R.id.spinner);
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter();
        spinner.setAdapter(customSpinnerAdapter);


        show = findViewById(R.id.show);
        //si l'utilisateur clique 2 fois sur le boutton afficher
        oldPos = -1;
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()," Position selectionnée : "+ spinner.getSelectedItemPosition() ,Toast.LENGTH_LONG).show();
                int pos = spinner.getSelectedItemPosition();

                if ( pos != oldPos){

                oldPos = pos;


                LinearLayout linearLayout = findViewById(R.id.addLayout);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMarginStart(30);
                params.setMargins(0,0,0,10);


                switch (spinner.getSelectedItemPosition())
                {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Veillez selectionner une section ", Toast.LENGTH_LONG).show();
                        break;
                    case 1:


                        final EditText math = new EditText(getApplicationContext());
                        final EditText moyenne = new EditText(getApplicationContext());
                        final EditText sciences = new EditText(getApplicationContext());
                        final EditText physique = new EditText(getApplicationContext());
                        final EditText francais = new EditText(getApplicationContext());
                        final EditText anglais = new EditText(getApplicationContext());
                        final TextView resultat = new TextView(getApplicationContext());

                        math.setHint("Maths");
                        moyenne.setHint("Moyenne");
                        sciences.setHint("sciences");
                        physique.setHint("physique");
                        anglais.setHint("anglais");
                        francais.setHint("francais");


                        math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        sciences.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                        sciences.setLayoutParams(params);
                        physique.setLayoutParams(params);
                        anglais.setLayoutParams(params);
                        math.setLayoutParams(params);
                        francais.setLayoutParams(params);
                        moyenne.setLayoutParams(params);



                        linearLayout.addView(math);
                        linearLayout.addView(anglais);
                        linearLayout.addView(francais);
                        linearLayout.addView(sciences);
                        linearLayout.addView(physique);
                        linearLayout.addView(moyenne);



                        Button btnTest = new Button(getApplicationContext());
                        btnTest.setText("Recuperer");
                        btnTest.setLayoutParams(params);
                        linearLayout.addView(btnTest);


                        btnTest.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                float mathNote = Float.parseFloat(String.valueOf(math.getText()));
                                float sciencesNote = Float.parseFloat(String.valueOf(sciences.getText()));
                                float anglaisNote = Float.parseFloat(String.valueOf(anglais.getText()));
                                float francaisNote = Float.parseFloat(String.valueOf(francais.getText()));
                                float physiqueNote = Float.parseFloat(String.valueOf(physique.getText()));
                                float moyenneNote = Float.parseFloat(String.valueOf(moyenne.getText()));


                                float scoreCalcul = (float) (5*moyenneNote + 2*mathNote + 1.5*physiqueNote + 0.5*sciencesNote + ( francaisNote + anglaisNote)/2);


                                Toast.makeText(getApplicationContext(),"Votre score est : "+scoreCalcul,Toast.LENGTH_LONG).show();
                            }

                        });




                }}
            }
        });

    }

    class CustomSpinnerAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Bac.length;
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


            view =  getLayoutInflater().inflate(R.layout.spinner_custom_layout,null);
            TextView text = view.findViewById(R.id.textView);
            text.setText(Bac[i]);
            return view;
        }
    }


}
