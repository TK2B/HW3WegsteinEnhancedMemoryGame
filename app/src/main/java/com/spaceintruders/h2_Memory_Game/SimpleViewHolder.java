package com.spaceintruders.h2_Memory_Game;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CustomButtonClass buttonOnItem;



    public SimpleViewHolder(View itemView) {
        super(itemView);

        this.buttonOnItem = (CustomButtonClass) itemView.findViewById(R.id.buttonInItem);
        itemView.setOnClickListener(this);
    }

    public void bindData(CustomButtonClass viewModel) {
        //buttonOnItem.setBackground(viewModel.getFrontImageID());
        Log.e ("try overhand objetzt", String.valueOf(viewModel.getwholeButtonClass().hashCode()));
        //buttonOnItem.setBackground(viewModel.getFrontImageID());
        CustomButtonClass temp = viewModel.getwholeButtonClass();

        buttonOnItem = temp;
        buttonOnItem.setOnClickListener(viewModel.getTheListeneroutofdaButton()); // Not realy a workaorund





        Log.e ("buttonOnItem on view is now ", String.valueOf(buttonOnItem.hashCode()));

    }
    static SimpleViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_for_recyc, parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        // mOnClickListener.onListItemClick(position);
        // only possilbe if you wirte Holder and Adapter in one file
    }
}

