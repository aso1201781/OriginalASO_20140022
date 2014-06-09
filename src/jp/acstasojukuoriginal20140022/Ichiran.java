package jp.acstasojukuoriginal20140022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ichiran extends Activity  implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ichiran);	
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		
		Button btn_back = (Button)findViewById(R.id.back);
		btn_back.setOnClickListener(this);
		Button btn_deleate = (Button)findViewById(R.id.deleate);
		btn_deleate.setOnClickListener(this);	
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){
			case R.id.back:
				intent = new Intent(Ichiran.this, MainActivity.class);
				startActivity(intent);
				break;
			case R.id.deleate:
			
				break;
	   }
	}
}
