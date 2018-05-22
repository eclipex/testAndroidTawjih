package com.example.silver.designtest.Api;

import com.example.silver.designtest.Modeles.DiplomePOJO;
import com.example.silver.designtest.Modeles.DomainePOJO;
import com.example.silver.designtest.Modeles.EtablissementPOJO;
import com.example.silver.designtest.Modeles.FavorisPOJO;
import com.example.silver.designtest.Modeles.FilierePOJO;
import com.example.silver.designtest.Modeles.RegionPOJO;
import com.example.silver.designtest.Modeles.SectionPOJO;
import com.example.silver.designtest.Modeles.UserPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface
{

    //API Interface == liste des Controlleurs
    //localhost for emulator = 10.0.2.2

    // methode = Get
    // localhost/TawjihAPIRest/web/app_dev/domaines
    @GET("domaines")
    Call<List<DomainePOJO>> getDomaines();
    @GET("domaine/{id}")
    Call<DomainePOJO> getDomaine(@Path("id") int id);



    @GET("etablissements")
    Call<List<EtablissementPOJO>> getEtablissements();
    @GET("etablissement/{id}")
    Call<EtablissementPOJO> getEtablissement(@Path("id") int id);
    @GET("etablissement/type/{idType}")
    Call<List<EtablissementPOJO>> getEtablissementByType(@Path("idType") String id);
    @GET("etablissement/region/{idRegion}")
    Call<List<EtablissementPOJO>> getEtablissementByRegion(@Path("idRegion") String id);


    // methode = Get
    // localhost/TawjihAPIRest/web/app_dev/sections
    @GET("sections")
    Call<List<SectionPOJO>> getSections();
    @GET("section/{id}")
    Call<SectionPOJO> getSection(@Path("id") int id);



    @GET("filieres")
    Call<List<FilierePOJO>> getFilieres();
    @GET("filieres/domaine/{id}")
    Call<List<FilierePOJO>> getFilieres(@Path("id") String domaine);
    @GET("filieres/{id}")
    Call<FilierePOJO> getFiliere(@Path("id") int id);




    @FormUrlEncoded
    @PATCH("user/{id}")
    Call<UserPOJO> ModifyUser(@Path("id") int id,
                              @Field("cin") Integer cin,
                              @Field("pass") String pass,
                              @Field("nom") String nom,
                              @Field("prenom") String prenom,
                              @Field("email") String email ,
                              @Field("section") Integer section,
                              @Field("score") Float score);
    @GET("user/{cin}/{pass}")
    Call<UserPOJO> getUser(@Path("cin") int cin, @Path("pass") String pass);
    @GET("user/{id}")
    Call<UserPOJO> getUser(@Path("id") int id);
    @FormUrlEncoded
    @POST("user")
    Call<UserPOJO> addUser(@Field("cin") int cin,
                           @Field("pass") String pass,
                           @Field("nom") String nom,
                           @Field("prenom") String prenom,
                           @Field("email") String email ,
                           @Field("section") int section,
                           @Field("score") int score);


    @GET("favoris/{idUser}")
    Call<List<FavorisPOJO>> getFavoris(@Path("idUser") int id);
    @PATCH("favoris/{idFav}")
    Call<FavorisPOJO> patchFavoris(@Path("idFav") int id);
    @POST("favoris/{idUser}/{idDiplome}")
    Call<FavorisPOJO> postFavoris(@Path("idUser") int user,@Path("idDiplome") int diplome);
    @DELETE("favoris/{idFav}")
    Call<FavorisPOJO> deleteFavoris(@Path("idFav") int id);

    @GET("diplome/code/{code}")
    Call<DiplomePOJO> getDiplomeByCode(@Path("code") String code);
    @GET("diplome/{id}")
    Call<DiplomePOJO> getDiplome(@Path("id") int id);
    @GET("diplomes/filiere/{id}")
    Call<List<DiplomePOJO>> getDiplomes(@Path("id") String filiere);
    @GET("diplomes/etablissement/{id}")
    Call<List<DiplomePOJO>> getDiplomesByEtab(@Path("id") String etablissement);
    @GET("diplomes")
    Call<List<DiplomePOJO>> getDiplomes();
    @GET("diplomes/custom")
    Call<List<DiplomePOJO>> getDiplomesCustom(@Query("score") int score, @Query("section") int section);


    @GET("regions")
    Call<List<RegionPOJO>> getRegions();


}
