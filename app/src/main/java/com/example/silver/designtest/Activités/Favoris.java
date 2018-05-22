package com.example.silver.designtest.Activités;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.silver.designtest.Adapters.FavorisAdapter;
import com.example.silver.designtest.Api.ApiClient;
import com.example.silver.designtest.Api.ApiInterface;
import com.example.silver.designtest.Modeles.FavorisPOJO;
import com.example.silver.designtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favoris extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    ApiInterface apiInterface;
    ConstraintLayout loading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);


        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("idUser",1);

        final ListView liste = findViewById(R.id.listeRes);
        loading = findViewById(R.id.loading);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<FavorisPOJO>> call = apiInterface.getFavoris(userId);
        call.enqueue(new Callback<List<FavorisPOJO>>() {
            @Override
            public void onResponse(Call<List<FavorisPOJO>> call, final Response<List<FavorisPOJO>> response) {

                if (response.isSuccessful())
                {
                   if (response.body().size() == 0 )
                       liste.setEmptyView(findViewById(R.id.notfound));
                   else
                   {
                       loading.setVisibility(View.GONE);
                       FavorisAdapter adapter = new FavorisAdapter(response.body(),Favoris.this);
                       liste.setAdapter(adapter);
                   }
                }
            }

            @Override
            public void onFailure(Call<List<FavorisPOJO>> call, Throwable t) {
                loading.setVisibility(View.GONE);
                liste.setEmptyView(findViewById(R.id.empty));
            }
        });
    }


}
