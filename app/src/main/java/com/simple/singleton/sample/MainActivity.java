package com.simple.singleton.sample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.simple.singleton.R;

public class MainActivity extends AppCompatActivity {

    private EditText bookNameEdt,priceEdt,authorEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookNameEdt = (EditText) findViewById(R.id.bookNameEdt);
        priceEdt = (EditText) findViewById(R.id.priceEdt);
        authorEdt = (EditText) findViewById(R.id.authorEdt);

    }

    public void addClick(View view) {

        String bookName = bookNameEdt.getText().toString().trim();
        if (TextUtils.isEmpty(bookName)){
            Toast.makeText(this,"书名不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        String price = priceEdt.getText().toString().trim();
        if (TextUtils.isEmpty(price)){
            Toast.makeText(this,"价格不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        float priceFloat;
        try{
            priceFloat = Float.parseFloat(price);
        }catch (Exception e){
            Toast.makeText(this,"价格输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
            return;
        }

        String author = authorEdt.getText().toString().trim();
        if (TextUtils.isEmpty(author)){
            Toast.makeText(this,"作者不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put("name", bookName);
        values.put("price", priceFloat);
        values.put("author", author);
        DefineSQLiteOpenHelper openHelper = DefineSQLiteOpenHelper.getSingleton(this);
        SQLiteDatabase database = openHelper.getReadableDatabase();
        database.insert("Book", null, values);

        Toast.makeText(this,"添加成功！",Toast.LENGTH_SHORT).show();
        bookNameEdt.setText("");
        priceEdt.setText("");
        authorEdt.setText("");

    }

    public void selectClick(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }
}
