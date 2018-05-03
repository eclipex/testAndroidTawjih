package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

public class FilierePOJO {

    @SerializedName("id")
    public String id;

    @SerializedName("Designation")
    public String designation;

    @SerializedName("Domaine")
    public String domaine;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        designation = designation;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        domaine = domaine;
    }
}
