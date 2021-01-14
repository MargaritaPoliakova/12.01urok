package com.example.a1201urok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button curr_tasks,coml_tasks,dif_tasks;
    CurrentTasksFragment currentTasksFragment;
    CompleteTasksFragment completeTasksFragment;
    RecurringTasksFrarment recurringTasksFrarment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curr_tasks = findViewById(R.id.curr_tasks);
        coml_tasks = findViewById(R.id.coml_tasks);
        dif_tasks = findViewById(R.id.dif_tasks);

        completeTasksFragment = new CompleteTasksFragment ();
        currentTasksFragment = new CurrentTasksFragment();
        recurringTasksFrarment = new RecurringTasksFrarment();
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.conteiner, currentTasksFragment);
            fragmentTransaction.commit();
        }
        curr_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.conteiner, currentTasksFragment);
                fragmentTransaction.commit();
            }
        });
        coml_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, completeTasksFragment);
                fragmentTransaction.commit();
            }
        });
        dif_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, recurringTasksFrarment);
                fragmentTransaction.commit();
            }
        });

    }
}