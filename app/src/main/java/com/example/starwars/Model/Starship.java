package com.example.starwars.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Starship extends Vehicle implements Serializable {
    @SerializedName("starship_class")
    public String starshipClass;

    @SerializedName("hyperdrive_rating")
    public String hyperdriveRating;

    @SerializedName("MGLT")
    public String mglt;
}
