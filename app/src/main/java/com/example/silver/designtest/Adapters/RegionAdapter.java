package com.example.silver.designtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silver.designtest.Modeles.RegionPOJO;
import com.example.silver.designtest.R;

import java.util.List;

public class RegionAdapter extends BaseAdapter{

    private List<RegionPOJO> regions;
    private Context context;
    private RegionPOJO regionPOJO;

    //Pour afficher toute la liste  des domaines
    public RegionAdapter(List<RegionPOJO> regions, Context context )
    {
        this.context = context;
        this.regions = regions;
        this.regionPOJO = null;
    }

    //Pour afficher un seul element
    public RegionAdapter(RegionPOJO regionPOJO, Context context )
    {
        this.context = context;
        this.regionPOJO = regionPOJO;
        this.regions = null;
    }

    @Override
    public int getCount() {

        if (regionPOJO != null )
            return 1;
        else if (regions != null )
            return regions.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {

        if (regionPOJO != null)
            return regions.get(i);
        else
            return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_view_custom_layout,null);
        TextView designation =  view.findViewById(R.id.nom);


        if( regions != null)
        {
            if (regions.size() > 0)
            {
                RegionPOJO region = regions.get(i);
                String itemDesignation = region.getDesignation().toString();
                designation.setText(itemDesignation);
            }
        }else if (regionPOJO != null)
        {
            designation.setText(regionPOJO.getDesignation());
        }

        return view;
    }
}
