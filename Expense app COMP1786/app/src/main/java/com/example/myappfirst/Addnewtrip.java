package com.example.myappfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Addnewtrip extends AppCompatActivity {
    List<Listperson> personList;
    Button button2 ,button3 ;
    Vuongappproject vuongappproject =(Vuongappproject) this.getApplication();
    TextView Edit_Name ,Edit_DateElection,Edit_ImageUrl;
    TextView Edit_trip1 ,Edit_description1,Edit_teammate1;
    Switch switchactive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editapp);
        personList = vuongappproject.getPersonList();
        button2 =findViewById(R.id.buttonadd1);
        button3 =findViewById(R.id.buttoncancel1);
        Edit_Name =findViewById(R.id.Edit_textNameEE);
        Edit_DateElection =findViewById(R.id.Edit_Date);
        Edit_ImageUrl=findViewById(R.id.Edit_pictureUrl);
        Edit_trip1=findViewById(R.id.Edit_nametrip);
        Edit_description1 =findViewById(R.id.Edit_descriptiontrip);
        Edit_teammate1 =findViewById(R.id.Edit_Partnerteam);
        switchactive =findViewById(R.id.switch1);






        // below line is used to get reference for our database.









        button2.setOnClickListener(view -> {
           /* FirebaseDatabase firebaseDatabase;
            DatabaseReference reference;*/
            /*firebaseDatabase =FirebaseDatabase.getInstance();
            reference =firebaseDatabase.getReference("Listtrip");*/
            FirebaseFirestore db;
            db=FirebaseFirestore.getInstance();
            String name =Edit_Name.getText().toString();
            String date =Edit_DateElection.getText().toString();
            String image =Edit_ImageUrl.getText().toString();
            String nametrip =Edit_trip1.getText().toString();
            String namedestrip =Edit_description1.getText().toString();
            String nameteamate =Edit_teammate1.getText().toString();
            boolean activetrip =switchactive.isChecked();
            Map<String,Object> person =new HashMap<>();
            person.put("Name ",name);
            person.put("Date ",date);
            person.put("Image ",image);
            person.put("Nametrip ",nametrip);
            person.put("Namedescriptiontrip ",namedestrip);
            person.put("NameTeamate ",nameteamate);
            person.put("Active ",activetrip);



            db.collection("Listripexpense").add(person).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(Addnewtrip.this, "Successfull firebasestore ;)))) ", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Addnewtrip.this, "Fail ", Toast.LENGTH_SHORT).show();
                }
            });






            int nextId =vuongappproject.getNextId();
                 Listperson newPerson = new Listperson(nextId, Edit_Name.getText().toString(), Integer.parseInt(Edit_DateElection.getText().toString()), Edit_ImageUrl.getText().toString(), Edit_trip1.getText().toString(), Edit_description1.getText().toString(), Edit_teammate1.getText().toString(),switchactive.isChecked());
                personList.add(newPerson);
                Vuongappproject.setNextId(nextId++);




                DatabaseHelpertrip databaseHelpertrip = new DatabaseHelpertrip( Addnewtrip.this);
                boolean success =databaseHelpertrip.buttonadd(newPerson);
                Toast.makeText(Addnewtrip.this,"DATA ADD IS "+success ,Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(Addnewtrip.this, LayoutActivity.class);
                startActivity(intent2);







        });


        button3.setOnClickListener(view -> {
            Intent intent3 =new Intent(Addnewtrip.this,LayoutActivity.class);
            startActivity(intent3);
        });





    }
}