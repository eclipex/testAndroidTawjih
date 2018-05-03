package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

/**
 * Simple POJO model for example
 */
public class FavorisPOJO {

    @SerializedName("Fav 1")
    private int fav1;
    @SerializedName("Fav 2")
    private int fav2;


    public FavorisPOJO(int fav1,int fav2) {
        this.fav1 = fav1;
        this.fav2 = fav2;

    }

    public int getFav1() {
        return fav1;
    }

    public void setFav1(int fav1) {
        this.fav1 = fav1;
    }

    public int getFav2() {
        return fav2;
    }

    public void setFav2(int fav2) {
        this.fav2 = fav2;
    }


}
