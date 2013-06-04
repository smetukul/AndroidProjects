	package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipMainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_main);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_main, menu);
		return true;
	}
	
	private void CalculateTip( double d )
	{
		TextView tip = (TextView)findViewById(R.id.TextView01);
		EditText amount = (EditText)findViewById(R.id.amount);

		try
		{
			float famount = Float.valueOf(amount.getText().toString());
			if(famount >= 0)
			{
				float tipamount = (float) ((float)(famount) * d);
			
				String roundtip = String.format("$%.2f", tipamount);
				tip.setText(roundtip);
			}
			else
				tip.setText("$0");
		}
		catch(Exception ex)
		{
			if(amount.getText().toString().length() == 0)
			{
				tip.setText("Amount is Empty");
				//Toast.makeText(amount.getContext()," Amount is Empty ",Toast.LENGTH_LONG).show();
			}
			else
				tip.setText("Amount entered is invalid");
		}
	}

	public void Tip10(View view) {
		CalculateTip(0.1);		
	}

	public void Tip15(View view) {
		CalculateTip(0.15);
	}

	public void Tip20(View view) {
		CalculateTip(0.20);
	}

}