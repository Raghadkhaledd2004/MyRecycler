package com.devraghad.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.devraghad.myapplication.databinding.ActivityListviewBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity  implements MenuProvider {
    ActivityListviewBinding binding;
    String selectedNameFromDialog;
   // ArrayAdapter arrayAdapter;
    //ArrayList<String>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // String[] studint=new String[]{"raghad","osama","roaa"};

        addMenuProvider(this);
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Noor");
        arrayList.add("Omar");
        arrayList.add("Mohamad");
        arrayList.add("manar");
         String[]studentsFromeRes=getResources().getStringArray(R.array.names);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.activity_list_view_item, R.id.nam_tv,arrayList );
        binding.listview.setAdapter(arrayAdapter); //الميثود التي تربط البيانات ب السبينر
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() { //لمن يعرض اللليست ويحط النص انه يعرضه لمن نضغط عليه
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(getApplicationContext(), ((TextView)view).getText(), Toast.LENGTH_LONG).show();
            }
        });

       binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //فش االاريي يضيف في العنصر التاسع هدا النص
              //  studentsFromeRes[7]="AAAa";
            arrayList.add("Farah");
            //ممكن هان نحدد وين مكان الاضافة
            // arrayList.add(1,"Farah");
                arrayAdapter.notifyDataSetChanged();
            }
        });

       binding.removeBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              // int removeIndix=0;
             /* if(removeIndix<arrayList.size()){
                  arrayList.remove(0);
                  arrayAdapter.notifyDataSetChanged();
              }*/
               showMaterialDialog();
           }
       });

    }
    //    { كيف اعرض ل اليوزر  ال list واخد قيمة } ال  Dialog
    void showMaterialDialog() {
        String[] namesList = getResources().getStringArray(R.array.names);
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Dialog")
                .setCancelable(false)
              // .setMessage("Massag for Material Dialog")
                .setSingleChoiceItems(namesList, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedNameFromDialog=namesList[i];

                    }
                })

                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        //هسا بنعمل في الواجهة تيكست بحيث انه لمن يختار الريديو يخزن القيمة .. التيكست اعملناه عشان لمن يضغط على الريديو يظهر الاسم مع الاسماء
                       binding.textName.setText(selectedNameFromDialog);
                    }
                })
                .show();







}


    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu2,menu);


    }


    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}