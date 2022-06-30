package com.example.starwars.API;

import com.example.starwars.Model.Planets;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("results")
    ArrayList<Planets> result;

    public ArrayList<Planets> getResult(){

        return result;
    }

    public void setResult(ArrayList<Planets> result){

        this.result=result;
    }
}
