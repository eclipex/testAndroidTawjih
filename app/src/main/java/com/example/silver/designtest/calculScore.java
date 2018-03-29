package com.example.silver.designtest;

import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class calculScore extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout layout;
    Button show;
    int oldPos;
    String Bac[]= {"Section Bac : ","Mathematiques","Lettres","Informatique","Sciences","Economie gestion", "Technique","Sport"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner = findViewById(R.id.spinner );
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter();
        spinner.setAdapter(customSpinnerAdapter);


        show = findViewById(R.id.show);
        //si l'utilisateur clique 2 fois sur le boutton valider
        oldPos = -1;
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int pos = spinner.getSelectedItemPosition();

                if ( pos != oldPos){

                    oldPos = pos;
                    LinearLayout linearLayout = findViewById(R.id.addLayout);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0,5,0,10);


                    switch (spinner.getSelectedItemPosition())
                    {
                        case 0:
                            //effacer l'ancien contenu du layout si l'utilisateur a deja choisi une section
                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();

                            Toast.makeText(getApplicationContext(), "Veillez selectionner une section ", Toast.LENGTH_LONG).show();
                            break;
                        case 1:


                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();

                            final EditText math = new EditText(getApplicationContext());
                            final EditText moyenne = new EditText(getApplicationContext());
                            final EditText sciences = new EditText(getApplicationContext());
                            final EditText physique = new EditText(getApplicationContext());
                            final EditText francais = new EditText(getApplicationContext());
                            final EditText anglais = new EditText(getApplicationContext());
                            final TextView resultat = new TextView(getApplicationContext());

                            math.setHint("Maths");
                            applyStyle(math);
                            moyenne.setHint("Moyenne Generale");
                            applyStyle(moyenne);
                            sciences.setHint("Sciences");
                            applyStyle(sciences);
                            physique.setHint("Physique");
                            applyStyle(physique);
                            anglais.setHint("Anglais");
                            applyStyle(anglais);
                            francais.setHint("Francais");
                            applyStyle(francais);


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

                            linearLayout.addView(moyenne);
                            linearLayout.addView(math);
                            linearLayout.addView(physique);
                            linearLayout.addView(anglais);
                            linearLayout.addView(francais);
                            linearLayout.addView(sciences);




                            Button btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            math.getText().toString().isEmpty() || sciences.getText().toString().isEmpty()
                                            || francais.getText().toString().isEmpty() || anglais.getText().toString().isEmpty() ||
                                            physique.getText().toString().isEmpty() || sciences.getText().toString().isEmpty() ;

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty){

                                        float mathNote = Float.parseFloat(String.valueOf(math.getText()));
                                        if(mathNote > 20 || mathNote< 0)
                                        {
                                            math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sciencesNote = Float.parseFloat(String.valueOf(sciences.getText()));
                                        if(sciencesNote > 20 || sciencesNote< 0)
                                        {
                                            sciences.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(anglais.getText()));
                                        if(anglaisNote > 20 || anglaisNote< 0)
                                        {
                                            anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(francais.getText()));
                                        if(francaisNote > 20 || francaisNote< 0)
                                        {
                                            francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(physique.getText()));
                                        if(physiqueNote > 20 || physiqueNote< 0)
                                        {
                                            physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float moyenneNote = Float.parseFloat(String.valueOf(moyenne.getText()));
                                        if(moyenneNote > 20 || moyenneNote< 0)
                                        {
                                            moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }


                                         scoreCalcul = (float) (5*moyenneNote + 2*mathNote + 1.5*physiqueNote + 0.5*sciencesNote + ( francaisNote + anglaisNote)/2);
                                    }

                                    if (allFieldsAreCorrect && !fieldsEmpty){

                                        Toast.makeText(getApplicationContext(),"Votre score est : "+scoreCalcul,Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }

                                    else
                                        if (fieldsEmpty)
                                            Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                        else
                                            Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break ;

                        case 2:
                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();

                            final EditText L_arabe = new EditText(getApplicationContext());
                            final EditText L_moyenne = new EditText(getApplicationContext());
                            final EditText L_philo = new EditText(getApplicationContext());
                            final EditText L_his_geo = new EditText(getApplicationContext());
                            final EditText L_francais= new EditText(getApplicationContext());
                            final EditText L_anglais = new EditText(getApplicationContext());

                            L_arabe.setHint("Arabe");
                            L_moyenne.setHint("Moyenne Generale");
                            L_philo.setHint("philosophie");
                            L_his_geo.setHint("Histoire et géographie");
                            L_anglais.setHint("Anglais");
                            L_francais.setHint("Francais");


                            applyStyle(L_arabe);
                            applyStyle(L_moyenne);
                            applyStyle(L_philo);
                            applyStyle(L_his_geo);
                            applyStyle(L_anglais);
                            applyStyle(L_francais);


                            L_arabe.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_philo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_his_geo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            L_moyenne.setLayoutParams(params);
                            L_arabe.setLayoutParams(params);
                            L_philo.setLayoutParams(params);
                            L_his_geo.setLayoutParams(params);
                            L_anglais.setLayoutParams(params);
                            L_francais.setLayoutParams(params);



                            linearLayout.addView(L_moyenne);
                            linearLayout.addView(L_arabe);
                            linearLayout.addView(L_philo);
                            linearLayout.addView(L_his_geo);
                            linearLayout.addView(L_anglais);
                            linearLayout.addView(L_francais);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);





                    }
                }
            }
        });



    }

    private void confirmScore(float score) {

        AlertDialog.Builder builder = new AlertDialog.Builder(calculScore.this);
        builder.setMessage("Votre score est : "+score+"\nSauvegarder ? ")
                .setTitle("Confirmation de Score")
                .setPositiveButton("Confimer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(calculScore.this,"Confirmé",Toast.LENGTH_LONG).show();
                            }
                        }
                )
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(calculScore.this,"Annulé",Toast.LENGTH_LONG).show();
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





    void applyStyle (EditText item){

        item.setGravity(Gravity.CENTER);
        item.setBackgroundResource(R.drawable.edit_text_background);
        item.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
        item.setTextSize(20);
        item.setPadding(20,20,20,20);
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
