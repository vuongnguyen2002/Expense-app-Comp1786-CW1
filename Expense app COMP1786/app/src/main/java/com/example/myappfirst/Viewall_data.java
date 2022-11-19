package com.example.myappfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;



import java.util.List;

public class Viewall_data extends AppCompatActivity {
    Button buttonview;

    ListView listviewdata;
    ArrayAdapter personAdapter;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall_data);
        buttonview = findViewById(R.id.buttonVIEW);

        DatabaseHelpertrip databaseHelpertrip = new DatabaseHelpertrip(Viewall_data.this);

        listviewdata =findViewById(R.id.lv_viewlist);

        buttonview.setOnClickListener((v) -> {
           /* List<Listperson> everyone = databaseHelpertrip.geteveryone();*/
            /*Toast.makeText(Viewall_data.this, everyone.toString(), Toast.LENGTH_SHORT).show();*/
           /* Showviewtrip(databaseHelpertrip);*/
            personAdapter = new ArrayAdapter<Listperson>(Viewall_data.this, android.R.layout.simple_list_item_1, databaseHelpertrip.geteveryone());
            listviewdata.setAdapter(personAdapter);
            
        });
        listviewdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Listperson clickDelete = (Listperson) parent.getItemAtPosition(position);
                personAdapter = new ArrayAdapter<Listperson>(Viewall_data.this, android.R.layout.simple_list_item_1, databaseHelpertrip.geteveryone());
                listviewdata.setAdapter(personAdapter);
                databaseHelpertrip.buttondelete(clickDelete);
                Toast.makeText(Viewall_data.this, "Deleted "+clickDelete.toString(), Toast.LENGTH_SHORT).show();


            }
        });


    }




}