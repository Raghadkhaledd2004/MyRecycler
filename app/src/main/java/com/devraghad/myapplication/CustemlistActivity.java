package com.devraghad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustemlistActivity extends AppCompatActivity {
    List<Product>productList;
    ListView listview1;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custemlist);
        listview1=findViewById(R.id.listview1);
        add_button=findViewById(R.id.add_button);
        productList=new ArrayList<>();
        productList.add(new Product("Apple",50,20,R.drawable.apple));
        productList.add(new Product("banana",50,20,R.drawable.banana));
        productList.add(new Product("strawberry",40,20,R.drawable.strawberry));
        productList.add(new Product("orange",20,10,R.drawable.orange));
        productList.add(new Product("cherry",70,50,R.drawable.cherry));

        CustomProductArrayAdapter customProductArrayAdapter=new CustomProductArrayAdapter(this,productList);
        listview1.setAdapter(customProductArrayAdapter);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productList.add(new Product("new product",40,50,R.drawable.cherry));
                customProductArrayAdapter.notifyDataSetChanged();
            }
        });

    }
}