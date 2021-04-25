package com.spaceintruders.h2_Memory_Game;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates a Game Session
 *
 * @return List of Buttons */

public class Game implements Serializable {
    // VARS
    private final Context context;
    private View view;
    private GridLayout mygridLay;
    private RecyclerView recycleview;
    private RecyclerViewAdapter adapter;
    private TextView textTimer;
    private TextView txt_name;
    private TextView scoreDisplay;
    private final int gridSize;
    private String name;
    private int nFlips;
    private int overallTime = 0;
    private  int Score = 0;
    private CountDownTimer mytimer;
    private int numberOfElements;
    private List<CustomButtonClass> listOFButtons;
    private int[] buttonGraphicLocation;
    private int[]buttonGraphics;
    private final int[] frontImagesReferences = {
            R.drawable.img1,R.drawable.img2,
            R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,
            R.drawable.img8,R.drawable.img10,
            R.drawable.img11,R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
            R.drawable.img17,R.drawable.img18};

    private CustomButtonClass selcetedButton1;
    private CustomButtonClass selcetedButton2;
    private boolean isBussy = false;

    /**Konstruktor für Game
    * @param sizeOfGrid
    *  @return List of Buttons */

    public Game(Context context, int sizeOfGrid){
        super();
        this.context = context;

        this.gridSize = sizeOfGrid;
        this.overallTime = 0;
        this.Score = 0;
        this.listOFButtons = null ;
        this.buttonGraphicLocation = null ;
        this.buttonGraphics= null;

    }

    public List<CustomButtonClass> newGameList() {
        //TODO Scores

        makeTimer();
        // calc Elements
        numberOfElements = gridSize * gridSize;
        // Build ArrayList with //TODO nicht schön aber zum testen ob list wie array genutzt werden kann
        listOFButtons = new ArrayList<CustomButtonClass>();
        for (int i = 0; i < numberOfElements; i++){
            listOFButtons.add(new CustomButtonClass(context, i, i , R.drawable.img1));
        }

        buttonGraphics = frontImagesReferences;
        buttonGraphicLocation =new int[numberOfElements];

        shuffelButton();

        for(int r = 0;  r<gridSize; r++)  { // ROWS
            for (int c = 0; c < gridSize; c++) { //COLUMS

                CustomButtonClass temButton = new CustomButtonClass(context, r, c, buttonGraphics[buttonGraphicLocation[r * gridSize + c]]);
                temButton.setId(View.generateViewId());
                //temButton.setOnClickListener(theListener); //TODO glaub das muss en view werden
                temButton.setTheListenerinButton(theListener);
                listOFButtons.set(r * gridSize + c, temButton);

            }
        }
        return listOFButtons;
    }

    private void makeTimer() {
    }
    /**
     * randomizes the order of the cards
     * use helper buttonGraphicLocation rand the order of the drawables in array
     */

    private void shuffelButton() {
        //fill an Shuffel Cards (SWAP RAND SOTRE)
        Random rand = new Random();
        for (int i = 0  ; i < numberOfElements; i++){
            buttonGraphicLocation[i] = i % (numberOfElements/2);
        }
        for (int i = 0  ; i < numberOfElements; i++){
            int temp = buttonGraphicLocation[i];
            int swapIndex = rand.nextInt(numberOfElements);
            buttonGraphicLocation[i] =  buttonGraphicLocation[swapIndex];
            buttonGraphicLocation[swapIndex] = temp;
        }
    }
    View.OnClickListener getListener(View view){
    View.OnClickListener theListener = new View.OnClickListener(){
        public void onClick(View view) {
            Log.e ("theListener over getListener", "isclicked");

            if (isBussy){
                return;
            }

            CustomButtonClass button = (CustomButtonClass) view;
            if (button.isMatched){
                return;
            }
            if (selcetedButton1 == null){
                //show first
                selcetedButton1 = button;
                selcetedButton1.flip();

                return;
            }
            if (selcetedButton1.getId()== button.getId()){
                // double selected
                return;
            }
            // Check if matches
            if (selcetedButton1.getFrontImageID() == button.getFrontImageID()){
                button.flip();
                button.setMatched(true);
                selcetedButton1.setMatched(true);

                selcetedButton1.setEnabled(false);
                button.setEnabled(false);
                // dont forget to reset
                selcetedButton1 = null;
                nFlips += 1;
                Score += 5;
                scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);

                return;
            }
            else {
                selcetedButton2 = button;
                selcetedButton2.flip();
                isBussy = true;

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nFlips +=1;
                        scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);
                        selcetedButton2.flip();
                        selcetedButton1.flip();
                        selcetedButton1 = null;
                        selcetedButton2 = null;
                        Score -= 1;
                        if (Score < 1){
                            Score = 0;
                        }
                        scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);
                        isBussy = false;


                    }
                },700);
            }
        }
    };return theListener;}


    View.OnClickListener theListener = new View.OnClickListener(){
        public void onClick(View view) {
            Log.e ("theListener", "isclicked");

            if (isBussy){
                return;
            }

            CustomButtonClass button = (CustomButtonClass) view;
            if (button.isMatched){
                return;
            }
            if (selcetedButton1 == null){
                //show first
                selcetedButton1 = button;
                selcetedButton1.flip();

                return;
            }
            if (selcetedButton1.getId()== button.getId()){
                // double selected
                return;
            }
            // Check if matches
            if (selcetedButton1.getFrontImageID() == button.getFrontImageID()){
                button.flip();
                button.setMatched(true);
                selcetedButton1.setMatched(true);

                selcetedButton1.setEnabled(false);
                button.setEnabled(false);
                // dont forget to reset
                selcetedButton1 = null;
                nFlips += 1;
                Score += 5;
                scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);

                return;
            }
            else {
                selcetedButton2 = button;
                selcetedButton2.flip();
                isBussy = true;

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nFlips +=1;
                        scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);
                        selcetedButton2.flip();
                        selcetedButton1.flip();
                        selcetedButton1 = null;
                        selcetedButton2 = null;
                        Score -= 1;
                        if (Score < 1){
                            Score = 0;
                        }
                        scoreDisplay.setText("Score " + Score+ " Flips " +nFlips);
                        isBussy = false;


                    }
                },700);
            }
        }
    };

}
