package com.spaceintruders.h2_Memory_Game;

import android.util.Log;
import android.view.View;


import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    private CustomButtonClass buttonOnItem;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        buttonOnItem = (CustomButtonClass) itemView.findViewById(R.id.buttonInItem);
    }

    public void bindData(CustomButtonClass viewModel) {
        buttonOnItem.setBackground(viewModel.getFrontImageID());
        Log.e ("try overhand objetzt", String.valueOf(viewModel.getwholeButtonClass()));
        buttonOnItem = viewModel.getwholeButtonClass();
        Log.e ("buttonOnItem on view is now ", String.valueOf(buttonOnItem));



    }
}

