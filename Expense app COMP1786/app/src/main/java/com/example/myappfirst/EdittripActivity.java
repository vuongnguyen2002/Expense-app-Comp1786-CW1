package com.example.myappfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EdittripActivity extends AppCompatActivity {
    List<Listperson> personList;
    Button buttonedit1 ,buttoncanceledit;

    TextView Edit_NameText ,Edit_DateElectionText,Edit_ImageUrlimage;
    TextView Edit_trip4 ,Edit_description4,Edit_teammate4;
    int id;
    TextView Edit_Id1;
    Switch switchActive3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittrip);
        buttonedit1 =findViewById(R.id.buttonedit1);
        personList =Vuongappproject.getPersonList();
        buttoncanceledit =findViewById(R.id.buttoncanceledit1);
        Edit_NameText =findViewById(R.id.Edit_textNameEE1);
        Edit_DateElectionText =findViewById(R.id.Edit_Date1);
        Edit_ImageUrlimage=findViewById(R.id.Edit_pictureUrl1);
        Edit_Id1=findViewById(R.id.Edit_nameId1);
        Edit_trip4=findViewById(R.id.Edit_nametrip2);
        Edit_description4 =findViewById(R.id.Edit_descriptiontrip2);
        Edit_teammate4 =findViewById(R.id.Edit_Partnerteam2);
        switchActive3 =findViewById(R.id.switch2);
        Intent intent =getIntent();
        id =intent.getIntExtra("id" ,-1);
        Listperson listperson = null;
        if(id>=0){
            for (Listperson p:personList){
                if(p.getId()==id){
                    listperson =p;
                }
            }
            Edit_NameText.setText(listperson.getName());
            Edit_DateElectionText.setText(String.valueOf(listperson.getDateofupload()));
            Edit_ImageUrlimage.setText(listperson.getImageurl());
            Edit_trip4.setText(listperson.getNametriplocation());
            Edit_description4.setText(listperson.getDescriptiontrip());
            Edit_teammate4.setText(listperson.getTeamatefriend());
            switchActive3.setText(String.valueOf(listperson.isSwitchActive()));
            Edit_Id1.setText(String.valueOf(id));

        }
        else{


        }

        buttonedit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listperson newupdatePerson;
                if(id>=0){


                newupdatePerson = new Listperson(id, Edit_NameText.getText().toString(), Integer.parseInt(Edit_DateElectionText.getText().toString()), Edit_ImageUrlimage.getText().toString(), Edit_trip4.getText().toString(), Edit_description4.getText().toString(), Edit_teammate4.getText().toString(),switchActive3.isChecked());
                personList.set(id, newupdatePerson);
                

                DatabaseHelpertrip databaseHelpertrip=new DatabaseHelpertrip( EdittripActivity.this);
                boolean sucess =databaseHelpertrip.buttonupdate(newupdatePerson);
                    if(sucess == true)
                        Toast.makeText(EdittripActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(EdittripActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
                }

                Intent intent4 = new Intent(EdittripActivity.this, LayoutActivity.class);
                startActivity(intent4);
            }
        });
        buttoncanceledit.setOnClickListener(view -> {
            Intent intent3 = new Intent(EdittripActivity.this, LayoutActivity.class);
            startActivity(intent3);
        });
    }
}