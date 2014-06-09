package jp.acstasojukuoriginal20140022;

import android.app.Activity;
import android.content.Intent;
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
		Button btn_mente = (Button)findViewById(R.id.mente);
		btn_mente.setOnClickListener(this);
		Button btn_touroku = (Button)findViewById(R.id.touroku);
		btn_touroku.setOnClickListener(this);
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
		Intent intent = null;
		switch(v.getId()){
			case R.id.deleate:
				break;
			case R.id.mente:
				intent = new Intent(MainActivity.this, Ichiran.class);
				startActivity(intent);
				break;
			case R.id.btn3:	
				intent = new Intent(MainActivity.this, Tourokuhyouji.class);
				startActivity(intent);
				break;
		}	
	}	
}

