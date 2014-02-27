package com.mstrblonde.simplewords.app;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
	Button btn_04;

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

	    for (int i = 1; i <= 3; i++) {
	    //int i = 1;
	    Button btn1;

		    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				    LinearLayout.LayoutParams.MATCH_PARENT,
				    LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);

		    LinearLayout button_layout = (LinearLayout) findViewById(R.id.button_grid_template);
		    button_layout.setOrientation(LinearLayout.HORIZONTAL);

		    Button btn = new Button(this);
		    btn.setLayoutParams(params);
		    btn.setId(i);
		    final int id_ = btn.getId();
		    btn.setText("button " + id_);
		    //btn.setBackgroundColor(Color.rgb(70, 80, 90));
			btn.setGravity(1);
		    button_layout.addView(btn);
		    btn1 = ((Button) findViewById(id_));
		    btn1.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View view) {
				    Toast.makeText(view.getContext(),
						    "Button clicked index = " + id_, Toast.LENGTH_SHORT)
						    .show();
			    }
		    });
	    }

	    /*LinearLayout button_layout = (LinearLayout) findViewById(R.id.button_grid_template);

	    button_layout.setOrientation(LinearLayout.HORIZONTAL);

	    Button btn_04 = new Button(this);
	    //btn_04.setId(4);
	    btn_04.setText("Button_text");

	    button_layout.addView(btn_04);

	    btn_04.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    currentGuess += answerArray1[0];
			    answer.setText(currentGuess);
			    //btn_04.setEnabled(false);
		    }
	    });*/


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
