package com.spaceintruders.h2_Memory_Game;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    private TextView simpleTextView;
    private ImageButton buttonOnItem;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        buttonOnItem = (ImageButton) itemView.findViewById(R.id.buttonInItem);
    }

    public void bindData(CustomButtonClass viewModel) {
        buttonOnItem.setImageResource(viewModel.getFrontImageID());
    }
}

