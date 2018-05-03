package com.example.silver.designtest.Modeles;

import com.google.gson.annotations.SerializedName;

public class EtablissementPOJO {

    @SerializedName("id")
    public String id;

    @SerializedName("Designation")
    public String designation;

    @SerializedName("Type")
    public String type;

    @SerializedName("Region")
    public String region;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String desgnation) {
        this.designation = desgnation;
    }
}
