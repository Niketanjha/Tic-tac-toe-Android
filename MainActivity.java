package com.example.linuxlite.niketictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int[] signpostition={2,2,2,2,2,2,2,2,2};
    int[][] probposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive=true;
    //For o i use=0,for x i used =1

        public void dragfun(View view){
            ImageView zero =(ImageView) view;
            int whichtapped=Integer.parseInt(zero.getTag().toString());
            if(signpostition[whichtapped]==2 &&gameactive){
                /*whichtapped used to get which imageview is clicked*/
                zero.setTranslationY(-1000f);
                signpostition[whichtapped]=player;
                if(player==0){
                    zero.setImageResource(R.drawable.o);
                    signpostition[whichtapped]=0;
                    player=1;}
                else{
                    zero.setImageResource(R.drawable.x);
                    signpostition[whichtapped]=1;
                    player=0;
             }
             zero.animate().translationYBy(1000f).rotation(3600).setDuration(300);


    for (int[] probpositions : probposition){
        if(signpostition[probpositions[0]]==signpostition[probpositions[1]]
                &&signpostition[probpositions[1]]==signpostition[probpositions[2]]
        && signpostition[probpositions[0]]!=2) {
            gameactive = false;
            String winner = "o";
            if (signpostition[probpositions[0]] == 0) {
                winner = "o";
            }
            TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
            winnermessage.setText("The Player" + winner + "win");
            LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
            layout.setVisibility(View.VISIBLE);
        }
        else {
            boolean gameover=true;
            for(int counter:signpostition){
                if(counter==2){
                    gameover=false;}
            }
            if(gameover){
                TextView winnerMessage =(TextView) findViewById(R.id.winnermessage);
                winnerMessage.setText("Its a draw");
                LinearLayout layout=(LinearLayout) findViewById(R.id.playagainlayout);
                layout.setVisibility(View.VISIBLE);
            }
        }


    }} }

    public void playagain(View view){
        gameactive=true;
        LinearLayout layout=(LinearLayout) findViewById(R.id.playagainlayout);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relativelayout1);
        for(int i=0;i<9;i++){
            ((ImageView) relativeLayout.getChildAt(i)).setImageResource(0);
            Log.i("seethis",relativeLayout.getChildAt(i).toString());
        }
        player=0;
        for(int i=0;i<signpostition.length;i++){
            signpostition[i]=2;
            }
        layout.setVisibility(View.INVISIBLE);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
