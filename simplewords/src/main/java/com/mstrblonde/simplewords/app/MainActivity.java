package com.mstrblonde.simplewords.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

	Button btn_01;
	Button btn_02;
	Button btn_03;

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
                btn_01.setEnabled(true);
                btn_02.setEnabled(true);
                btn_03.setEnabled(true);
            }
        });

        hint_01 = (TextView) findViewById(R.id.hint_01);
        tempHint = (String) hint_01.getText();
        hint_01.setText("1. " + tempHint);

        hint_02 = (TextView) findViewById(R.id.hint_02);
        tempHint = (String) hint_02.getText();
        hint_02.setText("2. " + tempHint);

        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);

        btn_01.setText(answerArray1[0]);
        btn_02.setText(answerArray1[1]);
        btn_03.setText(answerArray1[2]);

	    ViewGroup linearLayout = (ViewGroup) findViewById(R.id.button_row);
	    Button bt = new Button(this);
	    bt.setText("A Button");
	    bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
	    linearLayout.addView(bt);

	    btn_01.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    currentGuess += answerArray1[0];
			    answer.setText(currentGuess);
			    btn_01.setEnabled(false);
		    }
	    });

	    btn_02.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    currentGuess += answerArray1[1];
			    answer.setText(currentGuess);
			    btn_02.setEnabled(false);
		    }
	    });


	    btn_03.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    currentGuess += answerArray1[2];
			    answer.setText(currentGuess);
			    btn_03.setEnabled(false);
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
