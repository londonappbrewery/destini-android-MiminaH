package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryText;
    int mStoryIndex;

    // assign resource IDs of Stories & Buttons to corresponding arrays
    final int[] mStoryTextArray = {R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
            R.string.T4_End, R.string.T5_End, R.string.T6_End};

    final int[] mButtonTopTextArray = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};

    final int[] mButtonBottomTextArray = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((mStoryIndex == 1) || (mStoryIndex == 2)){
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                }
                screenUpdate();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1){
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                mStoryIndex = 5;
                }
                screenUpdate();
            }
        });
    }

    public void screenUpdate(){
        if ((mStoryIndex == 4) ||(mStoryIndex == 5) || (mStoryIndex == 6)) {
            endGame();
        } else {
            mButtonTop.setText(mButtonTopTextArray[mStoryIndex - 1]);
            mStoryText.setText(mStoryTextArray[mStoryIndex - 1]);
            mButtonBottom.setText(mButtonBottomTextArray[mStoryIndex - 1]);
        }
    }

    public void endGame(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game Over");
        alert.setCancelable(false);     // Cancelable means taping elsewhere to make Dialog disappear (not allowing user to do so here)
        alert.setMessage(mStoryTextArray[mStoryIndex-1]);

        // setting onClickListener() on the close Button
        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();       // close App
            }
        });
        alert.show();
    }
}
