package jp.acstasojukuoriginal20140022;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements
View.OnClickListener
{

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btn1 = (Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		Button btn2 = (Button)findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		Button btn3 = (Button)findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
			case R.id.btn1:
			
			case R.id.btn2:
				
			case R.id.btn3:	
		}
			
		
		
		}
		
		
		
	}

