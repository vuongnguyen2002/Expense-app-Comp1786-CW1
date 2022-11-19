package com.example.myappfirst;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.MyViewHolder> {
    private Context context;
    private List<Expense>list;

    public ExpenseAdapter(Context context, List<Expense> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expenselayout_design,parent,false);
        MyViewHolder holder =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Priceproduct.setText(String.valueOf(list.get(position).getExpenseAmount()));
        holder.Textname.setText(list.get(position).getNamespense());
        holder.commentText.setText(list.get(position).getMessagetext());





    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Textname ,Priceproduct ,commentText;
        /*Spinner typechoose;*/






        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Textname =itemView.findViewById(R.id.NameTextFood);
            Priceproduct =itemView.findViewById(R.id.PriceMoney);
            /*typechoose =itemView.findViewById(R.id.Typechoose);*/
            commentText=itemView.findViewById(R.id.Comment);



        }
    }
}
