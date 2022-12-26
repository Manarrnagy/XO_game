package com.route.xogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game extends AppCompatActivity {
    TextView player1ScoreTv,player2ScoreTv;
    int player1Score=0, player2Score=0;
    ConstraintLayout gameActivity;
    ArrayList <String> board = new ArrayList<>();
    int clickCount=0;
    String [] empty = {"","","","","","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        player1ScoreTv = findViewById(R.id.player1Score);
        player2ScoreTv = findViewById(R.id.player2Score);
        gameActivity = findViewById(R.id.gameActivity);
        board.addAll(Arrays.asList(empty));



    }


    @SuppressLint("ResourceAsColor")
    public void Onclick(View view){
        Button button = (Button) view;
        if(!button.getText().equals("")) return;
        int index = Integer.parseInt((String) button.getTag());
        if(clickCount%2 ==0){
            button.setText("X")  ;
            button.setTextColor(getResources().getColor(R.color.pink));


        }
        else{
            button.setText("O")  ;
            button.setTextColor(getResources().getColor(R.color.yellow));

        }

        clickCount++;
        if(checkBoard(button.getText().toString(),index)){
            if(button.getText().toString().equals("X")){
                player1Score++;
                player1ScoreTv.setText(""+player1Score);

                Log.e("GAME#Clear", board.toString());

            }
            else{
                player2Score++;
                player2ScoreTv.setText(""+player2Score);

            }
            resetBoard();
            return;
        }
        else if(clickCount ==9){
            resetBoard();
            return;
        }

    }

    boolean checkBoard(String symbol, int index){

        board.set(index,symbol);
        Log.e("GAME#ONCLICK", board.toString());
      for (int i=0; i<9; i++){
          if((symbol.equals(board.get(0)) &&symbol.equals(board.get(3)) && symbol.equals(board.get(6)))||(symbol.equals(board.get(1)) &&symbol.equals(board.get(4)) && symbol.equals(board.get(7)))||(symbol.equals(board.get(2)) &&symbol.equals(board.get(5)) && symbol.equals(board.get(8)))){ //Columns
            return true;
          }
          else if((symbol.equals(board.get(0)) &&symbol.equals(board.get(1)) && symbol.equals(board.get(2)))||(symbol.equals(board.get(3)) &&symbol.equals(board.get(4)) && symbol.equals(board.get(5)))||(symbol.equals(board.get(6)) &&symbol.equals(board.get(7)) && symbol.equals(board.get(8)))){ //Rows
            return true;
          }
          else if(((symbol.equals(board.get(0)) &&symbol.equals(board.get(4)) && symbol.equals(board.get(8))))||((symbol.equals(board.get(2)) &&symbol.equals(board.get(4)) && symbol.equals(board.get(6))))){ //Diagonals
            return true;
          }
      }
        return false;
    }
    void resetBoard(){
        for (int i=0; i<gameActivity.getChildCount(); i++){
            if (gameActivity.getChildAt(i)instanceof Button){
                ((Button) gameActivity.getChildAt(i)).setText("");
                Log.e("GAME#RESETBOARD", ""+i);
            }

        }
        for (int j=0; j<board.size();j++) {
            board.set(j,"");
        }

        clickCount=0;
    }
}