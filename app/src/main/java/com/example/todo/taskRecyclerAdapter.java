package com.example.todo;

import static com.example.todo.taskRecyclerAdapter.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class taskRecyclerAdapter extends RecyclerView.Adapter<taskRecyclerAdapter.ViewHolder>{

    Context context;
    ArrayList<taskmodel> arrtasks;

    public taskRecyclerAdapter(Context context, ArrayList<taskmodel> arrtasks){
        this.context = context;
        this.arrtasks = arrtasks;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tasks,parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.checkbox.setText(arrtasks.get(position).task);


    }

    @Override
    public int getItemCount() {
        return arrtasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.taskText);
        }
    }


}
