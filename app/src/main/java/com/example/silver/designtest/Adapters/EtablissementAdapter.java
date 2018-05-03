package com.example.silver.designtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silver.designtest.Modeles.EtablissementPOJO;
import com.example.silver.designtest.R;

import java.util.List;

public class EtablissementAdapter extends BaseAdapter {

    private List<EtablissementPOJO> etablissementPOJOS;
    private Context context;
    private EtablissementPOJO etablissementPOJO;


    //Pour afficher toute la liste  des domaines
    public EtablissementAdapter(List<EtablissementPOJO> etablissementPOJOS, Context context )
    {
        this.context = context;
        this.etablissementPOJOS = etablissementPOJOS;
        this.etablissementPOJO = null;
    }

    //Pour afficher un seul element
    public EtablissementAdapter(EtablissementPOJO etablissementPOJO, Context context )
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
            return Integer.parseInt(etablissementPOJO.getId());
        else
            return Integer.parseInt(etablissementPOJOS.get(i).getId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_view_custom_layout_3items,null);
        TextView designation =  view.findViewById(R.id.designation);
        TextView region =  view.findViewById(R.id.region);
        TextView type =  view.findViewById(R.id.type);


        if( etablissementPOJOS != null)
        {
            if (etablissementPOJOS.size() > 0)
            {
                EtablissementPOJO etablissement = etablissementPOJOS.get(i);

                String itemDesignation = etablissement.getDesignation().toLowerCase().substring(0,1).toUpperCase() +
                        etablissement.getDesignation().toLowerCase().substring(1);
                String itemType = etablissement.getType();
                String itemRegion = etablissement.getRegion();

                designation.setText(itemDesignation);
                type.setText("Type : "+itemType);
                region.setText("Region : "+itemRegion);

            }
        }else if (etablissementPOJOS != null)
        {
            designation.setText("Designation : "+etablissementPOJO.getDesignation());
            type.setText("Type : "+etablissementPOJO.getType());
            region.setText("Region : "+etablissementPOJO.getRegion());

        }

        return view;
    }
}
