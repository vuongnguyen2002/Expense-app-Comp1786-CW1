package com.example.myappfirst;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

    public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>  {

    List<Listperson> personList  ;

    Context context;




    public RecyclerviewAdapter(List<Listperson> personList, Context context ) {
            this.personList = personList;
            this.context = context;


        }







    public void filterList(List<Listperson> filterlist) {
            // below line is to add our filtered
            // list in our course array list.
            personList = filterlist;
            // below line is to notify our adapter
            // as change in recycler view data.
            notifyDataSetChanged();
        }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_person,parent,false);
        MyViewHolder holder =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textNa.setText(personList.get(position).getName());
        holder.textDa.setText(String.valueOf(personList.get(position).getDateofupload()));
        Glide.with(this.context).load(personList.get(position).getImageurl()).into(holder.imageVi);
        holder.Textname_trip.setText(personList.get(position).getNametriplocation());
        holder.Textnametrip_discription.setText(personList.get(position).getDescriptiontrip());
        holder.Text_Teamate.setText(personList.get(position).getTeamatefriend());

        /*holder.PersonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EdittripActivity.class);
                intent.putExtra("id",personList.get(position).getId());
                context.startActivity(intent);



            }
        });*/

        holder.buttonspense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Spensemanagement_activity.class);

                context.startActivity(intent);
            }
        });
        holder.buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EdittripActivity.class);
                intent.putExtra("id",personList.get(position).getId());
                context.startActivity(intent);

            }
        });


    }








    @Override


    public int getItemCount() {
        return personList.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        ImageView imageVi;
        TextView textNa;
        TextView textDa;
        TextView Textname_trip;
        TextView Textnametrip_discription;
        TextView Text_Teamate;
        ConstraintLayout PersonLayout;
        MenuItem viewall;
        MenuItem search;
        Button buttonspense ,buttonedit;








        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVi = itemView.findViewById(R.id.imageViewPerson);
            textNa = itemView.findViewById(R.id.textNamePerson);
            textDa = itemView.findViewById(R.id.textdatePerson);
            PersonLayout = itemView.findViewById(R.id.oneLinePersonLayout);
            viewall=itemView.findViewById(R.id.Delete_all);
            search =itemView.findViewById(R.id.Search_id);
            buttonedit =itemView.findViewById(R.id.buttonEdit);

            buttonspense=itemView.findViewById(R.id.buttonspense);
            Textname_trip=itemView.findViewById(R.id.editTextTextPersonName3);;
            Textnametrip_discription=itemView.findViewById(R.id.editTextTextPersonName4);;
            Text_Teamate=itemView.findViewById(R.id.editTextTextPersonName5);;











        }


    }


}



