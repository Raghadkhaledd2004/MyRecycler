package com.devraghad.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity2 extends AppCompatActivity {
   EditText editTextTextPersonName,Email,mobile,password;
    RadioButton radioButton3,radioButton4,radio_1,radio_4;
    TextView displaydataTextview;
    CheckBox chec_box;
    RadioGroup radioGroup2;
     BreakIterator tv_displaydata;
    Button saveBatton ,clear_btn ;
    int i=3;
    private String namevalue,emailvalue,mobilvalue,passvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("MainActivity2tt" , i+"");  //3
        i = 5 ;
        Log.d("MainActivity2tt" , i+"");  //5
        int i =8;
        Log.d("MainActivity2tt" , i+"");  //8
        printOldI();  //5

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        Email = findViewById(R.id.Email);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        MyTextWatcher NameTextWatcher=new MyTextWatcher(R.id.editTextTextPersonName);
        MyTextWatcher EmailTextWatcher=new MyTextWatcher(R.id.Email);
        MyTextWatcher mobileTextWatcher=new MyTextWatcher(R.id.mobile);
        editTextTextPersonName.addTextChangedListener(NameTextWatcher);
        Email.addTextChangedListener(EmailTextWatcher);
        mobile.addTextChangedListener(mobileTextWatcher);
          radioButton3 = findViewById(R.id.radioButton3);
        radioButton3.isChecked();
          radioButton4 = findViewById(R.id.radioButton4);
        radioButton4.isChecked();
          radio_1 = findViewById(R.id.radio_1);
        radio_1.isChecked();
          radio_4 = findViewById(R.id.radio_4);
        radio_4.isChecked();
        displaydataTextview = findViewById(R.id.displayDatatext);
        chec_box =findViewById(R.id.chec_box);
        saveBatton = findViewById(R.id.button3);
        saveBatton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name_editText=editTextTextPersonName.getText().toString();
               String email_editText=Email.getText().toString();
               String Mobile_editText=mobile.getText().toString();
               String password_editText=password.getText().toString();

            }
        });


        chec_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                saveBatton.setEnabled(b);
                String text="you Agreed on Privacy policy";
                if(!b){
                    text="you didnt Agreed on Privacy policy";
                }
                Toast.makeText(MainActivity2.this,text,Toast.LENGTH_LONG).show();
            }
        });

        clear_btn =findViewById(R.id.clear_btn);
        radioGroup2=findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton3:
                        Toast.makeText(MainActivity2.this,"0-10",Toast.LENGTH_LONG);
                        clear_btn.setVisibility(View.GONE);
                        break;

                        case R.id.radioButton4:
                        Toast.makeText(MainActivity2.this,"10-20",Toast.LENGTH_LONG);
                        clear_btn.setVisibility(View.VISIBLE);
                        break;

                    case R.id.radio_1:
                        Toast.makeText(MainActivity2.this,"20-60",Toast.LENGTH_LONG);
                        clear_btn.setVisibility(View.VISIBLE);
                        break;

                    case R.id.radio_4:
                        Toast.makeText(MainActivity2.this,"60-100",Toast.LENGTH_LONG);
                        clear_btn.setVisibility(View.VISIBLE);
                        break;



                }
            }
        });
         saveBatton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

        
        Button clearbutton = findViewById(R.id.clear_btn);
        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearViews();
            }

        });

    }


    private void goTohome() {

        final GloblUser globalUser= (GloblUser) getApplicationContext();
        globalUser.setName (editTextTextPersonName.getText().toString());
        globalUser.setEmail( Email.getText().toString());
        Intent xx = new Intent(MainActivity2.this, ListviewActivity.class);
        xx.putExtra("Name",editTextTextPersonName.getText().toString());
        xx.putExtra("Email",Email.getText().toString());
        xx.putExtra("mobile",mobile.getText().toString());
        xx.putExtra("password",password.getText().toString());
        xx.putExtra("Age",30);
        xx.putExtra("policy",chec_box.isChecked());
        startActivity(xx);

    }
    private void printText() {tv_displaydata.setText((String) getText(R.string.app_name));}



    private void printOldI() {
        Log.d("MainActivity2tt old i " , i+"");

    }
    public void clearViews () {
        editTextTextPersonName.setText("");
        Email.setText("");
        mobile.setText("");
        password.setText("");
    }

    @SuppressLint("SuspiciousIndentation")
    public void getdatafromvieo() {
         namevalue = editTextTextPersonName.getText().toString();
         emailvalue = Email.getText().toString();
         mobilvalue = mobile.getText().toString();
         passvalue = password.getText().toString();
        int age = 0_10;
        if (radioButton4.isChecked()) {
            age = 10_20;
        } else if (radio_1.isChecked()) {
            age = 20_60;
        } else if (radio_4.isChecked())
            age = 60_100;
            if (!namevalue.isEmpty() && !emailvalue.isEmpty() && !mobilvalue.isEmpty() && !passvalue.isEmpty() &&
                    (radioButton3.isChecked()) || (radioButton4.isChecked()) || (radio_1.isChecked()) || (radio_4.isChecked())) {

                tv_displaydata.setText("Your name is " + editTextTextPersonName + " " + "\n" + "email is " + Email + " " + "\n" +
                        "Mobile is " + mobile + " " + "\n" + "password is " + password + "\n" + "age is " + age);
            } else {
                Toast.makeText(MainActivity2.this, "Please fill your data", Toast.LENGTH_LONG);

                  goTohome();

            }


        displayText(namevalue, emailvalue, mobilvalue, passvalue);
    }

    private void displayText(String namevalue, String emailvalue, String mobilvalue, String passvalue) {
        displaydataTextview.setText("your name is " + namevalue + "\n" + " Email is " + emailvalue + "\n" + "mobile is" + mobilvalue + "\n" + "your password is" + passvalue
                + "\n" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity2tt " , i+"onStart");
        Toast.makeText(MainActivity2.this,"onStart",Toast.LENGTH_LONG);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity2tt " , i+"onResume");
        Toast.makeText(MainActivity2.this,"onResume",Toast.LENGTH_LONG);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity2tt " , i+"onSaveInstanceState");
        outState.putString("Name",editTextTextPersonName.getText().toString());
        outState.putString("email",Email.getText().toString());
        outState.putString("Mobile",mobile.getText().toString());
        outState.putString("password",password.getText().toString());

    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity2tt " , i+"onRestoreInstanceState");
        namevalue = savedInstanceState.getString("Name");
         emailvalue = savedInstanceState.getString("email");
         mobilvalue = savedInstanceState.getString("Mobile");
         passvalue = savedInstanceState.getString("password");

        displaydataTextview.setText("your name is " + namevalue+ "\n" + " Email is " + emailvalue + "\n" + "mobile is" + mobilvalue + "\n" + "your password is" + passvalue
                + "\n");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public class MyTextWatcher<view> implements TextWatcher {
            int view ;
            public MyTextWatcher(int viewId) {
                this.view=viewId;
            }


            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (view==Email.getId()){
                    if(mobile.length()>=9){
                        mobile.setError(null);

                  //  mobile.setBackgroundColor(getResources().getColor(R.color.white));
                }else {
                        mobile.setError("Please enter 9 digits");
                        // mobile.setBackground(getResources().getDrawable(R.drawable.error);
                        //   mobile.setBackgroundColor(getResources().getColor(R.color.red));
                    }}

               else if (view==editTextTextPersonName.getId()) {
                    if (editTextTextPersonName.length() >= 2) {
                        editTextTextPersonName.setError(null);
                    } else {
                        editTextTextPersonName.setError("Please enter at least 2 digits");

                    }
                }
                 else if (view == Email.getId()) {
                        if (Email.getText().toString().contains("@")) {
                            Email.setVisibility(View.GONE);
                        } else {
                            Email.setVisibility(View.VISIBLE);


                        }
                    }

        }




    }



}

