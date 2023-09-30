package com.devraghad.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.devraghad.myapplication.databinding.ActivityListviewBinding;
import com.devraghad.myapplication.databinding.ActivityMainActivitylistttttBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivitylisttttt extends AppCompatActivity {
   ActivityMainActivitylistttttBinding binding;
    ArrayAdapter<String> arrayAdapter;
    AlertDialog  builder;
    ArrayList  arrayList;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityMainActivitylistttttBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());
          arrayList = new ArrayList<String>();
          arrayAdapter = new ArrayAdapter(this, R.layout.layout_listttttt, R.id.nametv, arrayList);
          binding.listview.setAdapter(arrayAdapter);
          binding.button2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String names = binding.editTextPersonName4.getText().toString();
                  arrayList.add(names);
                  binding.listview.setAdapter(arrayAdapter);
                  arrayAdapter.notifyDataSetChanged();
              }
          });

          binding.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
              @Override
              public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    showraghad(i);
                  return true;

              }
          });
      }

          void showraghad (int v ){
              AlertDialog.Builder builder=new AlertDialog.Builder(this);
             builder.setTitle("Delete");
             builder.setMessage("Are you sure you want to delete this item?");
             builder.setPositiveButton("yes",new  DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     arrayList.remove(v);
                     arrayAdapter.notifyDataSetChanged();
                     dialogInterface.dismiss();



                 }
             });
             builder.setNegativeButton("No",new  DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                       dialogInterface.dismiss();
                 }
             });

            builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

              builder.create().show();

           //   التنتين نفس الاشي
               //AlertDialog alertDialog=builder.create();
             // alertDialog.show();

         }




}