package com.mstrblonde.simplewords.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity {

    Button guess;
    Button x;
    TextView answer;
    String currentGuess;
    String tempHint;

    TextView hint_01;
    TextView hint_02;

    ToggleButton btn_01;
    ToggleButton btn_02;
    ToggleButton btn_03;

    String[] answerArray1 = {"CHR","IST","IAN"};
    String answerString1 =  concatenateLines(answerArray1);
	String[] answerArray2 = {"MAR","IET","TA"};
	String answerString2 = concatenateLines(answerArray2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess = (Button) findViewById(R.id.guess_button);

        x = (Button) findViewById(R.id.x);

        answer = (TextView) findViewById(R.id.answer);
        answer.setText("");

        currentGuess = "";

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                currentGuess = "";
                btn_01.setChecked(false);
                btn_02.setChecked(false);
                btn_03.setChecked(false);
                btn_01.setEnabled(true);
                btn_02.setEnabled(true);
                btn_03.setEnabled(true);
            }
        });

        hint_01 = (TextView) findViewById(R.id.hint_01);
        tempHint = (String) hint_01.getText();
        hint_01.setText("1. " + tempHint + " - " + answerString1);

        hint_02 = (TextView) findViewById(R.id.hint_02);
        tempHint = (String) hint_02.getText();
        hint_02.setText("2. " + tempHint);

        btn_01 = (ToggleButton) findViewById(R.id.btn_01);
        btn_02 = (ToggleButton) findViewById(R.id.btn_02);
        btn_03 = (ToggleButton) findViewById(R.id.btn_03);

        btn_01.setText(answerArray1[0]);
        btn_01.setTextOn(answerArray1[0]);
        btn_01.setTextOff(answerArray1[0]);
        btn_02.setText(answerArray1[1]);
        btn_02.setTextOn(answerArray1[1]);
        btn_02.setTextOff(answerArray1[1]);
        btn_03.setText(answerArray1[2]);
        btn_03.setTextOn(answerArray1[2]);
        btn_03.setTextOff(answerArray1[2]);

	    //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
	    //params.setMargins(0, 0, 0, 0);
	    LinearLayout layout;
	    layout = (LinearLayout) findViewById(R.id.button_row1);


        btn_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	        @Override
	        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
		        if (isChecked) {
			        currentGuess += answerArray1[0];
			        answer.setText(currentGuess);
			        btn_01.setEnabled(false);
		        } else {
			        btn_01.setEnabled(true);
		        }
	        }
        });

        btn_02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    currentGuess += answerArray1[1];
                    answer.setText(currentGuess);
                    btn_02.setEnabled(false);
                } else {
                    btn_02.setEnabled(true);
                }
            }
        });

        btn_03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    currentGuess += answerArray1[2];
                    answer.setText(currentGuess);
                    btn_03.setEnabled(false);
                } else {
                    btn_03.setEnabled(true);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	public static String concatenateLines(String[] s) {
		StringBuilder sb = new StringBuilder(s[0]);
		if (s.length > 0) {
			//StringBuilder sb;
			sb = new StringBuilder(s[0]);
			for (int i = 1; i < s.length; i++) {
				//sb.append(separator);
				sb.append(s[i]);
			}
		}
		return sb.toString();
	}

}
