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
    String Bac[]= {"Section Bac : ","Mathematiques","Lettres","Informatique","Sciences", "Technique","Sport", "Economie gestion"};

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
                                            physique.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float moyenneNote = Float.parseFloat(String.valueOf(moyenne.getText()));
                                        if (moyenneNote > 20 || moyenneNote < 0) {
                                            moyenne.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }
                                        float mathNoteControle = Float.parseFloat(String.valueOf(math.getText()));
                                        if (mathNoteControle > 20 || mathNoteControle < 0) {
                                            mathControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float sciencesNoteControle = Float.parseFloat(String.valueOf(sciences.getText()));
                                        if (sciencesNoteControle > 20 || sciencesNoteControle < 0) {
                                            sciencesControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float anglaisNoteControle = Float.parseFloat(String.valueOf(anglais.getText()));
                                        if (anglaisNoteControle > 20 || anglaisNoteControle < 0) {
                                            anglaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float francaisNoteControle = Float.parseFloat(String.valueOf(francais.getText()));
                                        if (francaisNoteControle > 20 || francaisNoteControle < 0) {
                                            francaisControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float physiqueNoteControle = Float.parseFloat(String.valueOf(physique.getText()));
                                        if (physiqueNoteControle > 20 || physiqueNoteControle < 0) {
                                            physiqueControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }

                                        float moyenneNoteControle = Float.parseFloat(String.valueOf(moyenne.getText()));
                                        if (moyenneNoteControle > 20 || moyenneNoteControle < 0) {
                                            moyenneControle.setError("Tapez une note valide");
                                            allFieldsAreCorrect = false;
                                        }



                                        scoreCalcul = (float) ((5 * moyenneNote + 2 * mathNote + 1.5 * physiqueNote + 0.5 * sciencesNote + (francaisNote + anglaisNote)*2)
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

                            btnTest.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    float scoreCalcul= 0;
                                    boolean fieldsEmpty =
                                            L_arabe.getText().toString().isEmpty() || L_moyenne.getText().toString().isEmpty()
                                                    || L_philo.getText().toString().isEmpty() || L_his_geo.getText().toString().isEmpty() ||
                                                    L_anglais.getText().toString().isEmpty() || L_francais.getText().toString().isEmpty() ;

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



                                        scoreCalcul = (float) (5*moyenneNote + 1.5*arabeNote + 1.5*philoNote + 1*his_geoNote + 0.5*francaisNote + 0.5*anglaisNote);
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

                            I_algo.setHint("Algorithm");
                            I_math.setHint("Math");
                            I_physique.setHint("Physique");
                            I_moyenne.setHint("Moyenne");
                            I_BD.setHint("Base de données");
                            I_TIC.setHint("TIC");
                            I_anglais.setHint("anglais");
                            I_francais.setHint("francais");

                            applyStyle(I_algo);
                            applyStyle(I_math);
                            applyStyle(I_physique);
                            applyStyle(I_moyenne);
                            applyStyle(I_BD);
                            applyStyle(I_TIC);
                            applyStyle(I_anglais);
                            applyStyle(I_francais);


                            I_algo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_BD.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_TIC.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            I_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            I_moyenne.setLayoutParams(params);
                            I_algo.setLayoutParams(params);
                            I_math.setLayoutParams(params);
                            I_physique.setLayoutParams(params);
                            I_BD.setLayoutParams(params);
                            I_TIC.setLayoutParams(params);
                            I_anglais.setLayoutParams(params);
                            I_francais.setLayoutParams(params);



                            linearLayout.addView(I_moyenne);
                            linearLayout.addView(I_algo);
                            linearLayout.addView(I_math);
                            linearLayout.addView(I_physique);
                            linearLayout.addView(I_BD);
                            linearLayout.addView(I_TIC);
                            linearLayout.addView(I_anglais);
                            linearLayout.addView(I_francais);


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
                                                    || I_TIC.getText().toString().isEmpty() || I_BD.getText().toString().isEmpty();

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





                                        scoreCalcul = (float) (5*moyenneNote + 1.5*mathNote + 1.5*algoNote + 0.5*physiqueNote + 0.5*francaisNote + 0.5*anglaisNote + 0.25*(ticNote+bdNote));
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

                            sc_vieEtTerre.setHint("Science vie et terre");
                            sc_math.setHint("Math");
                            sc_physique.setHint("Physique");
                            sc_moyenne.setHint("Moyenne");
                            sc_anglais.setHint("Anglais");
                            sc_francais.setHint("Francais");

                            applyStyle(sc_vieEtTerre);
                            applyStyle(sc_math);
                            applyStyle(sc_physique);
                            applyStyle(sc_moyenne);
                            applyStyle(sc_anglais);
                            applyStyle(sc_francais);


                            sc_vieEtTerre.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            sc_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            sc_moyenne.setLayoutParams(params);
                            sc_vieEtTerre.setLayoutParams(params);
                            sc_math.setLayoutParams(params);
                            sc_physique.setLayoutParams(params);
                            sc_anglais.setLayoutParams(params);
                            sc_francais.setLayoutParams(params);


                            linearLayout.addView(sc_moyenne);
                            linearLayout.addView(sc_vieEtTerre);
                            linearLayout.addView(sc_math);
                            linearLayout.addView(sc_physique);
                            linearLayout.addView(sc_anglais);
                            linearLayout.addView(sc_francais);


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
                                                    sc_anglais.getText().toString().isEmpty() || sc_francais.getText().toString().isEmpty();

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


                                        scoreCalcul = (float) (5*moyenneNote + 1*mathNote + 1.5*scVieTerreNote + 1.5*physiqueNote +0.5*francaisNote+0.5*anglaisNote);
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

                            T_technique.setHint("Techniquee");
                            T_math.setHint("Math");
                            T_physique.setHint("Physique");
                            T_moyenne.setHint("Moyenne");
                            T_anglais.setHint("Anglais");
                            T_francais.setHint("Francais");

                            applyStyle(T_technique);
                            applyStyle(T_math);
                            applyStyle(T_physique);
                            applyStyle(T_moyenne);
                            applyStyle(T_anglais);
                            applyStyle(T_francais);


                            T_technique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            T_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            T_moyenne.setLayoutParams(params);
                            T_technique.setLayoutParams(params);
                            T_math.setLayoutParams(params);
                            T_physique.setLayoutParams(params);
                            T_anglais.setLayoutParams(params);
                            T_francais.setLayoutParams(params);



                            linearLayout.addView(T_moyenne);
                            linearLayout.addView(T_technique);
                            linearLayout.addView(T_math);
                            linearLayout.addView(T_physique);
                            linearLayout.addView(T_anglais);
                            linearLayout.addView(T_francais);


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
                                                    T_anglais.getText().toString().isEmpty() || T_francais.getText().toString().isEmpty();

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


                                        scoreCalcul = (float) (5*moyenneNote + 1.5*mathNote + 1.5*techniqueNote + 1*physiqueNote + 0.5*francaisNote  + 0.5*anglaisNote);


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

                            S_vieEtTerre.setHint("science vie et terre");
                            S_spTh.setHint("Sp.Th");
                            S_spPr.setHint("Sp.Pr");
                            S_moyenne.setHint("Moyenne");
                            S_anglais.setHint("Anglais");
                            S_francais.setHint("Francais");
                            S_sport.setHint("Sport");
                            S_physique.setHint("Physique");
                            S_philo.setHint("Philo");

                            applyStyle(S_vieEtTerre);
                            applyStyle(S_spTh);
                            applyStyle(S_spPr);
                            applyStyle(S_moyenne);
                            applyStyle(S_anglais);
                            applyStyle(S_francais);
                            applyStyle(S_sport);
                            applyStyle(S_physique);
                            applyStyle(S_philo);



                            S_vieEtTerre.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spTh.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_spPr.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_sport.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_physique.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            S_philo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                            S_moyenne.setLayoutParams(params);
                            S_vieEtTerre.setLayoutParams(params);
                            S_spTh.setLayoutParams(params);
                            S_spPr.setLayoutParams(params);
                            S_anglais.setLayoutParams(params);
                            S_francais.setLayoutParams(params);
                            S_sport.setLayoutParams(params);
                            S_physique.setLayoutParams(params);
                            S_philo.setLayoutParams(params);



                            linearLayout.addView(S_moyenne);
                            linearLayout.addView(S_vieEtTerre);
                            linearLayout.addView(S_spTh);
                            linearLayout.addView(S_spPr);
                            linearLayout.addView(S_anglais);
                            linearLayout.addView(S_francais);
                            linearLayout.addView(S_sport);
                            linearLayout.addView(S_physique);
                            linearLayout.addView(S_philo);


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
                                                    || S_philo.getText().toString().isEmpty();

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


                                        scoreCalcul = (float) (5*moyenneNote + 1*svtNote + 0.5*(spThNote+spPrNote) + 1*sportNote +0.5*physiqueNote + 0.25*(francaisNote+anglaisNote)+ 1*philoNote);
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

                            E_eco.setHint("Economie");
                            E_gestion.setHint("Gestion");
                            E_hisGeo.setHint("hisoire et Geo");
                            E_moyenne.setHint("Moyenne");
                            E_anglais.setHint("Anglais");
                            E_francais.setHint("Francais");
                            E_math.setHint("Math");

                            applyStyle(E_eco);
                            applyStyle(E_gestion);
                            applyStyle(E_hisGeo);
                            applyStyle(E_moyenne);
                            applyStyle(E_anglais);
                            applyStyle(E_francais);
                            applyStyle(E_math);



                            E_eco.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_gestion.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_hisGeo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_moyenne.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_anglais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_francais.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            E_math.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);



                            E_moyenne.setLayoutParams(params);
                            E_eco.setLayoutParams(params);
                            E_gestion.setLayoutParams(params);
                            E_hisGeo.setLayoutParams(params);
                            E_anglais.setLayoutParams(params);
                            E_francais.setLayoutParams(params);
                            E_math.setLayoutParams(params);



                            linearLayout.addView(E_moyenne);
                            linearLayout.addView(E_eco);
                            linearLayout.addView(E_gestion);
                            linearLayout.addView(E_hisGeo);
                            linearLayout.addView(E_anglais);
                            linearLayout.addView(E_francais);
                            linearLayout.addView(E_math);


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
                                                    || E_hisGeo.getText().toString().isEmpty();

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

                                        scoreCalcul = (float) (5*moyenneNote + 1.5*ecoNote + 1.5*gestionNote + 0.5*mathNote + 0.5*hisgeoNote +0.5*francaisNote+0.5*anglaisNote);

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
