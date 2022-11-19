package com.example.myappfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.reflect.TypeToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spensemanagement_activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;
    List<Expense> list =new ArrayList<>();
    TextInputLayout Textname1,commentText1,Priceproduct1;
    Button addbuttonexpense ,buttonBacktomain;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spense_management_activity);
        recyclerView=findViewById(R.id.recyclerview);
        adapter =new ExpenseAdapter(this,list);
        LinearLayoutManager llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        FirebaseDatabase firebaseDatabase;
        DatabaseReference reference;
        firebaseDatabase =FirebaseDatabase.getInstance();
        reference =firebaseDatabase.getReference("ListMoney");

        Textname1 =findViewById(R.id.expense);
        commentText1 =findViewById(R.id.Commenttext);
        addbuttonexpense =findViewById(R.id.addpexpense);
        Priceproduct1 =findViewById(R.id.amount);
        buttonBacktomain=findViewById(R.id.BacktoMain);

        total =findViewById(R.id.totalamount);

        addbuttonexpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int totalAmount=0;

                String nameproduct =Textname1.getEditText().getText().toString().trim();
                String commentText =commentText1.getEditText().getText().toString().trim();
                int price =Integer.parseInt(Priceproduct1.getEditText().getText().toString().trim());
                FirebaseFirestore db;
                db=FirebaseFirestore.getInstance();
                Map<String,Object> Expense1 =new HashMap<>();
                Expense1.put("nameproduct1",nameproduct);
                Expense1.put("Pricemoney",price);
                Expense1.put("CommentText",commentText);

                db.collection("Listexpense").add(Expense1).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Spensemanagement_activity.this, "Successfull firebasestore ;)))) ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Spensemanagement_activity.this, "Fail ", Toast.LENGTH_SHORT).show();
                    }
                });

                list.add(new Expense(nameproduct,price,commentText));
                adapter.notifyDataSetChanged();
                Textname1.getEditText().setText("");
                Priceproduct1.getEditText().setText("");

                for(int i = 0;i <list.size();i++) {

                    totalAmount += list.get(i).getExpenseAmount();
                    total.setText("Total . " + totalAmount);
                }
               /* Database_expense database_expense =new Database_expense(Spensemanagement_activity.this);
                boolean success =database_expense.buttonadd1((Expense) list);
                Toast.makeText(Spensemanagement_activity.this, "Upload success"+success, Toast.LENGTH_SHORT).show();*/


//                Task<Void> success2 =reference.setValue(list);
//                Toast.makeText(Spensemanagement_activity.this, "UP CLOUD SUCCESS  "+success2, Toast.LENGTH_SHORT).show();



            }

        });
        buttonBacktomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Spensemanagement_activity.this ,LayoutActivity.class);
                Toast.makeText(Spensemanagement_activity.this, "Back to home", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });






    }

}


