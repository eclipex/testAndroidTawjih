package com.example.silver.designtest.Api;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL = "http://10.0.2.2/TawjihAPIRest/web/app_dev.php/";
    public static Retrofit retrofit = null;

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    private static Interceptor logging = interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());



    public static Retrofit getApiClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }
}
