package com.example.starwars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Model.Planets;

import java.util.ArrayList;

public class AdapterPlanet extends RecyclerView.Adapter<AdapterPlanet.MyViewHolder> {
    ArrayList<Planets> result;
    Context context;

    public AdapterPlanet(Context context, ArrayList<Planets> result) {
        super();
        this.result = result;
        this.context = context;
    }

    void updateList(ArrayList planets){
        result=planets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterPlanet.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_planet, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPlanet.MyViewHolder holder, int position) {
        holder.bind(result.get(position));
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, diameter, gravity, population, climated;

        public void bind(Planets planets){
            name.setText(planets.getName());
            diameter.setText(planets.getDiameter());
            gravity.setText(planets.getGravity());
            population.setText(planets.getPopulation());
            climated.setText(planets.getClimate());
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_planet);
            diameter = itemView.findViewById(R.id.txt_diameter);
            gravity = itemView.findViewById(R.id.txt_gravity);
            population = itemView.findViewById(R.id.txt_population);
            climated = itemView.findViewById(R.id.txt_climate);
        }
    }
}
