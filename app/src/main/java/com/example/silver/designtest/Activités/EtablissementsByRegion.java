package com.example.silver.designtest.Activités;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EtablissementsByRegion extends Fragment {

    ApiInterface apiInterface;

    public EtablissementsByRegion() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);



        return inflater.inflate(R.layout.fragment_etablissements_by_region, container, false);
    }

}
