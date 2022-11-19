package com.example.myappfirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity2 extends AppCompatActivity {
    Button buttonid2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        buttonid2 = findViewById(R.id.buttonid2);
        buttonid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
