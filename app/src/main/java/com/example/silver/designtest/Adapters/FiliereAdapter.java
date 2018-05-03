package com.example.silver.designtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silver.designtest.Modeles.FilierePOJO;
import com.example.silver.designtest.R;

import java.util.List;

public class FiliereAdapter extends BaseAdapter {

    FilierePOJO filierePOJO  ;
    Context context;
    List<FilierePOJO> filierePOJOS ;

    FiliereAdapter (FilierePOJO arg, Context cnt)
    {
        context = cnt;
        filierePOJO = arg;
    }

    public FiliereAdapter(List<FilierePOJO> arg, Context cnt)
    {
        context = cnt;
        filierePOJOS = arg;
    }


    @Override
    public int getCount() {
        if (filierePOJO != null )
            return 1;
        else
            return filierePOJOS.size();
    }

    @Override
    public Object getItem(int i) {
        if (filierePOJO != null )
            return filierePOJO;
        else
            return filierePOJOS.get(i);
    }

    @Override
    public long getItemId(int i) {
        if (filierePOJO != null )
            return Integer.parseInt(filierePOJO.getId());
        else
            return Integer.parseInt(filierePOJOS.get(i).getId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_view_custom_layout_2items,null);
        TextView designation =  view.findViewById(R.id.designation);
        TextView domaine = view.findViewById(R.id.domaine);


        if( filierePOJOS != null)
        {
            if (filierePOJOS.size() > 0)
            {
                FilierePOJO filiere = filierePOJOS.get(i);

                String itemDesignation = filiere.getDesignation();
                String itemDomaine = filiere.getDomaine();

                domaine.setTextColor(R.color.colorPrimaryDark);

                domaine.setText("Domaine : "+itemDomaine);

                designation.setText(itemDesignation);

            }else
            {
                designation.setText("Erreur");
            }
        }else if (filierePOJOS != null)
        {
            designation.setText(filierePOJO.getDesignation());
            domaine.setTextColor(R.color.colorPrimaryDark);
            domaine.setText("Domaine : "+ filierePOJO.getDomaine());
        }

        return view;
    }
}
