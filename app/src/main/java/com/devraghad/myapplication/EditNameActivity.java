package com.devraghad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devraghad.myapplication.databinding.ActivityEditNameBinding;


public class EditNameActivity extends AppCompatActivity {
    ActivityEditNameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditNameBinding.inflate(getLayoutInflater());
        setContentView( binding.getRoot());
       String name= getIntent().getStringExtra("name");
         binding.nameEdittext.setText(name);
        binding.savBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //انا هان حددت الداتا الي بدها ترجع
                Intent intent=new Intent();
                intent.putExtra("name", binding.nameEdittext.getText().toString());
                setResult(111,intent);
                //وهاي بتنهي الاكتفيتي الي انا فيها
                finish();

            }
        });

    }
}