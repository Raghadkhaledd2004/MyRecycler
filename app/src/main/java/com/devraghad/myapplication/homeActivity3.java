package com.devraghad.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class homeActivity3 extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECT_IMAGE_GALLERY = 876;
    private static final int SELECT_IMAGE_GALLERY2 = 8766;
    TextView displayDatatext;
    String email,mobile;
    Button button_Webview ,button_Contat,button_GooglMap ,button_Email , button_messages ,button_saveContat , button_mobile , button_gallery , button_gallery2 , editName;
    ImageView imageView3 , imageView4;
    private GloblUser GlobalUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);//اهم سطر الذي يربط ملف ال xml  ب ملف الجافا
        editName=findViewById(R.id.editName);
        button_Webview = findViewById(R.id.button_Webview);
        button_Contat = findViewById(R.id.button_Contat);
        button_GooglMap = findViewById(R.id.button_GooglMap);
        button_Email = findViewById(R.id.button_Email);
        button_messages = findViewById(R.id.button_messages);
        button_saveContat = findViewById(R.id.button_saveContat);
        button_mobile = findViewById(R.id.button_mobile);
        button_gallery = findViewById(R.id.button_gallery);
        imageView3 = findViewById(R.id.imageView3);
        button_gallery2 = findViewById(R.id.button_gallery2);
         imageView4 = findViewById(R.id.imageView4);
        button_Webview.setOnClickListener(this);
        button_Contat.setOnClickListener(this);
        button_GooglMap.setOnClickListener(this);
        button_Email.setOnClickListener(this);
        button_messages.setOnClickListener(this);
        button_saveContat.setOnClickListener(this);
        button_mobile.setOnClickListener(this);
        button_gallery.setOnClickListener(this);
        button_gallery2.setOnClickListener(this);
        editName.setOnClickListener(this);
        imageView4.setOnClickListener(this);

         GlobalUser = (GloblUser) getApplicationContext();
        String nameUesr = GlobalUser.getName();
        String emailUesr = GlobalUser.getEmail();
        displayDatatext.setText(nameUesr);
        displayDatatext = findViewById(R.id.displayDatatext);
        String name = getIntent().getStringExtra("Name");
        email = getIntent().getStringExtra("Email");
        mobile = getIntent().getStringExtra("mobile");
        String password = getIntent().getStringExtra("password");
        int age = getIntent().getIntExtra("Age", 18);
        boolean isAgreed = getIntent().getBooleanExtra("policy", false);

        // displayDatatext.setText("Name "+name+"+\n"+"email"+email+"\n"+"mobile"+mobile+"\n"+"password"+password+"\n"+
        //    "Age"+age+"\n"+"Agree on policy"+isAgreed
        // );



        ActivityResultLauncher<Intent> openeActive = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==111){
                        if(result.getData()!=null&& result.getData().getStringExtra("name")!=null){
                            GlobalUser.setName(name);
                            displayDatatext.setText(name);
                        }
                    }
                    }
                });




    }


    //تشغيل ال  ونفتح اكتيفيتي gallary
    ActivityResultLauncher<Intent> intentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getData()!=null && result.getData().getData()!=null)
                imageView3.setImageURI(result.getData().getData());
        }
    });

    ActivityResultLauncher < String > galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            if (result != null) {
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result);
                    imageView3.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    });

    @Override
    public void onClick(View v) {
         switch (v.getId()){
           /*  case   R.id.button_Webview:
                 goWebview();
                 break;*/

             case   R.id.button_Contat:
                 goContat();
                 break;

             case   R.id.button_GooglMap:
                 goGooglMap();
                 break;

             case   R.id.button_Email:
                 goEmail();
                 break;

             case   R.id.button_messages:
                 goMessages();
                 break;

             case   R.id.button_saveContat:
                 saveContat();
                 break;

             case   R.id.button_mobile:
                 goToMobile();
                 break;

             case   R.id.button_gallery:
                 goTogalleryWithLanucherString();
                 break;

             case   R.id.imageView3:
                 goToimage();
                 break;

             case   R.id.button_gallery2:
                 goTogalleryintent();
                 break;

             case   R.id.editName:
                 openeditnameActivity();
                 break;


         }
    }

    private void openeditnameActivity() {
        Intent intent=new Intent(this,EditNameActivity.class);
        intent.putExtra("name", GlobalUser.getName());
        intentLauncher.launch(intent);
    }

    private void goTogalleryintent() {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

    }

    private void goTogalleryWithLanucherString() {
        galleryLauncher.launch("image/*");

    }

    private void goTogallery2() {
        Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        // Intent.createChooser(intent,"Select image");
        startActivityForResult(intent,SELECT_IMAGE_GALLERY2 );


    }

    private void goToimage() {
    }

    private void goTogallery() {
        Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        Intent.createChooser(intent,"select image");
       // Intent.createChooser(intent,"Select image");
        startActivityForResult(intent,SELECT_IMAGE_GALLERY );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == SELECT_IMAGE_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    imageView3.setImageBitmap(bitmap);
                } catch (IOException exception) {
                    exception.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Somthing worng!", Toast.LENGTH_LONG).show();
                }
            } else if (resultCode == Activity.RESULT_CANCELED) ;
            Toast.makeText(getApplicationContext(), "you didn't select anyting", Toast.LENGTH_LONG).show();
            }

    }


    private void goToMobile() {
        Intent intent= new Intent(Intent.ACTION_DEFAULT);
        intent.setData(Uri.parse("tal:mobile"));
        startActivity(intent);

    }

    private void saveContat() {
        Intent intent= new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME,"Raghad");
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,"0598277487");
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL,"Raghad");
        startActivity(intent);

    }

    private void goMessages() {
        Intent intent= new Intent(Intent.ACTION_DEFAULT);

    }

    private void goEmail() {
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tal:email"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Apply of Android");
        intent.putExtra(Intent.EXTRA_TEXT," Android Divloper");
        startActivity(intent);
    }

    private void goGooglMap() {
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(""));
        startActivity(intent);

    }

    private void goContat() {
        Intent intent= new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);

    }

   /* private void goWebview() {
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse());
        startActivity(intent);

    }*/
}