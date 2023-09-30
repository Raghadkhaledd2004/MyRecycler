package com.devraghad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class productDetailsActivity extends AppCompatActivity {
    TextView product_name_tv,price_tv,prev_price_tv;
    ImageView product_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        product_name_tv=findViewById(R.id.product_name_tv);
        price_tv=findViewById(R.id.price_tv);
        prev_price_tv=findViewById(R.id.prev_price_tv);
        Product Product=getIntent().getParcelableExtra("Product");
        product_name_tv.setText(Product.getName());
        product_iv=findViewById(R.id.product_iv);
        product_iv.setImageResource(Product.getImage());
        price_tv.setText(String.valueOf( Product.getName()));
         if (Product.getPrevprice()>0){
            prev_price_tv.setText(String.valueOf(Product.getPrevprice()));


        }else {
             prev_price_tv.setVisibility(View.GONE);

         }

    }
}