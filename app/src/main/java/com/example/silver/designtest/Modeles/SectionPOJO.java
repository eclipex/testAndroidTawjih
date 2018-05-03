package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

public class SectionPOJO {

    //POJO = Modele

    @SerializedName("id")
    private String id;

    @SerializedName("Designation")
    private String designation;

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
        this.designation = designation;
    }
}
