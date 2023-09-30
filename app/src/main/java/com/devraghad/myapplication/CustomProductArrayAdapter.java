package com.devraghad.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomProductArrayAdapter extends ArrayAdapter<Product> {

    public CustomProductArrayAdapter(@NonNull Context context,   @NonNull List<Product> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        view= LayoutInflater.from(getContext()).inflate(R.layout.list_item_product,parent,false);
        ImageView imageView=view.findViewById(R.id.product_iv);
        TextView nameTv=view.findViewById(R.id.product_name_tv);
        TextView priceTv=view.findViewById(R.id.price_tv);
        TextView prevPrice=view.findViewById(R.id.prev_price_tv);
        ImageView deleteTv =view.findViewById(R.id.delet_iv);
        ImageView updateTv =view.findViewById(R.id.update_iv);
        ConstraintLayout layout=view.findViewById(R.id.layout);

        Product product= getItem(position);
        imageView.setImageResource(product.getImage());
        nameTv.setText(product.getName());
        nameTv.setText(String.valueOf (product.getPrice()));

        if(product.getPrevprice()>0){
            prevPrice.setVisibility(View.VISIBLE);
            nameTv.setText(String.valueOf (product.getPrevprice()));
         }else
             prevPrice.setVisibility(View.GONE);


        deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(product);
                notifyDataSetChanged();
            }
        });



        updateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setPrice(55);
                 notifyDataSetChanged();
            }
        });


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getContext(),productDetailsActivity.class);
                intent.putExtra("product",product);
                getContext().startActivity(intent);
            }
        });

        return view;
    }
}
