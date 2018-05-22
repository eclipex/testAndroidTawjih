package com.example.silver.designtest.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.designtest.Activités.DiplomeSelected;
import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.FavorisPOJO;
import com.example.silver.designtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavorisAdapter extends BaseAdapter {

    private List<FavorisPOJO> listeFavoris;
    private Context context;

    public FavorisAdapter(List<FavorisPOJO> listeFavoris, Context context )
    {
        this.context = context;
        this.listeFavoris = listeFavoris;
    }
    @Override
    public int getCount() {

        if (listeFavoris != null)
            return listeFavoris.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int i) {
        if (listeFavoris != null)
            return listeFavoris.get(i);
        else
            return 0;
    }

    @Override
    public long getItemId(int i) {
        if (listeFavoris != null)
            return listeFavoris.get(i).getId();
        else
            return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.favoris_layout,null);
        TextView filiere =  view.findViewById(R.id.filiere1);
        TextView num = view.findViewById(R.id.number);
        TextView etablissement =  view.findViewById(R.id.etab1);
        TextView section =  view.findViewById(R.id.section1);
        TextView score =  view.findViewById(R.id.scor);
        Button consulter = view.findViewById(R.id.consult1);
        Button supprimer = view.findViewById(R.id.delete1);

        if (listeFavoris== null)
            return view;
        else{
            final FavorisPOJO favoris = listeFavoris.get(i);
            num.setText(""+(1+i));
            filiere.setText(favoris.getFiliere());
            etablissement.setText(favoris.getEtablissement());
            section.setText(favoris.getSection());
            score.setText(" "+favoris.getScore());
            consulter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentDiplome = new Intent(context,DiplomeSelected.class);
                    intentDiplome.putExtra("diplomeCode",favoris.getCode());
                    context.startActivity(intentDiplome);
                }
            });
            supprimer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                    builder.setMessage("Vous etes sur de vouloir supprimer ce diplome de la liste de favoris ? ")
                            .setTitle("Confirmation de Suppression")
                            .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                            Toast.makeText(context,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

                                            ApiInterface apiInterface2= ApiClient.getApiClient().create(ApiInterface.class);
                                            Call<FavorisPOJO> favorisPOJOCall = apiInterface2.deleteFavoris(favoris.getId());
                                            favorisPOJOCall.enqueue(new Callback<FavorisPOJO>() {
                                                @Override
                                                public void onResponse(Call<FavorisPOJO> call, Response<FavorisPOJO> response) {

                                                }
                                                @Override
                                                public void onFailure(Call<FavorisPOJO> call, Throwable t) {}
                                            });
                                        }
                                    }
                            )
                            .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Toast.makeText(context,"Favoris Mis a jour",Toast.LENGTH_LONG).show();

                                }
                            });

                    final AlertDialog dialog = builder.create();
                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onShow(DialogInterface dialogInterface) {

                            dialog.setCancelable(true);
                            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
                            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(R.color.colorPrimaryDark);
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(R.color.colorPrimaryDark);

                        }
                    });
                    dialog.show();
                }
            });
            return view;
        }

    }


    private void delFav(final Integer idfav ) {




    }
}
