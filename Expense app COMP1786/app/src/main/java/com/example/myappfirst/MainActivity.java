package com.example.myappfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        MaterialButton loginbutton=(MaterialButton) findViewById(R.id.loginbutton);
        LoadingAlert loadingAlert =new LoadingAlert(MainActivity.this);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("")&&password.getText().toString().equals("")){
                    //correct
                    Toast.makeText(MainActivity.this,"Access",Toast.LENGTH_SHORT).show();
                    Intent startIntent =new Intent(getApplicationContext(),SecondActivity2.class);
                    loadingAlert.startAlertdialog();
                    /*startIntent.putExtra("org.menthod.quicklaucher.Something ","Xin chao");*/
                    startActivity(startIntent);


                }else
                    Toast.makeText(MainActivity.this,"Failed !!!",Toast.LENGTH_SHORT).show();
            }


        });
        ImageView facebookbtn = (ImageView) findViewById(R.id.facebookbtn);
        facebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebook ="https://www.facebook.com/";
                Uri myaddress =Uri.parse(facebook);
                Intent gotofacebook =new Intent(Intent.ACTION_VIEW,myaddress);
                if (gotofacebook.resolveActivity(getPackageManager())!=null) {
                    startActivity(gotofacebook);
                }

            }
        });


    }
}