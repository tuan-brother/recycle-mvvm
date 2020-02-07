package com.example.recycleview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleview.R;
import com.example.recycleview.databinding.ActivityManyInfoBinding;
import com.example.recycleview.model.Book;

public class ManyInfo extends AppCompatActivity {
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_info);
        //anhxa();
        Bundle extra=getIntent().getBundleExtra("bundle");
        String a=extra.getString("title");
        String b=extra.getString("author");
        String c=extra.getString("price");
        String d=extra.getString("descrip");
        Integer e=extra.getInt("image");
        ActivityManyInfoBinding biding= DataBindingUtil.setContentView(this,R.layout.activity_many_info);
        book=new Book(a,b,c,d,e);
        biding.setBook(book);
    }

}
