package com.devraghad.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.devraghad.myapplication.databinding.ActivityListviewBinding;
import com.devraghad.myapplication.databinding.ActivitySpinnerBinding;

import java.util.ArrayList;

public class spinner_Activity extends AppCompatActivity implements MenuProvider {
    ActivitySpinnerBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding=ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        addMenuProvider(this);

        registerForContextMenu(binding.click);

        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Noor");
        arrayList.add("Omar");
        arrayList.add("Mohamad");
        arrayList.add("manar");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item ,arrayList);
        binding.spinner.setAdapter(arrayAdapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 Toast.makeText(getApplicationContext(), arrayList.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        registerForContextMenu(binding.click);
    }


    //بنروح خارج الاون كريييت برا يعني


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        binding.click.setText("you click on"+item.getTitle());
        return true;
    }




    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu2,menu);

    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_item_phone:
                Toast.makeText(this, "notfication", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_chat:
                Intent intent=new Intent(getApplicationContext(),list_view_item.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}
