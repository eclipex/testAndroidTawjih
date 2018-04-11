package com.example.silver.designtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface
{

    //API Interface == Controlleur


    // methode = Get
    // localhost/TawjihAPIRest/web/app_dev/domaines
    @GET("domaines")
    Call<List<DomainePOJO>> getDomaines();

    // methode = Get
    // localhost/TawjihAPIRest/web/app_dev/domaine/id


    @GET("domaine/{id}")
    Call<DomainePOJO> getDomaine(@Path("id") int id);

    // methode = Get
    // localhost/TawjihAPIRest/web/app_dev/sections
    @GET("sections")
    Call<List<SectionPOJO>> getSections();



    @GET("user/{cin}/{pass}")
    Call<UserPOJO> getUser(@Path("cin") int cin,
                           @Path("pass") String pass);

    @FormUrlEncoded
    @POST("user")
    Call<UserPOJO> addUser(@Field("cin") int cin,
                           @Field("pass") String pass,
                           @Field("nom") String nom,
                           @Field("prenom") String prenom,
                           @Field("email") String email ,
                           @Field("section") int section,
                           @Field("score") int score);


    @FormUrlEncoded
    @PATCH("user/{id}")
    Call<UserPOJO> ModifyUser(@Path("id") int id,
                           @Field("cin") int cin,
                           @Field("pass") String pass,
                           @Field("nom") String nom,
                           @Field("prenom") String prenom,
                           @Field("email") String email ,
                           @Field("section") int section,
                           @Field("score") int score);

}
