package com.devraghad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView xx,fnameTextview,lastTextview;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          xx= findViewById(R.id.textView);
       // xx.setText("welcom to our App");
        xx.setTextSize(18f);
        xx.setBackgroundColor(getResources().getColor(R.color.purple_200));
        xx.setText(getString(R.string.app_name));
          iv=findViewById(R.id.imageView);
          fnameTextview=findViewById(R.id.textView2);
          lastTextview=findViewById(R.id.textView3);
        EditText fNameEdittext=findViewById(R.id.name);
        //fNameEdittext.setText("Raghad");
        EditText lNameEdittext=findViewById(R.id.name);
       // lNameEdittext.setText("abu khater");
        EditText mobileEdittext=findViewById(R.id.email);
        EditText emailEdittext=findViewById(R.id.Email_et);
        RadioButton maleRB=findViewById(R.id.radioButton);
        RadioButton femalerb=findViewById(R.id.radioButton2);
        TextView displaydataTextview=findViewById(R.id.displayadta);
        Button saveBatton=findViewById(R.id.button);
        saveBatton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String fnamevalue= fNameEdittext.getText().toString();
              String lnamevalue= lNameEdittext.getText().toString();


              displaydataTextview.setText("your name is "+fnamevalue+" "+lnamevalue+"\n");
            }
        });





    }
}