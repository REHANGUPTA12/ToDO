package com.example.todo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView taskRecycle;
    FloatingActionButton addTaskBtn;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        taskRecycle = findViewById(R.id.taskRecycler);
        addTaskBtn = findViewById(R.id.addTaskBtn);

        ArrayList<taskmodel> arrTask = new ArrayList<>();

        taskRecyclerAdapter adapter = new taskRecyclerAdapter(this, arrTask);

        taskRecycle.setLayoutManager(new LinearLayoutManager(this));

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog addDialog = new Dialog(MainActivity.this);
                addDialog.setContentView(R.layout.add_dialog);
                addDialog.show();

                Button saveBtn = addDialog.findViewById(R.id.saveBtnAddDialog);
                EditText editTask = addDialog.findViewById(R.id.editTask);

                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editTask.getText().toString();
                        arrTask.add(new taskmodel(s, 0));
                        taskRecycle.setAdapter(adapter);
                        addDialog.dismiss();
                    }
                });
            }
        });
    }
}