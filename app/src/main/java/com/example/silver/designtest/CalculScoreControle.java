package com.example.silver.designtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

public class CalculScoreControle extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout layout;
    Button show;
    Intent intent;
    int oldPos;
    String Bac[]= {"Section Bac : ","Mathematiques","Lettres","Informatique","Sciences", "Technique","Sport", "Economie et Gestion"};

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

            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
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


                            final EditText mathControle = new EditText(getApplicationContext());
                            final EditText moyenneControle = new EditText(getApplicationContext());
                            final EditText sciencesControle = new EditText(getApplicationContext());
                            final EditText physiqueControle = new EditText(getApplicationContext());
                            final EditText francaisControle = new EditText(getApplicationContext());
                            final EditText anglaisControle = new EditText(getApplicationContext());


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

                            mathControle.setHint("Maths controle");
                            applyStyle(mathControle);
                            moyenneControle.setHint("Moyenne controle");
                            applyStyle(moyenneControle);
                            sciencesControle.setHint("Sciences controle");
                            applyStyle(sciencesControle);
                            physiqueControle.setHint("Physique controle");
                            applyStyle(physiqueControle);
                            francaisControle.setHint("Anglais controle");
                            applyStyle(francaisControle);
                            anglaisControle.setHint("Francais controle");
                            applyStyle(anglaisControle);


                            math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sciences.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            mathControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sciencesControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            physiqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                            sciences.setLayoutParams(params);
                            physique.setLayoutParams(params);
                            anglais.setLayoutParams(params);
                            math.setLayoutParams(params);
                            francais.setLayoutParams(params);
                            moyenne.setLayoutParams(params);

                            mathControle.setLayoutParams(params);
                            moyenneControle.setLayoutParams(params);
                            sciencesControle.setLayoutParams(params);
                            physiqueControle.setLayoutParams(params);
                            francaisControle.setLayoutParams(params);
                            anglaisControle.setLayoutParams(params);


                            linearLayout.addView(moyenne);
                            linearLayout.addView(math);
                            linearLayout.addView(physique);
                            linearLayout.addView(anglais);
                            linearLayout.addView(francais);
                            linearLayout.addView(sciences);

                            linearLayout.addView(mathControle);
                            linearLayout.addView(moyenneControle);
                            linearLayout.addView(sciencesControle);
                            linearLayout.addView(physiqueControle);
                            linearLayout.addView(francaisControle);
                            linearLayout.addView(anglaisControle);



                            Button btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);
                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty = math.getText().toString().isEmpty() || sciences.getText().toString().isEmpty()
                                            || francais.getText().toString().isEmpty() || anglais.getText().toString().isEmpty()
                                            || physique.getText().toString().isEmpty() || sciences.getText().toString().isEmpty()
                                            || mathControle.getText().toString().isEmpty() || sciencesControle.getText().toString().isEmpty()
                                            || francaisControle.getText().toString().isEmpty() || anglaisControle.getText().toString().isEmpty()
                                            || physiqueControle.getText().toString().isEmpty() || sciencesControle.getText().toString().isEmpty() ;;

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float mathNote = Float.parseFloat(String.valueOf(math.getText()));
                                        if (mathNote > 20 || mathNote < 0) {
                                            math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sciencesNote = Float.parseFloat(String.valueOf(sciences.getText()));
                                        if (sciencesNote > 20 || sciencesNote < 0) {
                                            sciences.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(physique.getText()));
                                        if (physiqueNote > 20 || physiqueNote < 0) {
                                            physique.setError("Tapez une note valide"   );
                                            allFieldsAreCorrect = false;
                                        }

                                        float moyenneNote = Float.parseFloat(String.valueOf(moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float mathNoteControle = Float.parseFloat(String.valueOf(mathControle.getText()));
                                        if (mathNoteControle > 20 || mathNoteControle < 0) {
                                            mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sciencesNoteControle = Float.parseFloat(String.valueOf(sciencesControle.getText()));
                                        if (sciencesNoteControle > 20 || sciencesNoteControle < 0) {
                                            sciencesControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle = Float.parseFloat(String.valueOf(physiqueControle.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNoteControle < 0) {
                                            physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float moyenneNoteControle = Float.parseFloat(String.valueOf(moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }



                                        scoreCalcul = (float) ((5 * moyenneNote + 2 * mathNote + 1.5 * physiqueNote + 0.5 * sciencesNote + (francaisNote + anglaisNote)*0.5*2)
                                                + (5 * moyenneNoteControle + 2 * mathNoteControle + 1.5 * physiqueNoteControle
                                                + 0.5 * sciencesNoteControle + (francaisNoteControle + anglaisNoteControle)))/3;
                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
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

                            final EditText L_arabeControle = new EditText(getApplicationContext());
                            final EditText L_moyenneControle = new EditText(getApplicationContext());
                            final EditText L_philoControle = new EditText(getApplicationContext());
                            final EditText L_his_geoControle = new EditText(getApplicationContext());
                            final EditText L_francaisControle = new EditText(getApplicationContext());
                            final EditText L_anglaisControle = new EditText(getApplicationContext());



                            L_arabe.setHint("Arabe");
                            applyStyle(L_arabe);
                            L_moyenne.setHint("Moyenne Generale");
                            applyStyle(L_moyenne);
                            L_philo.setHint("philosophie");
                            applyStyle(L_philo);
                            L_his_geo.setHint("Histoire et géographie");
                            applyStyle(L_his_geo);
                            L_anglais.setHint("Anglais");
                            applyStyle(L_anglais);
                            L_francais.setHint("Francais");
                            applyStyle(L_francais);


                            L_arabeControle.setHint("Arabe Controle");
                            applyStyle(L_arabeControle);
                            L_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(L_moyenneControle);
                            L_philoControle.setHint("philosophie Controle");
                            applyStyle(L_philoControle);
                            L_his_geoControle.setHint("Histoire et géographie Controle");
                            applyStyle(L_his_geoControle);
                            L_anglaisControle.setHint("Anglais Controle");
                            applyStyle(L_anglaisControle);
                            L_francaisControle.setHint("Francais Controle");
                            applyStyle(L_francaisControle);











                            L_arabe.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_philo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_his_geo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            L_arabeControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_philoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_his_geoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            L_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            L_moyenne.setLayoutParams(params);
                            L_arabe.setLayoutParams(params);
                            L_philo.setLayoutParams(params);
                            L_his_geo.setLayoutParams(params);
                            L_anglais.setLayoutParams(params);
                            L_francais.setLayoutParams(params);

                            L_moyenneControle.setLayoutParams(params);
                            L_arabeControle.setLayoutParams(params);
                            L_philoControle.setLayoutParams(params);
                            L_his_geoControle.setLayoutParams(params);
                            L_anglaisControle.setLayoutParams(params);
                            L_francaisControle.setLayoutParams(params);



                            linearLayout.addView(L_moyenne);
                            linearLayout.addView(L_arabe);
                            linearLayout.addView(L_philo);
                            linearLayout.addView(L_his_geo);
                            linearLayout.addView(L_anglais);
                            linearLayout.addView(L_francais);

                            linearLayout.addView(L_moyenneControle);
                            linearLayout.addView(L_arabeControle);
                            linearLayout.addView(L_philoControle);
                            linearLayout.addView(L_his_geoControle);
                            linearLayout.addView(L_anglaisControle);
                            linearLayout.addView(L_francaisControle);





                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");

                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);

                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            L_arabe.getText().toString().isEmpty() || L_moyenne.getText().toString().isEmpty()
                                                    || L_philo.getText().toString().isEmpty() || L_his_geo.getText().toString().isEmpty() ||
                                                    L_anglais.getText().toString().isEmpty() || L_francais.getText().toString().isEmpty() ||
                                                    L_arabeControle.getText().toString().isEmpty() || L_moyenneControle.getText().toString().isEmpty()
                                                    || L_philoControle.getText().toString().isEmpty() || L_his_geoControle.getText().toString().isEmpty() ||
                                                    L_anglaisControle.getText().toString().isEmpty() || L_francaisControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(L_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            L_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float arabeNote = Float.parseFloat(String.valueOf(L_arabe.getText()));
                                        if (arabeNote > 20 || arabeNote < 0) {
                                            L_arabe.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float philoNote = Float.parseFloat(String.valueOf(L_philo.getText()));
                                        if (philoNote> 20 || philoNote < 0) {
                                            L_philo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(L_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            L_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(L_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            L_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float his_geoNote = Float.parseFloat(String.valueOf(L_his_geo.getText()));
                                        if (his_geoNote > 20 || his_geoNote < 0) {
                                            L_his_geo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle= Float.parseFloat(String.valueOf(L_moyenneControle.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            L_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float arabeNoteControle = Float.parseFloat(String.valueOf(L_arabeControle.getText()));
                                        if (arabeNote > 20 || arabeNote < 0) {
                                            L_arabe.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float philoNoteControle = Float.parseFloat(String.valueOf(L_philoControle.getText()));
                                        if (philoNote> 20 || philoNote < 0) {
                                            L_philo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(L_francaisControle.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            L_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(L_anglaisControle.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            L_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float his_geoNoteControle = Float.parseFloat(String.valueOf(L_his_geoControle.getText()));
                                        if (his_geoNote > 20 || his_geoNote < 0) {
                                            L_his_geo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }



                                        scoreCalcul = (float) ((5*moyenneNote + 1.5*arabeNote + 1.5*philoNote + 1*his_geoNote + 0.5*francaisNote + 0.5*anglaisNote)*2+
                                                (5*moyenneNoteControle + 1.5*arabeNoteControle + 1.5*philoNoteControle + 1*his_geoNoteControle + 0.5*francaisNoteControle + 0.5*anglaisNoteControle))/3;
                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;

                        case 3 :
                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();

                            final EditText I_math = new EditText(getApplicationContext());
                            final EditText I_algo = new EditText(getApplicationContext());
                            final EditText I_moyenne = new EditText(getApplicationContext());
                            final EditText I_physique = new EditText(getApplicationContext());
                            final EditText I_TIC = new EditText(getApplicationContext());
                            final EditText I_BD = new EditText(getApplicationContext());
                            final EditText I_francais= new EditText(getApplicationContext());
                            final EditText I_anglais = new EditText(getApplicationContext());

                            final EditText I_mathControle = new EditText(getApplicationContext());
                            final EditText I_algoControle = new EditText(getApplicationContext());
                            final EditText I_moyenneControle = new EditText(getApplicationContext());
                            final EditText I_physiqueControle = new EditText(getApplicationContext());
                            final EditText I_TICControle = new EditText(getApplicationContext());
                            final EditText I_BDControle = new EditText(getApplicationContext());
                            final EditText I_francaisControle = new EditText(getApplicationContext());
                            final EditText I_anglaisControle = new EditText(getApplicationContext());

                            I_algo.setHint("Algorithm");
                            applyStyle(I_algo);
                            I_math.setHint("Math");
                            applyStyle(I_math);
                            I_physique.setHint("Physique");
                            applyStyle(I_physique);
                            I_moyenne.setHint("Moyenne Genrale");
                            applyStyle(I_moyenne);
                            I_BD.setHint("Base de données");
                            applyStyle(I_BD);
                            I_TIC.setHint("TIC");
                            applyStyle(I_TIC);
                            I_anglais.setHint("anglais");
                            applyStyle(I_anglais);
                            I_francais.setHint("francais");
                            applyStyle(I_francais);

                            I_algoControle.setHint("Algorithm Controle");
                            applyStyle(I_algoControle);
                            I_mathControle.setHint("Math Controle");
                            applyStyle(I_mathControle);
                            I_physiqueControle.setHint("Physique Controle");
                            applyStyle(I_physiqueControle);
                            I_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(I_moyenneControle);
                            I_BDControle.setHint("Base de données Controle");
                            applyStyle(I_BDControle);
                            I_TICControle.setHint("TIC Controle");
                            applyStyle(I_TICControle);
                            I_anglaisControle.setHint("anglais Controle");
                            applyStyle(I_anglaisControle);
                            I_francaisControle.setHint("francais Controle");
                            applyStyle(I_francaisControle);





                            I_algo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_BD.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_TIC.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            I_algoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_mathControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_physiqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_BDControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_TICControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            I_moyenne.setLayoutParams(params);
                            I_algo.setLayoutParams(params);
                            I_math.setLayoutParams(params);
                            I_physique.setLayoutParams(params);
                            I_BD.setLayoutParams(params);
                            I_TIC.setLayoutParams(params);
                            I_anglais.setLayoutParams(params);
                            I_francais.setLayoutParams(params);

                            I_moyenneControle.setLayoutParams(params);
                            I_algoControle.setLayoutParams(params);
                            I_mathControle.setLayoutParams(params);
                            I_physiqueControle.setLayoutParams(params);
                            I_BDControle.setLayoutParams(params);
                            I_TICControle.setLayoutParams(params);
                            I_anglaisControle.setLayoutParams(params);
                            I_francaisControle.setLayoutParams(params);



                            linearLayout.addView(I_moyenne);
                            linearLayout.addView(I_algo);
                            linearLayout.addView(I_math);
                            linearLayout.addView(I_physique);
                            linearLayout.addView(I_BD);
                            linearLayout.addView(I_TIC);
                            linearLayout.addView(I_anglais);
                            linearLayout.addView(I_francais);

                            linearLayout.addView(I_moyenneControle);
                            linearLayout.addView(I_algoControle);
                            linearLayout.addView(I_mathControle);
                            linearLayout.addView(I_physiqueControle);
                            linearLayout.addView(I_BDControle);
                            linearLayout.addView(I_TICControle);
                            linearLayout.addView(I_anglaisControle);
                            linearLayout.addView(I_francaisControle);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                                @Override
                                public void onClick(View view) {

                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            I_moyenne.getText().toString().isEmpty() || I_algo.getText().toString().isEmpty()
                                                    || I_math.getText().toString().isEmpty() || I_physique.getText().toString().isEmpty() ||
                                                    I_anglais.getText().toString().isEmpty() || I_francais.getText().toString().isEmpty()
                                                    || I_TIC.getText().toString().isEmpty() || I_BD.getText().toString().isEmpty() ||
                                                    I_moyenneControle.getText().toString().isEmpty() || I_algoControle.getText().toString().isEmpty()
                                                    || I_mathControle.getText().toString().isEmpty() || I_physiqueControle.getText().toString().isEmpty() ||
                                                    I_anglaisControle.getText().toString().isEmpty() || I_francaisControle.getText().toString().isEmpty()
                                                    || I_TICControle.getText().toString().isEmpty() || I_BDControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(I_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            I_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float algoNote = Float.parseFloat(String.valueOf(I_algo.getText()));
                                        if (algoNote > 20 || algoNote < 0) {
                                            I_algo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNote = Float.parseFloat(String.valueOf(I_math.getText()));
                                        if (mathNote> 20 || mathNote < 0) {
                                            I_math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(I_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            I_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(I_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            I_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(I_physique.getText()));
                                        if (physiqueNote > 20 || physiqueNote < 0) {
                                            I_physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float bdNote = Float.parseFloat(String.valueOf(I_BD.getText()));
                                        if (bdNote > 20 || bdNote < 0) {
                                            I_BD.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float ticNote = Float.parseFloat(String.valueOf(I_TIC.getText()));
                                        if (ticNote > 20 || ticNote < 0) {
                                            I_TIC.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle = Float.parseFloat(String.valueOf(I_moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            I_moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float algoNoteControle = Float.parseFloat(String.valueOf(I_algoControle.getText()));
                                        if (algoNoteControle > 20 || algoNoteControle < 0) {
                                            I_algoControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNoteControle = Float.parseFloat(String.valueOf(I_mathControle.getText()));
                                        if (mathNoteControle> 20 || mathNoteControle < 0) {
                                            I_mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(I_francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            I_francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(I_anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNote < 0) {
                                            I_anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle= Float.parseFloat(String.valueOf(I_physiqueControle.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNote < 0) {
                                            I_physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float bdNoteControle = Float.parseFloat(String.valueOf(I_BDControle.getText()));
                                        if (bdNoteControle > 20 || bdNoteControle < 0) {
                                            I_BDControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float ticNoteControle = Float.parseFloat(String.valueOf(I_TICControle.getText()));
                                        if (ticNoteControle > 20 || ticNoteControle < 0) {
                                            I_TICControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }





                                        scoreCalcul = (float) ((5*moyenneNote + 1.5*mathNote + 1.5*algoNote + 0.5*physiqueNote + 0.5*francaisNote + 0.5*anglaisNote + 0.25*(ticNote+bdNote))*2
                                                + (5*moyenneNoteControle + 1.5*mathNoteControle + 1.5*algoNoteControle + 0.5*physiqueNoteControle + 0.5*francaisNoteControle + 0.5*anglaisNoteControle + 0.25*(ticNoteControle+bdNoteControle)))/3;
                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;
                        case 4:

                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();

                            final EditText sc_math = new EditText(getApplicationContext());
                            final EditText sc_vieEtTerre = new EditText(getApplicationContext());
                            final EditText sc_moyenne = new EditText(getApplicationContext());
                            final EditText sc_physique = new EditText(getApplicationContext());
                            final EditText sc_francais= new EditText(getApplicationContext());
                            final EditText sc_anglais = new EditText(getApplicationContext());

                            final EditText sc_mathControle = new EditText(getApplicationContext());
                            final EditText sc_vieEtTerreControle = new EditText(getApplicationContext());
                            final EditText sc_moyenneControle = new EditText(getApplicationContext());
                            final EditText sc_physiqueControle = new EditText(getApplicationContext());
                            final EditText sc_francaisControle = new EditText(getApplicationContext());
                            final EditText sc_anglaisControle = new EditText(getApplicationContext());

                            sc_vieEtTerre.setHint("Science vie et terre");
                            applyStyle(sc_vieEtTerre);
                            sc_math.setHint("Math");
                            applyStyle(sc_math);
                            sc_physique.setHint("Physique");
                            applyStyle(sc_physique);
                            sc_moyenne.setHint("Moyenne Generale");
                            applyStyle(sc_moyenne);
                            sc_anglais.setHint("Anglais");
                            applyStyle(sc_anglais);
                            sc_francais.setHint("Francais");
                            applyStyle(sc_francais);


                            sc_vieEtTerreControle.setHint("Science vie et terre Controle");
                            applyStyle(sc_vieEtTerreControle);
                            sc_mathControle.setHint("Math Controle");
                            applyStyle(sc_mathControle);
                            sc_physiqueControle.setHint("Physique Controle");
                            applyStyle(sc_physiqueControle);
                            sc_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(sc_moyenneControle);
                            sc_anglaisControle.setHint("Anglais Controle");
                            applyStyle(sc_anglaisControle);
                            sc_francaisControle.setHint("Francais Controle");
                            applyStyle(sc_francaisControle);









                            sc_vieEtTerre.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            sc_vieEtTerreControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_mathControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_physiqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            sc_moyenne.setLayoutParams(params);
                            sc_vieEtTerre.setLayoutParams(params);
                            sc_math.setLayoutParams(params);
                            sc_physique.setLayoutParams(params);
                            sc_anglais.setLayoutParams(params);
                            sc_francais.setLayoutParams(params);

                            sc_moyenneControle.setLayoutParams(params);
                            sc_vieEtTerreControle.setLayoutParams(params);
                            sc_mathControle.setLayoutParams(params);
                            sc_physiqueControle.setLayoutParams(params);
                            sc_anglaisControle.setLayoutParams(params);
                            sc_francaisControle.setLayoutParams(params);


                            linearLayout.addView(sc_moyenne);
                            linearLayout.addView(sc_vieEtTerre);
                            linearLayout.addView(sc_math);
                            linearLayout.addView(sc_physique);
                            linearLayout.addView(sc_anglais);
                            linearLayout.addView(sc_francais);

                            linearLayout.addView(sc_moyenneControle);
                            linearLayout.addView(sc_vieEtTerreControle);
                            linearLayout.addView(sc_mathControle);
                            linearLayout.addView(sc_physiqueControle);
                            linearLayout.addView(sc_anglaisControle);
                            linearLayout.addView(sc_francaisControle);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            sc_moyenne.getText().toString().isEmpty() || sc_vieEtTerre.getText().toString().isEmpty()
                                                    || sc_math.getText().toString().isEmpty() || sc_physique.getText().toString().isEmpty() ||
                                                    sc_anglais.getText().toString().isEmpty() || sc_francais.getText().toString().isEmpty() ||
                                                    sc_moyenneControle.getText().toString().isEmpty() || sc_vieEtTerreControle.getText().toString().isEmpty()
                                                    || sc_mathControle.getText().toString().isEmpty() || sc_physiqueControle.getText().toString().isEmpty() ||
                                                    sc_anglaisControle.getText().toString().isEmpty() || sc_francaisControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(sc_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            sc_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float scVieTerreNote = Float.parseFloat(String.valueOf(sc_vieEtTerre.getText()));
                                        if (scVieTerreNote > 20 || scVieTerreNote < 0) {
                                            sc_vieEtTerre.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNote = Float.parseFloat(String.valueOf(sc_math.getText()));
                                        if (mathNote> 20 || mathNote < 0) {
                                            sc_math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(sc_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            sc_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(sc_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            sc_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(sc_physique.getText()));
                                        if (physiqueNote > 20 || physiqueNote < 0) {
                                            sc_physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle= Float.parseFloat(String.valueOf(sc_moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            sc_moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float scVieTerreNoteControle = Float.parseFloat(String.valueOf(sc_vieEtTerreControle.getText()));
                                        if (scVieTerreNoteControle > 20 || scVieTerreNote < 0) {
                                            sc_vieEtTerreControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNoteControle = Float.parseFloat(String.valueOf(sc_mathControle.getText()));
                                        if (mathNoteControle> 20 || mathNoteControle < 0) {
                                            sc_mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(sc_francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            sc_francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(sc_anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            sc_anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle= Float.parseFloat(String.valueOf(sc_physiqueControle.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNoteControle < 0) {
                                            sc_physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }


                                        scoreCalcul = (float) ((5*moyenneNote + 1*mathNote + 1.5*scVieTerreNote + 1.5*physiqueNote +0.5*francaisNote+0.5*anglaisNote)*2+
                                                (5*moyenneNote + 1*mathNote + 1.5*scVieTerreNote + 1.5*physiqueNote +0.5*francaisNote+0.5*anglaisNote))/3;
                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;

                        case 5:

                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();


                            final EditText T_math = new EditText(getApplicationContext());
                            final EditText T_technique = new EditText(getApplicationContext());
                            final EditText T_moyenne = new EditText(getApplicationContext());
                            final EditText T_physique = new EditText(getApplicationContext());
                            final EditText T_francais= new EditText(getApplicationContext());
                            final EditText T_anglais = new EditText(getApplicationContext());

                            final EditText T_mathControle = new EditText(getApplicationContext());
                            final EditText T_techniqueControle = new EditText(getApplicationContext());
                            final EditText T_moyenneControle = new EditText(getApplicationContext());
                            final EditText T_physiqueControle = new EditText(getApplicationContext());
                            final EditText T_francaisControle = new EditText(getApplicationContext());
                            final EditText T_anglaisControle = new EditText(getApplicationContext());

                            T_technique.setHint("Techniquee");
                            applyStyle(T_technique);
                            T_math.setHint("Math");
                            applyStyle(T_math);
                            T_physique.setHint("Physique");
                            applyStyle(T_physique);
                            T_moyenne.setHint("Moyenne Generale");
                            applyStyle(T_moyenne);
                            T_anglais.setHint("Anglais");
                            applyStyle(T_anglais);
                            T_francais.setHint("Francais");
                            applyStyle(T_francais);

                            T_techniqueControle.setHint("Technique Controle");
                            applyStyle(T_techniqueControle);
                            T_mathControle.setHint("Math Controle");
                            applyStyle(T_mathControle);
                            T_physiqueControle.setHint("Physique Controle");
                            applyStyle(T_physiqueControle);
                            T_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(T_moyenneControle);
                            T_anglaisControle.setHint("Anglais Controle");
                            applyStyle(T_anglaisControle);
                            T_francaisControle.setHint("Francais Controle");
                            applyStyle(T_francaisControle);









                            T_technique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            T_techniqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_mathControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_physiqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            T_moyenne.setLayoutParams(params);
                            T_technique.setLayoutParams(params);
                            T_math.setLayoutParams(params);
                            T_physique.setLayoutParams(params);
                            T_anglais.setLayoutParams(params);
                            T_francais.setLayoutParams(params);

                            T_moyenneControle.setLayoutParams(params);
                            T_techniqueControle.setLayoutParams(params);
                            T_mathControle.setLayoutParams(params);
                            T_physiqueControle.setLayoutParams(params);
                            T_anglaisControle.setLayoutParams(params);
                            T_francaisControle.setLayoutParams(params);



                            linearLayout.addView(T_moyenne);
                            linearLayout.addView(T_technique);
                            linearLayout.addView(T_math);
                            linearLayout.addView(T_physique);
                            linearLayout.addView(T_anglais);
                            linearLayout.addView(T_francais);

                            linearLayout.addView(T_moyenneControle);
                            linearLayout.addView(T_techniqueControle);
                            linearLayout.addView(T_mathControle);
                            linearLayout.addView(T_physiqueControle);
                            linearLayout.addView(T_anglaisControle);
                            linearLayout.addView(T_francaisControle);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            T_moyenne.getText().toString().isEmpty() || T_technique.getText().toString().isEmpty()
                                                    || T_math.getText().toString().isEmpty() || T_physique.getText().toString().isEmpty() ||
                                                    T_anglais.getText().toString().isEmpty() || T_francais.getText().toString().isEmpty()||
                                                    T_moyenneControle.getText().toString().isEmpty() || T_techniqueControle.getText().toString().isEmpty()
                                                    || T_mathControle.getText().toString().isEmpty() || T_physiqueControle.getText().toString().isEmpty() ||
                                                    T_anglaisControle.getText().toString().isEmpty() || T_francaisControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(T_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            T_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float techniqueNote = Float.parseFloat(String.valueOf(T_technique.getText()));
                                        if (techniqueNote > 20 || techniqueNote < 0) {
                                            T_technique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNote = Float.parseFloat(String.valueOf(T_math.getText()));
                                        if (mathNote> 20 || mathNote < 0) {
                                            T_math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(T_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            T_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(T_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            T_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(T_physique.getText()));
                                        if (physiqueNote > 20 || physiqueNote < 0) {
                                            T_physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle= Float.parseFloat(String.valueOf(T_moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            T_moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float techniqueNoteControle = Float.parseFloat(String.valueOf(T_techniqueControle.getText()));
                                        if (techniqueNoteControle > 20 || techniqueNoteControle < 0) {
                                            T_techniqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNoteControle = Float.parseFloat(String.valueOf(T_mathControle.getText()));
                                        if (mathNoteControle> 20 || mathNoteControle < 0) {
                                            T_mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(T_francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            T_francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(T_anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            T_anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle = Float.parseFloat(String.valueOf(T_physiqueControle.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNoteControle < 0) {
                                            T_physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }


                                        scoreCalcul = (float) ((5*moyenneNote + 1.5*mathNote + 1.5*techniqueNote + 1*physiqueNote + 0.5*francaisNote  + 0.5*anglaisNote)*2+
                                                (5*moyenneNoteControle + 1.5*mathNoteControle + 1.5*techniqueNoteControle + 1*physiqueNoteControle + 0.5*francaisNoteControle  + 0.5*anglaisNoteControle))/3;


                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;

                        case 6:

                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();


                            final EditText S_vieEtTerre = new EditText(getApplicationContext());
                            final EditText S_spTh = new EditText(getApplicationContext());
                            final EditText S_moyenne = new EditText(getApplicationContext());
                            final EditText S_spPr = new EditText(getApplicationContext());
                            final EditText S_francais= new EditText(getApplicationContext());
                            final EditText S_anglais = new EditText(getApplicationContext());
                            final EditText S_sport = new EditText(getApplicationContext());
                            final EditText S_physique = new EditText(getApplicationContext());
                            final EditText S_philo = new EditText(getApplicationContext());

                            final EditText S_vieEtTerreControle = new EditText(getApplicationContext());
                            final EditText S_spThControle = new EditText(getApplicationContext());
                            final EditText S_moyenneControle = new EditText(getApplicationContext());
                            final EditText S_spPrControle = new EditText(getApplicationContext());
                            final EditText S_francaisControle = new EditText(getApplicationContext());
                            final EditText S_anglaisControle = new EditText(getApplicationContext());
                            final EditText S_sportControle = new EditText(getApplicationContext());
                            final EditText S_physiqueControle = new EditText(getApplicationContext());
                            final EditText S_philoControle = new EditText(getApplicationContext());

                            S_vieEtTerre.setHint("science vie et terre");
                            applyStyle(S_vieEtTerre);
                            S_spTh.setHint("Sp.Th");
                            applyStyle(S_spTh);
                            S_spPr.setHint("Sp.Pr");
                            applyStyle(S_spPr);
                            S_moyenne.setHint("Moyenne Generale");
                            applyStyle(S_moyenne);
                            S_anglais.setHint("Anglais");
                            applyStyle(S_anglais);
                            S_francais.setHint("Francais");
                            applyStyle(S_francais);
                            S_sport.setHint("Sport");
                            applyStyle(S_sport);
                            S_physique.setHint("Physique");
                            applyStyle(S_physique);
                            S_philo.setHint("Philo");
                            applyStyle(S_philo);


                            S_vieEtTerreControle.setHint("science vie et terre Controle");
                            applyStyle(S_vieEtTerreControle);
                            S_spThControle.setHint("Sp.Th Controle");
                            applyStyle(S_spThControle);
                            S_spPrControle.setHint("Sp.Pr Controle");
                            applyStyle(S_spPrControle);
                            S_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(S_moyenneControle);
                            S_anglaisControle.setHint("Anglais Controle");
                            applyStyle(S_anglaisControle);
                            S_francaisControle.setHint("Francais Controle");
                            applyStyle(S_francaisControle);
                            S_sportControle.setHint("Sport Controle");
                            applyStyle(S_sportControle);
                            S_physiqueControle.setHint("Physique Controle");
                            applyStyle(S_physiqueControle);
                            S_philoControle.setHint("Philo Controle");
                            applyStyle(S_philoControle);




                            S_vieEtTerre.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spTh.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spPr.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_sport.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_philo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                            S_vieEtTerreControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spThControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spPrControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_sportControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_physiqueControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_philoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                            S_moyenne.setLayoutParams(params);
                            S_vieEtTerre.setLayoutParams(params);
                            S_spTh.setLayoutParams(params);
                            S_spPr.setLayoutParams(params);
                            S_anglais.setLayoutParams(params);
                            S_francais.setLayoutParams(params);
                            S_sport.setLayoutParams(params);
                            S_physique.setLayoutParams(params);
                            S_philo.setLayoutParams(params);


                            S_moyenneControle.setLayoutParams(params);
                            S_vieEtTerreControle.setLayoutParams(params);
                            S_spThControle.setLayoutParams(params);
                            S_spPrControle.setLayoutParams(params);
                            S_anglaisControle.setLayoutParams(params);
                            S_francaisControle.setLayoutParams(params);
                            S_sportControle.setLayoutParams(params);
                            S_physiqueControle.setLayoutParams(params);
                            S_philoControle.setLayoutParams(params);



                            linearLayout.addView(S_moyenne);
                            linearLayout.addView(S_vieEtTerre);
                            linearLayout.addView(S_spTh);
                            linearLayout.addView(S_spPr);
                            linearLayout.addView(S_anglais);
                            linearLayout.addView(S_francais);
                            linearLayout.addView(S_sport);
                            linearLayout.addView(S_physique);
                            linearLayout.addView(S_philo);

                            linearLayout.addView(S_moyenneControle);
                            linearLayout.addView(S_vieEtTerreControle);
                            linearLayout.addView(S_spThControle);
                            linearLayout.addView(S_spPrControle);
                            linearLayout.addView(S_anglaisControle);
                            linearLayout.addView(S_francaisControle);
                            linearLayout.addView(S_sportControle);
                            linearLayout.addView(S_physiqueControle);
                            linearLayout.addView(S_philoControle);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            S_moyenne.getText().toString().isEmpty() || S_vieEtTerre.getText().toString().isEmpty()
                                                    || S_spTh.getText().toString().isEmpty() || S_spPr.getText().toString().isEmpty() ||
                                                    S_anglais.getText().toString().isEmpty() || S_francais.getText().toString().isEmpty()
                                                    || S_sport.getText().toString().isEmpty() || S_physique.getText().toString().isEmpty()
                                                    || S_philo.getText().toString().isEmpty()||
                                                    S_moyenneControle.getText().toString().isEmpty() || S_vieEtTerreControle.getText().toString().isEmpty()
                                                    || S_spThControle.getText().toString().isEmpty() || S_spPrControle.getText().toString().isEmpty() ||
                                                    S_anglaisControle.getText().toString().isEmpty() || S_francaisControle.getText().toString().isEmpty()
                                                    || S_sportControle.getText().toString().isEmpty() || S_physiqueControle.getText().toString().isEmpty()
                                                    || S_philoControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(S_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            S_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float svtNote = Float.parseFloat(String.valueOf(S_vieEtTerre.getText()));
                                        if (svtNote > 20 || svtNote < 0) {
                                            S_vieEtTerre.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float spThNote = Float.parseFloat(String.valueOf(S_spTh.getText()));
                                        if (spThNote> 20 || spThNote < 0) {
                                            S_spTh.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(S_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            S_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(S_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            S_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNote = Float.parseFloat(String.valueOf(S_physique.getText()));
                                        if (physiqueNote > 20 || physiqueNote < 0) {
                                            S_physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float spPrNote = Float.parseFloat(String.valueOf(S_spPr.getText()));
                                        if (spPrNote > 20 || spPrNote < 0) {
                                            S_spPr.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sportNote = Float.parseFloat(String.valueOf(S_sport.getText()));
                                        if (sportNote > 20 || sportNote < 0) {
                                            S_sport.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float philoNote = Float.parseFloat(String.valueOf(S_philo.getText()));
                                        if (philoNote > 20 || philoNote < 0) {
                                            S_philo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle = Float.parseFloat(String.valueOf(S_moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            S_moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float svtNoteControle = Float.parseFloat(String.valueOf(S_vieEtTerreControle.getText()));
                                        if (svtNoteControle > 20 || svtNoteControle < 0) {
                                            S_vieEtTerreControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float spThNoteControle= Float.parseFloat(String.valueOf(S_spThControle.getText()));
                                        if (spThNoteControle> 20 || spThNoteControle < 0) {
                                            S_spThControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(S_francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            S_francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(S_anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            S_anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle = Float.parseFloat(String.valueOf(S_physiqueControle.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNoteControle < 0) {
                                            S_physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float spPrNoteControle = Float.parseFloat(String.valueOf(S_spPrControle.getText()));
                                        if (spPrNoteControle > 20 || spPrNoteControle < 0) {
                                            S_spPrControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sportNoteControle = Float.parseFloat(String.valueOf(S_sportControle.getText()));
                                        if (sportNoteControle > 20 || sportNoteControle < 0) {
                                            S_sportControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float philoNoteControle = Float.parseFloat(String.valueOf(S_philoControle.getText()));
                                        if (philoNoteControle > 20 || philoNote < 0) {
                                            S_philoControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }


                                        scoreCalcul = (float) ((5*moyenneNote + 1*svtNote + 0.5*(spThNote+spPrNote) + 1*sportNote +0.5*physiqueNote + 0.25*(francaisNote+anglaisNote)+ 1*philoNote)*2+
                                                (5*moyenneNote + 1*svtNote + 0.5*(spThNote+spPrNote) + 1*sportNote +0.5*physiqueNote + 0.25*(francaisNote+anglaisNote)+ 1*philoNote))/3;
                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;

                        case 7:

                            if (linearLayout.getChildCount() > 0)
                                linearLayout.removeAllViews();


                            final EditText E_eco = new EditText(getApplicationContext());
                            final EditText E_gestion= new EditText(getApplicationContext());
                            final EditText E_moyenne = new EditText(getApplicationContext());
                            final EditText E_hisGeo = new EditText(getApplicationContext());
                            final EditText E_francais= new EditText(getApplicationContext());
                            final EditText E_anglais = new EditText(getApplicationContext());
                            final EditText E_math = new EditText(getApplicationContext());

                            final EditText E_ecoControle = new EditText(getApplicationContext());
                            final EditText E_gestionControle= new EditText(getApplicationContext());
                            final EditText E_moyenneControle = new EditText(getApplicationContext());
                            final EditText E_hisGeoControle = new EditText(getApplicationContext());
                            final EditText E_francaisControle = new EditText(getApplicationContext());
                            final EditText E_anglaisControle = new EditText(getApplicationContext());
                            final EditText E_mathControle = new EditText(getApplicationContext());

                            E_eco.setHint("Economie");
                            applyStyle(E_eco);
                            E_gestion.setHint("Gestion");
                            applyStyle(E_gestion);
                            E_hisGeo.setHint("hisoire et Geo");
                            applyStyle(E_hisGeo);
                            E_moyenne.setHint("Moyenne Generale");
                            applyStyle(E_moyenne);
                            E_anglais.setHint("Anglais");
                            applyStyle(E_anglais);
                            E_francais.setHint("Francais");
                            applyStyle(E_francais);
                            E_math.setHint("Math");
                            applyStyle(E_math);


                            E_ecoControle.setHint("Economie Controle");
                            applyStyle(E_ecoControle);
                            E_gestionControle.setHint("Gestion Controle");
                            applyStyle(E_gestionControle);
                            E_hisGeoControle.setHint("hisoire et Geo Controle");
                            applyStyle(E_hisGeoControle);
                            E_moyenneControle.setHint("Moyenne Controle");
                            applyStyle(E_moyenneControle);
                            E_anglaisControle.setHint("Anglais Controle");
                            applyStyle(E_anglaisControle);
                            E_francaisControle.setHint("Francais Controle");
                            applyStyle(E_francaisControle);
                            E_mathControle.setHint("Math Controle");
                            applyStyle(E_mathControle);



                            E_eco.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_gestion.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_hisGeo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                            E_ecoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_gestionControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_hisGeoControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_moyenneControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_anglaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_francaisControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_mathControle.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            E_moyenne.setLayoutParams(params);
                            E_eco.setLayoutParams(params);
                            E_gestion.setLayoutParams(params);
                            E_hisGeo.setLayoutParams(params);
                            E_anglais.setLayoutParams(params);
                            E_francais.setLayoutParams(params);
                            E_math.setLayoutParams(params);

                            E_moyenneControle.setLayoutParams(params);
                            E_ecoControle.setLayoutParams(params);
                            E_gestionControle.setLayoutParams(params);
                            E_hisGeoControle.setLayoutParams(params);
                            E_anglaisControle.setLayoutParams(params);
                            E_francaisControle.setLayoutParams(params);
                            E_mathControle.setLayoutParams(params);



                            linearLayout.addView(E_moyenne);
                            linearLayout.addView(E_eco);
                            linearLayout.addView(E_gestion);
                            linearLayout.addView(E_hisGeo);
                            linearLayout.addView(E_anglais);
                            linearLayout.addView(E_francais);
                            linearLayout.addView(E_math);

                            linearLayout.addView(E_moyenneControle);
                            linearLayout.addView(E_ecoControle);
                            linearLayout.addView(E_gestionControle);
                            linearLayout.addView(E_hisGeoControle);
                            linearLayout.addView(E_anglaisControle);
                            linearLayout.addView(E_francaisControle);
                            linearLayout.addView(E_mathControle);


                            btnTest = new Button(getApplicationContext());
                            btnTest.setText("Recuperer");
                            btnTest.setBackgroundResource(R.drawable.button_styles_grad);
                            btnTest.setLayoutParams(params);
                            linearLayout.addView(btnTest);


                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            E_moyenne.getText().toString().isEmpty() || E_eco.getText().toString().isEmpty()
                                                    || E_gestion.getText().toString().isEmpty() || E_anglais.getText().toString().isEmpty() ||
                                                    E_francais.getText().toString().isEmpty() || E_math.getText().toString().isEmpty()
                                                    || E_hisGeo.getText().toString().isEmpty() ||
                                                    E_moyenneControle.getText().toString().isEmpty() || E_ecoControle.getText().toString().isEmpty()
                                                    || E_gestionControle.getText().toString().isEmpty() || E_anglaisControle.getText().toString().isEmpty() ||
                                                    E_francaisControle.getText().toString().isEmpty() || E_mathControle.getText().toString().isEmpty()
                                                    || E_hisGeoControle.getText().toString().isEmpty();

                                    boolean allFieldsAreCorrect = true ;
                                    if (!fieldsEmpty) {

                                        float moyenneNote = Float.parseFloat(String.valueOf(E_moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            E_moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float ecoNote = Float.parseFloat(String.valueOf(E_eco.getText()));
                                        if (ecoNote > 20 || ecoNote < 0) {
                                            E_eco.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float gestionNote = Float.parseFloat(String.valueOf(E_gestion.getText()));
                                        if (gestionNote> 20 || gestionNote < 0) {
                                            E_gestion.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNote = Float.parseFloat(String.valueOf(E_francais.getText()));
                                        if (francaisNote > 20 || francaisNote < 0) {
                                            E_francais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNote = Float.parseFloat(String.valueOf(E_anglais.getText()));
                                        if (anglaisNote > 20 || anglaisNote < 0) {
                                            E_anglais.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNote = Float.parseFloat(String.valueOf(E_math.getText()));
                                        if (mathNote > 20 || mathNote < 0) {
                                            E_math.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float hisgeoNote = Float.parseFloat(String.valueOf(E_hisGeo.getText()));
                                        if (hisgeoNote > 20 || hisgeoNote < 0) {
                                            E_hisGeo.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float moyenneNoteControle = Float.parseFloat(String.valueOf(E_moyenneControle.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            E_moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float ecoNoteControle = Float.parseFloat(String.valueOf(E_ecoControle.getText()));
                                        if (ecoNoteControle > 20 || ecoNoteControle < 0) {
                                            E_ecoControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float gestionNoteControle = Float.parseFloat(String.valueOf(E_gestionControle.getText()));
                                        if (gestionNoteControle > 20 || gestionNoteControle < 0) {
                                            E_gestionControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(E_francaisControle.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            E_francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle= Float.parseFloat(String.valueOf(E_anglaisControle.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            E_anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float mathNoteControle= Float.parseFloat(String.valueOf(E_mathControle.getText()));
                                        if (mathNoteControle > 20 || mathNoteControle < 0) {
                                            E_mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float hisgeoNoteControle = Float.parseFloat(String.valueOf(E_hisGeoControle.getText()));
                                        if (hisgeoNoteControle > 20 || hisgeoNoteControle < 0) {
                                            E_hisGeoControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        scoreCalcul = (float) ((5*moyenneNote + 1.5*ecoNote + 1.5*gestionNote + 0.5*mathNote + 0.5*hisgeoNote +0.5*francaisNote+0.5*anglaisNote)*2 +
                                                (5*moyenneNote + 1.5*ecoNote + 1.5*gestionNote + 0.5*mathNote + 0.5*hisgeoNote +0.5*francaisNote+0.5*anglaisNote))/3;

                                    }
                                    if (allFieldsAreCorrect && !fieldsEmpty) {

                                        Toast.makeText(getApplicationContext(), "Votre score est : " + scoreCalcul, Toast.LENGTH_LONG).show();
                                        confirmScore(scoreCalcul);
                                    }
                                    else
                                    if (fieldsEmpty)
                                        Toast.makeText(getApplicationContext(),"Veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                                    else
                                        Toast.makeText(getApplicationContext(),"Veillez verifier les champs erronées ",Toast.LENGTH_LONG).show();
                                }

                            });
                            break;






                    }
                }
            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private void confirmScore(float score) {

        AlertDialog.Builder builder = new AlertDialog.Builder(CalculScoreControle.this);
        builder.setMessage("Votre score est : "+score+"\nSauvegarder ? ")
                .setTitle("Confirmation de Score")
                .setPositiveButton("Confimer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(CalculScoreControle.this,"Confirmé",Toast.LENGTH_LONG).show();
                            }
                        }
                )
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CalculScoreControle.this,"Annulé",Toast.LENGTH_LONG).show();
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
