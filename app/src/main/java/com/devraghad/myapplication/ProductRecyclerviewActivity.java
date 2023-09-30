package com.devraghad.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ProductRecyclerviewActivity extends AppCompatActivity implements onCateogryClickListener {

    private ArrayList<Product> productList;
    RecyclerView recyclerview,categories_recyclerview;
    Button add_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_recyclerview);
        recyclerview=findViewById(R.id.recyclerview);
        add_button=findViewById(R.id.add_button);
        productList=new ArrayList<>();
       // productList.add(new Product("Apple",50,20,R.drawable.apple));
        productList.add(new Product("banana",50,20,R.drawable.banana));
        productList.add(new Product("strawberry",40,20,R.drawable.strawberry));
        productList.add(new Product("orange",20,10,R.drawable.orange));
        productList.add(new Product("cherry",70,50,R.drawable.cherry));

        CustomProductsRecyclerviewAdabter customProductsRecyclerviewAdabter=new CustomProductsRecyclerviewAdabter(this,productList);
        recyclerview.setAdapter(customProductsRecyclerviewAdabter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productList.add(new Product("cherry",70,50,R.drawable.cherry));
                customProductsRecyclerviewAdabter.notifyItemInserted(productList.size()-1);

            }
        });

        ArrayList<Category>categoryArrayList=new ArrayList<>();
        categoryArrayList.add(new Category(1,"Vegetabels"));
        categoryArrayList.add(new Category(2,"Fruits"));
        categoryArrayList.add(new Category(3,"Drinks"));
        CategoriesRecyclerviewAdapter categoriesRecyclerviewAdapter=new CategoriesRecyclerviewAdapter(categoryArrayList,this);
        categories_recyclerview=findViewById(R.id.categories_recyclerview);
        categories_recyclerview.setAdapter(categoriesRecyclerviewAdapter);
        categories_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public void onCategoryCliched(Category category) {
        ArrayList<Product>products=new ArrayList<>();
        if (category.getId()==1){
            products=getVeg();

        }else
        if (category.getId()==2){
            products=getFruits();

        }else
        if (category.getId()==3){
            products=getdrinks();

        }
        CustomProductsRecyclerviewAdabter customProductsRecyclerviewAdabter=new CustomProductsRecyclerviewAdabter(getApplicationContext(),products);
        recyclerview.setAdapter(customProductsRecyclerviewAdabter);

    }

    public ArrayList<Product>getFruits(){
     ArrayList<Product> productList=new ArrayList<>();
        productList.add(new Product("Apple",50,20,R.drawable.apple));
        productList.add(new Product("banana",50,20,R.drawable.banana));
        productList.add(new Product("strawberry",40,20,R.drawable.strawberry));
        productList.add(new Product("orange",20,10,R.drawable.orange));
        productList.add(new Product("cherry",70,50,R.drawable.cherry));
        return productList;
    }


    public ArrayList<Product>getVeg(){
        ArrayList<Product> productList=new ArrayList<>();
        productList.add(new Product("tomatoes",50,20,R.drawable.apple));
        productList.add(new Product("carrot",50,20,R.drawable.banana));
        productList.add(new Product("potato",40,20,R.drawable.strawberry));
        return productList;
    }



    public ArrayList<Product>getdrinks(){
        ArrayList<Product> productList=new ArrayList<>();
        productList.add(new Product("coffee",50,20,R.drawable.apple));
        productList.add(new Product("milk",50,20,R.drawable.banana));
        return productList;
    }
}