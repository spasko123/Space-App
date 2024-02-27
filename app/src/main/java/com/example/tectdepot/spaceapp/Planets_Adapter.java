package com.example.tectdepot.spaceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Planets_Adapter extends RecyclerView.Adapter<Planets_Adapter.MyViewHolder> {

    private final PlanetsRecycleViewInterface planetsRecycleViewInterface;
    Context context;
    ArrayList<Planets> planets;

    public Planets_Adapter(MainActivity2 context, ArrayList<Planets> planets, PlanetsRecycleViewInterface planetsRecycleViewInterface){
        this.context = (Context) context;
        this.planets = planets;
        this.planetsRecycleViewInterface = planetsRecycleViewInterface;
    }
    @NonNull
    @Override
    public Planets_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.planets_recycle_view, parent, false);
        return new Planets_Adapter.MyViewHolder(view, planetsRecycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Planets_Adapter.MyViewHolder holder, int position) {
        holder.planetName.setText(planets.get(position).getPlanetName());
        holder.planetImage.setImageResource(planets.get(position).getPlanetImage());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView planetImage;
        TextView planetName;

        public MyViewHolder(@NonNull View itemView, PlanetsRecycleViewInterface planetsRecycleViewInterface) {
            super(itemView);

            planetImage = itemView.findViewById(R.id.planetImage);
            planetName = itemView.findViewById(R.id.planetName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(planetsRecycleViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            planetsRecycleViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
