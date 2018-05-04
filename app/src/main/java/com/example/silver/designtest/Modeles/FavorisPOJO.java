package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Simple POJO model for example
 */
public class FavorisPOJO {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("User")
    @Expose
    private Integer user;
    @SerializedName("Filiere fav 1")
    @Expose
    private String filiereFav1;
    @SerializedName("Etablissement fav 1")
    @Expose
    private String etablissementFav1;
    @SerializedName("Code fav 1")
    @Expose
    private String codeFav1;
    @SerializedName("Section fav 1")
    @Expose
    private String sectionFav1;
    @SerializedName("Score fav 1")
    @Expose
    private Integer scoreFav1;
    @SerializedName("Filiere fav 2")
    @Expose
    private String filiereFav2;
    @SerializedName("Etablissement fav 2")
    @Expose
    private String etablissementFav2;
    @SerializedName("Code fav 2")
    @Expose
    private String codeFav2;
    @SerializedName("Section fav 2")
    @Expose
    private String sectionFav2;
    @SerializedName("Score fav 2")
    @Expose
    private Integer scoreFav2;
    @SerializedName("Diplome id 2")
    private Integer idDiplome2;

    @SerializedName("Diplome id 1")
    private Integer idDiplome1;

    public Integer getIdDiplome2() {
        return idDiplome2;
    }

    public void setIdDiplome2(Integer idDiplome2) {
        this.idDiplome2 = idDiplome2;
    }

    public Integer getIdDiplome1() {
        return idDiplome1;
    }

    public void setIdDiplome1(Integer idDiplome1) {
        this.idDiplome1 = idDiplome1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getFiliereFav1() {
        return filiereFav1;
    }

    public void setFiliereFav1(String filiereFav1) {
        this.filiereFav1 = filiereFav1;
    }

    public String getEtablissementFav1() {
        return etablissementFav1;
    }

    public void setEtablissementFav1(String etablissementFav1) {
        this.etablissementFav1 = etablissementFav1;
    }

    public String getCodeFav1() {
        return codeFav1;
    }

    public void setCodeFav1(String codeFav1) {
        this.codeFav1 = codeFav1;
    }

    public String getSectionFav1() {
        return sectionFav1;
    }

    public void setSectionFav1(String sectionFav1) {
        this.sectionFav1 = sectionFav1;
    }

    public Integer getScoreFav1() {
        return scoreFav1;
    }

    public void setScoreFav1(Integer scoreFav1) {
        this.scoreFav1 = scoreFav1;
    }

    public String getFiliereFav2() {
        return filiereFav2;
    }

    public void setFiliereFav2(String filiereFav2) {
        this.filiereFav2 = filiereFav2;
    }

    public String getEtablissementFav2() {
        return etablissementFav2;
    }

    public void setEtablissementFav2(String etablissementFav2) {
        this.etablissementFav2 = etablissementFav2;
    }

    public String getCodeFav2() {
        return codeFav2;
    }

    public void setCodeFav2(String codeFav2) {
        this.codeFav2 = codeFav2;
    }

    public String getSectionFav2() {
        return sectionFav2;
    }

    public void setSectionFav2(String sectionFav2) {
        this.sectionFav2 = sectionFav2;
    }

    public Integer getScoreFav2() {
        return scoreFav2;
    }

    public void setScoreFav2(Integer scoreFav2) {
        this.scoreFav2 = scoreFav2;
    }

}
