package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

/**
 * Simple POJO model for example
 */
public class FavorisPOJO {

    @SerializedName("id")
    private Integer id;

    @SerializedName("User")
    private Integer user;

    @SerializedName("Filiere")
    private String filiere;

    @SerializedName("Etablissement")
    private String etablissement;

    @SerializedName("Code")
    private String code;

    @SerializedName("Section")
    private String section;

    @SerializedName("Score")
    private Integer score;

    @SerializedName("Diplome")
    private Integer idDiplome;


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

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }






}
