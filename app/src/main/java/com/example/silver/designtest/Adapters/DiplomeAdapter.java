package com.example.silver.designtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.R;

import java.util.List;

public class DiplomeAdapter extends BaseAdapter {


    private List<DiplomePOJO> etablissementPOJOS;
    private Context context;
    private DiplomePOJO etablissementPOJO;


    //Pour afficher toute la liste  des domaines
    public DiplomeAdapter(List<DiplomePOJO> etablissementPOJOS, Context context )
    {
        this.context = context;
        this.etablissementPOJOS = etablissementPOJOS;
        this.etablissementPOJO = null;
    }

    //Pour afficher un seul element
    public DiplomeAdapter(DiplomePOJO etablissementPOJO, Context context )
    {
        this.context = context;
        this.etablissementPOJO = etablissementPOJO;
        this.etablissementPOJOS = null;
    }
    @Override
    public int getCount()
    {

        if (etablissementPOJO != null)
            return 1;
        else
            return etablissementPOJOS.size();
    }

    @Override
    public Object getItem(int i)
    {

        if (etablissementPOJO != null)
            return etablissementPOJO;
        else
            return etablissementPOJOS.get(i);

    }

    @Override
    public long getItemId(int i) {

        if (etablissementPOJO != null)
            return Long.parseLong(etablissementPOJO.getCode());
        else
            return Long.parseLong(etablissementPOJOS.get(i).getCode());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.diplome_layout,null);

        TextView cap = view.findViewById(R.id.cap);
        TextView etab = view.findViewById(R.id.etablissement);
        TextView score = view.findViewById(R.id.score);
        TextView filiere = view.findViewById(R.id.filiere);
        TextView section = view.findViewById(R.id.section);
        TextView code = view.findViewById(R.id.code);
        TextView domaine = view.findViewById(R.id.domaine);

        if( etablissementPOJOS != null)
        {
            if (etablissementPOJOS.size() > 0)
            {
                DiplomePOJO etablissement = etablissementPOJOS.get(i);

                String itemCode = etablissement.getCode();
                String itemDomaine = etablissement.getDomaine();
                String itemEtablissement = etablissement.getEtablissement().toLowerCase();
                Integer itemCapacite = etablissement.getCapacite();
                Integer itemScore = etablissement.getScore();

                String itemFilere = etablissement.getFiliere();
                String itemSection= etablissement.getSection();

                code.setText("Code : "+itemCode);
                domaine.setText("Domaine : "+itemDomaine);
                etab.setText("Etablissement : "+itemEtablissement);
                cap.setText("Capacité : "+itemCapacite.toString());
                score.setText("Score : "+itemScore.toString());

                filiere.setText("Filiere : "+ itemFilere);
                section.setText("Section : "+itemSection);

            }
        }else if (etablissementPOJOS != null)
        {
            
        }

        return view;
    }
}
