package com.spaceintruders.h2_Memory_Game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<CustomButtonClass> models = new ArrayList<>();
    //TODO nehme hier erstmal irgend ne Liste zum testen

    public RecyclerViewAdapter(List<CustomButtonClass> viewModels) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SimpleViewHolder(view);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bindData(models.get(position));
    }

    public int getItemCount() {
        return models.size();
    }

    public int getItemViewType(int position) {
        return R.layout.activity_item_for_recyc;
    }
}
