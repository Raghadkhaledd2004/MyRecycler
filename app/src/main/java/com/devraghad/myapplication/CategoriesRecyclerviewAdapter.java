package com.devraghad.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoriesRecyclerviewAdapter extends RecyclerView.Adapter <CategoriesRecyclerviewAdapter.CategoryViewHolder>{
    ArrayList<Category>categoryArrayList;
    onCateogryClickListener onCateogryClickListener;
    public CategoriesRecyclerviewAdapter(ArrayList<Category>categoryArrayList,onCateogryClickListener onCateogryClickListener){
        this.categoryArrayList=categoryArrayList;
        this.onCateogryClickListener=onCateogryClickListener;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category,parent,false);
        CategoryViewHolder categoryViewHolder=new CategoryViewHolder(view);
        return categoryViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category=categoryArrayList.get(holder.getAdapterPosition());
        if(category==null)
            return;
        holder.titletv.setText(category.getName());
        holder.titletv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCateogryClickListener.onCategoryCliched(category);
            }
        });
    }


    @Override
    public int getItemCount() {
        if(categoryArrayList==null)
            return 0;
        return categoryArrayList.size();
    }



    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private   TextView titletv;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            titletv=itemView.findViewById(R.id.title_tv);
        }
    }
}
