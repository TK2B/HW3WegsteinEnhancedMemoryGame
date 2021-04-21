package com.spaceintruders.h2_Memory_Game;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;

public class CustomButtonClass extends Button {
    // Declare Vars
    protected int row;
    protected int colum;
    protected int frontImageID;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;
    protected Drawable front;
    protected Drawable back;

    public CustomButtonClass (Context context, AttributeSet set){
        super(context, set);
        Log.e ("inflate Constuctore" , "der andere");


        // TODO Check if there is anything else i have todo is this constructor only used
        back = context.getDrawable(R.drawable.back);
        back = resize(back);
        setBackground(back);



    }
    public CustomButtonClass (Context context, int row_i, int colum_i, int frontImageID_i ){

        super(context);
        Log.e ("mein Constuctore" , "jo" );
        row = row_i;
        colum = colum_i;
        frontImageID = frontImageID_i;

        front = context.getDrawable(frontImageID);
        //front = AppCompatDrawableManager.get().getDrawable(context, frontImageID);
        back = context.getDrawable(R.drawable.back);

        setBackground(back);

        LayoutParams tempParams = new LayoutParams(GridLayout.spec(row_i), GridLayout.spec(colum_i));
        tempParams.width = (int) getResources().getDisplayMetrics().density * 80;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 80;
        //tempParams.setGravity(Gravity.CENTER);
        setLayoutParams(tempParams);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontImageID() {
        return frontImageID;
    }
    ///TODO onyl for testing
    public void setFrontImageID(int id ) {
        frontImageID =id;
    }


    public void setBackground(int pick) {
        Drawable ein = getResources().getDrawable(pick);

        this.setBackground(ein);
    }


    public void flip(){
        if (isMatched){
            return;
        }
        if (isFlipped){
            setBackground(back);
            isFlipped = false;
        }
        else {
            setBackground(front);
            isFlipped = true;




        }

    }
    //TODO Test ob sich ein objet selbst wiedergeben kann
    public CustomButtonClass getwholeButtonClass (){
        CustomButtonClass myTHIS = this;
        Log.e  ("myTHIS: ", myTHIS.toString());
        return myTHIS;
    }


    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 80, 80, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }

}
