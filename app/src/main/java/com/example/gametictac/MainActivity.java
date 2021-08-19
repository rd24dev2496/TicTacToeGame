package com.example.gametictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer=0;
    Boolean gameActive=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    public static int counters = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dropin(View view){
        ImageView counter=(ImageView)view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }

        if (gameState[tappedCounter]==2 && gameActive){
            gameState[tappedCounter]=activePlayer;

            counters++;
            // counter.getTag();
            counter.setTranslationY(-1500);


            if(activePlayer==0){
                counter.setImageResource(R.drawable.cross);
                activePlayer=1;
            }else {
                counter.setImageResource(R.drawable.zero);
                activePlayer=0;
            }
            if (counters==9) {
                gameReset(view);
            }
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

        int flag = 0;

        for(int []winningPosition:winningPositions){
            String winner;

            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]]==gameState[winningPosition[2]]&&gameState[winningPosition[0]]!=2)
            {
                flag=1;
                gameActive=false;
                if(activePlayer==1)
                {
                    winner="Cross";
                }else
                {
                    winner="Zero";
                }

                Toast.makeText(this,winner+" has won",Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        // remove all the images from the boxes inside the grid
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);
    }

}