package com.example.tectdepot.spaceapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlanetsTopicsAdapter extends RecyclerView.Adapter<PlanetsTopicsAdapter.ViewHolder> {
    private final List<String> data;
    private final List<String> data2;

    public PlanetsTopicsAdapter(List<String> data, List<String> data2) {
        this.data = data;
        this.data2 = data2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_planets_topics, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String itemData = data.get(position);
        String itemData2 = data2.get(position);
        holder.txtTopic.setText(itemData);
        holder.txtExpandedInfo.setText(itemData2);

        List<Boolean> isExpanded = new ArrayList<>();

        for (int i = 0; i < getItemCount(); i++) {
            isExpanded.add(false);
        }

        holder.planetsTopicCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isExpanded.get(position)) {
                    holder.txtExpandedInfo.setVisibility(View.VISIBLE);
                    isExpanded.set(position, true);
                    holder.arrowDrop.setImageResource(R.drawable.ic_arrow_up);
                } else {
                    holder.txtExpandedInfo.setVisibility(View.GONE);
                    isExpanded.set(position, false);
                    holder.arrowDrop.setImageResource(R.drawable.dropdown_logo);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTopic;
        TextView txtExpandedInfo;
        CardView planetsTopicCardView;
        ImageView arrowDrop;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTopic = itemView.findViewById(R.id.txtTopic);
            txtExpandedInfo = itemView.findViewById(R.id.txtExpandedInfo);
            planetsTopicCardView = itemView.findViewById(R.id.planetsTopicCardView);
            arrowDrop = itemView.findViewById(R.id.arrowDrop);
        }
    }
}
