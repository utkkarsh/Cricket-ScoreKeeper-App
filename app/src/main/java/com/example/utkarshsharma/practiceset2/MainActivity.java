package com.example.utkarshsharma.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int scoreA=0;
    public int valA=0;
    public int outA=0;
    public int numBallA=0;
    public int scoreB=0;
    public int outB=0;
    public int numBallB=0;
    public int turn=0;


    Button B0,B1,B2,B4,B6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn=1;
        TextView msg=(TextView) findViewById(R.id.msg);
        msg.setText("Team A chooses Batting");
    }
    // method to select the value of runs according to the selected button for Team A
    public void addA(View v) {
        switch (v.getId())
        {
            case R.id.add0 : valA=0; break;
            case R.id.add1 : valA=1; break;
            case R.id.add2 : valA=2; break;
            case R.id.add4 : valA=4; break;
            case R.id.add6 : valA=6; break;
        }
        addTeamA(valA);
    }

    // method to select the value of runs according to the selected button for Team A
    public void addB(View v) {
        switch (v.getId())
        {
            case R.id.add0B : valA=0; break;
            case R.id.add1B : valA=1; break;
            case R.id.add2B : valA=2; break;
            case R.id.add4B : valA=4; break;
            case R.id.add6B : valA=6; break;
        }
        addTeamB(valA);
    }

    // method to check for TeamA's turn and display the score
    public void addTeamA(int number) {
        if(turn==1)
        {
            scoreA = scoreA + number;   //  increase score of teamA
            numBallA = numBallA+1;      //  increase # of balls of teamA
        }
        displayScoreA(scoreA,outA,numBallA);
    }
    // method to check for TeamA's turn and display the score while update the foul
    public void OutA(View v) {
        if(turn==1)
        {
            outA = outA + 1;            //  increase # of player out from teamA
            numBallA=numBallA+1;        //  increase # of balls of teamA
        }
        checkA();
        displayScoreA(scoreA,outA,numBallA);
    }

    // method to display the score for TeamA
    public void displayScoreA(int scoreA,int outA,int numBallA) {

        TextView score = (TextView) findViewById(R.id.score1);
        TextView out = (TextView) findViewById(R.id.balls1);
        out.setText("Balls : "+ numBallA);
        score.setText(scoreA + " / " + outA);
    }

    public void addTeamB(int number) {
        if(turn==2)
        {
            scoreB = scoreB + number;   //  increase score of teamA
            numBallB = numBallB+1;      //  increase # of balls of teamA
        }
        displayScoreB(scoreB,outB,numBallB);
    }

    public void OutB(View v) {
        if(turn==2)
        {
            outB = outB + 1;            //  increase # of player out from teamA
            numBallB=numBallB+1;        //  increase # of balls of teamA
        }
        checkB();
        displayScoreB(scoreB,outB,numBallB);
    }


    public void displayScoreB(int scoreB,int outB,int numBallB) {
        TextView score = (TextView) findViewById(R.id.score2);
        TextView out = (TextView) findViewById(R.id.balls2);
        out.setText("Balls : "+ numBallB);
        score.setText(scoreB + " / " + outB);
    }
    // method to reset the match
    public void resetMatch(View v)
    {   scoreA=0;
        outA=0;
        numBallA=0;
        scoreB=0;
        outB=0;
        numBallB=0;
        turn=1;
        displayScoreA(scoreA,outA,numBallA);
        displayScoreB(scoreB,outB,numBallB);
        TextView msg=(TextView) findViewById(R.id.msg);
        msg.setText("Rematch : Team A's Turn");
        B0=(Button)findViewById(R.id.out1b);
        B0.setEnabled(true);
        B1=(Button)findViewById(R.id.out2b);
        B1.setEnabled(true);

    }
    // method to check if all players of TeamA are out
    public void checkA()
    {
        if ( outA > 9)
        {   TextView msg=(TextView) findViewById(R.id.msg);
            msg.setText("Team B's Turn");
            turn=2;
            B0=(Button)findViewById(R.id.out1b);
            B0.setEnabled(false);
        }
    }
    // method to check if all players of Team B are out
    public void checkB()
    {
        if ( outB > 9)
        {
            TextView msg=(TextView) findViewById(R.id.msg);
            turn=0;
            B0=(Button)findViewById(R.id.out2b);
            B0.setEnabled(false);
            if(scoreA>scoreB)
            {
                msg.setText("Winner is Team A");
            }
            else if(scoreA<scoreB)
            {
                msg.setText("Winner is Team B");
            }
            else {
             msg.setText("Match Draw");
            }

        }
    }

}