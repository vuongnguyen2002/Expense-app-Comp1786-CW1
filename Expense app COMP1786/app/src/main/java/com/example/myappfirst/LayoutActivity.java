package com.example.myappfirst;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LayoutActivity extends AppCompatActivity {
    Button buttonaddbtn;
    Menu menu;
    private static final String TAG = "Person list app";
    Vuongappproject vuongappproject = (Vuongappproject) this.getApplication();
    List<Listperson> personList ;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ListView lv_personlist;
    DatabaseHelpertrip databaseHelpertrip;
    Listperson newPerson;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayoutapp);






        personList = vuongappproject.getPersonList();
        Log.d(TAG, "onCreate: " + personList.toString());

        buttonaddbtn = findViewById(R.id.buttonaddbtn);
        buttonaddbtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Addnewtrip.class);
            startActivity(intent);
        });











        RecyclerView recyclerView = findViewById(R.id.lv_personlist);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new RecyclerviewAdapter(personList,LayoutActivity.this);
        recyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                Toast.makeText(LayoutActivity.this, "Success", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(LayoutActivity.this, "Success", Toast.LENGTH_SHORT).show();

                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                personList.remove(position);
                mAdapter.notifyDataSetChanged();


            }


        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vuo_menu, menu);
        MenuItem searchItem =menu.findItem(R.id.Search_id);
        SearchView searchView=(SearchView) searchItem.getActionView();
        searchView .setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }

        });




        return true;
    }
    private void filter(String text) {
        // creating a new array list to filter our data.
        List<Listperson> filteredlist = new ArrayList<Listperson>();

        // running a for loop to compare elements.
        for (Listperson item : personList) {
            // checking if the entered string matched with any item of my recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {

            mAdapter.filterList(filteredlist);
            // at last we are passing that filtered
            // list to our adapter class.


        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Search_id:
                Toast.makeText(LayoutActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Delete_all:

                    Toast.makeText(LayoutActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    DatabaseHelpertrip databaseHelpertrip =new DatabaseHelpertrip( this);
                    databaseHelpertrip.clearDatabase();
                return true;

            case R.id.view_alltrip:
                Intent intent3 =new Intent(LayoutActivity.this,Viewall_data.class);
                startActivity(intent3);

        }
        item.getItemId();
        return true;


    }







}