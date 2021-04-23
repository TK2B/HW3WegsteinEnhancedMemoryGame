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

    private Context context;
    private List<CustomButtonClass> models = new ArrayList<>();
    private OnItemClicked onClick;


    Game dasSpieldurchgereicht;
   // private final View.OnClickListener mOnClickListener = new View.OnClickListener();


    public RecyclerViewAdapter(Context context, List<CustomButtonClass> viewModels) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
            this.context = context;


        }
    }
    public interface OnItemClicked {
        void onItemClick(int position);
    }


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);


        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bindData(models.get(position));
        //holder.v.setOnClickListener((models.get(position)).theListener); // https://antonioleiva.com/recyclerview-listener/
        holder.itemView.setOnClickListener((View.OnClickListener) models.get(position).theListener);
    }

    public int getItemCount() {
        return models.size();
    }

    public int getItemViewType(int position) {
        return R.layout.activity_item_for_recyc;
    }


}
