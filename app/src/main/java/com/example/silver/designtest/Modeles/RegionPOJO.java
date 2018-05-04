package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionPOJO {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Designation")
    @Expose
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
