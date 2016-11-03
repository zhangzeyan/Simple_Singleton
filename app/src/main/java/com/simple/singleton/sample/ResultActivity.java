package com.simple.singleton.sample;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.simple.singleton.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzeyan on 16/11/3.
 */
public class ResultActivity extends Activity{

    private ListView listView;
    private MyBaseAdapter adapter;
    private List<BookModel> bookModels;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bookModels = new ArrayList<>();
        listView = (android.widget.ListView) findViewById(R.id.listView);
        adapter = new MyBaseAdapter(this,bookModels);
        listView.setAdapter(adapter);

        DefineSQLiteOpenHelper openHelper = DefineSQLiteOpenHelper.getSingleton(this);
        SQLiteDatabase database = openHelper.getReadableDatabase();

        Cursor cursor = database.query("Book",new String[]{"name","price","author"},null,null,null,null,null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String price = cursor.getFloat(cursor.getColumnIndex("price"))+"";
            String author = cursor.getString(cursor.getColumnIndex("author"));

            BookModel bookModel = new BookModel(name,price,author);
            bookModels.add(bookModel);
        }

        adapter.notifyDataSetChanged();


    }
}
