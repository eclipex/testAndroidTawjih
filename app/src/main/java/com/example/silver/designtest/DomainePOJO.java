package com.example.silver.designtest;

import com.google.gson.annotations.SerializedName;

public class DomainePOJO {


    @SerializedName("id")
    private String id;

    @SerializedName("Designation")
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
