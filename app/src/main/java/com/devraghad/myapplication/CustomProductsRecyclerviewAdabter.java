package com.devraghad.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomProductsRecyclerviewAdabter extends RecyclerView.Adapter<CustomProductsRecyclerviewAdabter.ProductViewHolder> {
    Context context;
    ArrayList<Product>productArrayList;
    public CustomProductsRecyclerviewAdabter(Context context, ArrayList<Product>productArrayList) {
        this.context=context;
        this.productArrayList=productArrayList;
    }

    @NonNull
    @Override
    public CustomProductsRecyclerviewAdabter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product,parent,false);
        ProductViewHolder viewHolder=new ProductViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomProductsRecyclerviewAdabter.ProductViewHolder holder, int position) {
        Product product=productArrayList.get( holder.getAdapterPosition());
        if (product==null)
            return;
        holder.nameTv.setText(product.getName());
        holder.priceTv.setText(String.valueOf(product.getPrice()));
        holder.imageView.setImageResource(product.getImage());

        if(product.getPrevprice()>0){
            holder.prevPrice.setVisibility(View.VISIBLE);
            holder.nameTv.setText(String.valueOf (product.getPrevprice()));
        }else
            holder.prevPrice.setVisibility(View.GONE);



        holder.deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemRemoved(holder.getAdapterPosition());
               // remove(product);
                //notifyDataSetChanged();
            }
        });



        holder.updateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 notifyItemChanged(holder.getAdapterPosition());
                product.setPrice(55);
             }
        });


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( context,productDetailsActivity.class);
                intent.putExtra("product",product);
               context.startActivity(intent);
            }
        });

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (productArrayList==null)
            return 0;
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,deleteTv,updateTv;
        TextView nameTv,priceTv,prevPrice;
        ConstraintLayout layout;
        public ProductViewHolder(View view){
            super(view);
            imageView=view.findViewById(R.id.product_iv);
            nameTv=view.findViewById(R.id.product_name_tv);
            priceTv=view.findViewById(R.id.price_tv);
            prevPrice=view.findViewById(R.id.prev_price_tv);
            deleteTv =view.findViewById(R.id.delet_iv);
            updateTv =view.findViewById(R.id.update_iv);
            layout=view.findViewById(R.id.layout);

        }

    }
}
