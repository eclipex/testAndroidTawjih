package com.example.silver.designtest.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.silver.designtest.Modeles.DiplomePOJO;

public class FavorisAdapter extends BaseAdapter {

    private DiplomePOJO favoris1,favoris2;
    private Context context;

    public FavorisAdapter( DiplomePOJO favoris1, DiplomePOJO favoris2, Context context )
    {
        this.context = context;
        this.favoris1 = favoris1;
        this.favoris2 = favoris2;
    }

    @Override
    public int getCount() {
        return 0;
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
        return view;
    }
}
