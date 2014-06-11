package jp.acstasojukuoriginal20140022;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements
View.OnClickListener
{
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		//登録ボタン変数にリスナーを登録
		Button btn_mente = (Button)findViewById(R.id.mente);
		btn_mente.setOnClickListener(this);
		
		//メンテボタン変数にリスナーを登録
		Button btn_touroku = (Button)findViewById(R.id.touroku);
		btn_touroku.setOnClickListener(this);
		
		//一言チェックボタン変数にリスナーを登録
		Button btn3 = (Button)findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		
		//クラスのフィールド変数がNULLなら、データベース空間オープン
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
		}
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
			case R.id.touroku:
				EditText etv = (EditText)findViewById(R.id.edttxt1);
				String inputMsg = etv.getText().toString();
				//inputMsgがnullでないかつ、空でない場合のみif文内を実行
				if(inputMsg!=null && !inputMsg.isEmpty()){
				//MySQLiteOpenHelperのインサートメソッドを呼び出し
				helper.insertHitokoto(sdb, inputMsg);
				}
				etv.setText("");
				break;
			case R.id.mente:
				intent = new Intent(MainActivity.this, Ichiran.class);
				startActivity(intent);
				break;
			case R.id.btn3:	
				String strHitokoto = helper.selectRandomHitokoto(sdb);
				
				
				intent = new Intent(MainActivity.this, Tourokuhyouji.class);
				intent.putExtra("hitokoto",strHitokoto);
				//次画面のアクティビティ起動
				startActivity(intent);
				break;
		}	
	}	
}

