package com.simple.singleton.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.simple.singleton.R;

import java.util.List;

/**
 * Created by zhangzeyan on 16/11/3.
 */

public class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private List<BookModel> bookModels;

    public MyBaseAdapter(Context context,List<BookModel> bookModels) {
        this.context = context;
        this.bookModels = bookModels;
    }

    @Override
    public int getCount() {
        return bookModels.size();
    }

    @Override
    public Object getItem(int i) {
        return bookModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final BookModel bookModel = bookModels.get(position);
        Holder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_result_item,null);
            holder = new Holder();
            holder.bookNameTxt = (TextView) convertView.findViewById(R.id.bookNameTxt);
            holder.priceTxt = (TextView) convertView.findViewById(R.id.priceTxt);
            holder.authorTxt = (TextView) convertView.findViewById(R.id.authorTxt);
            holder.deleteTxt = (TextView) convertView.findViewById(R.id.deleteTxt);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.bookNameTxt.setText(bookModel.getName());
        holder.priceTxt.setText(bookModel.getPrice());
        holder.authorTxt.setText(bookModel.getAuthor());
        holder.deleteTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DefineSQLiteOpenHelper openHelper = DefineSQLiteOpenHelper.getSingleton(context);
                SQLiteDatabase database = openHelper.getReadableDatabase();
                database.delete("Book","name = ?",new String[]{bookModel.getName()});
                bookModels.remove(bookModel);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class Holder{
        public TextView bookNameTxt;
        public TextView priceTxt;
        public TextView authorTxt;
        public TextView deleteTxt;
    }
}
