package com.spaceintruders.h2_Memory_Game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <SimpleViewHolder> {

    private List<CustomButtonClass> models = new ArrayList<>();
    Game dasSpieldurchgereicht;


    public RecyclerViewAdapter(Context context, List<CustomButtonClass> viewModels, Game aktuellesSpiel) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
            this.dasSpieldurchgereicht = aktuellesSpiel;

        }
    }
    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new SimpleViewHolder(view, dasSpieldurchgereicht);
    }


    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bindData(models.get(position));
    }

    public int getItemCount() {
        return models.size();
    }

    public int getItemViewType(int position) {
        return R.layout.activity_item_for_recyc;
    }
}
