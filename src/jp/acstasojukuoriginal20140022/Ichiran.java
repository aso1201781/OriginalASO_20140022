package jp.acstasojukuoriginal20140022;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
public class Ichiran extends Activity  implements
View.OnClickListener,AdapterView.OnItemClickListener
{
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	int selectedID = -1;
	int lastPosition = -1;
	
	
	

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
		ListView lstHitokoto = (ListView)findViewById(R.id.lst1);
		
		btn_back.setOnClickListener(this);
		btn_deleate.setOnClickListener(this);
		
		lstHitokoto.setOnItemClickListener(this);
		
		this.setDBValuetoList(lstHitokoto);
	}
	private void setDBValuetoList(ListView lstHitokoto){
		SQLiteCursor cursor = null;
		if(sdb==null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			Log.e("ERROR", e.toString());
		}
		cursor = this.helper.selectHitokotoList(sdb);
		
		int db_layout = android.R.layout.simple_list_item_activated_1;
		String[]from = {"phrase"};
		int[] to = new int[]{android.R.id.text1};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);
		lstHitokoto.setAdapter(adapter);
	}
		
	public void deleteFromHitokoto(int id){
		if(sdb == null){
				helper = new MySQLiteOpenHelper(getApplicationContext());
		}try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			Log.e("ERROR", e.toString());
		}
		this.helper.deleteHItokoto(sdb,id);
	}
	
	
	
	
	
	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){
		case R.id.deleate:
			if(this.selectedID != -1){
				this.deleteFromHitokoto(this.selectedID);
				ListView lstHitokoto = (ListView)findViewById(R.id.lst1);
				this.setDBValuetoList(lstHitokoto);
				this.selectedID = -1;
				this.lastPosition = -1;
			}
			else{
				Toast.makeText(Ichiran.this,"削除する行を選んでください",Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.back:
				finish();
				//intent = new Intent(Ichiran.this, MainActivity.class);
				//startActivity(intent);
				break;
			
	   }
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.selectedID!=-1){
			parent.getChildAt(this.lastPosition).setBackgroundColor(0);
		}
		
		view.setBackgroundColor(android.graphics.Color.LTGRAY);
		
		SQLiteCursor cursor = (SQLiteCursor)parent.getItemAtPosition(position);
		this.selectedID = cursor.getInt(cursor.getColumnIndex("_id"));
		this.lastPosition = position;
		
			
		}
		
		
	}

