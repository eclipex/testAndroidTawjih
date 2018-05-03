package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

public class DiplomePOJO {

    @SerializedName("id")
    private Integer id;
    @SerializedName("Code")
    private String code;
    @SerializedName("Score")
    private Integer score;
    @SerializedName("Capacité")
    private Integer capacite;
    @SerializedName("Section")
    private String section;
    @SerializedName("domaine")
    private String domaine;
    @SerializedName("Filiere")
    private String filiere;
    @SerializedName("Etablissement")
    private String etablissement;
    @SerializedName("Request Params")
    private String param;


    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
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
}