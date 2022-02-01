/*
HW 02
HW02
Tristan Lee Poole
 */

package com.example.hw02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Task> list = new ArrayList<>();
    final static public String USE_KEY = "USE KEY";
    int num;
    TextView numTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Task t = new Task("HW", "07", "High", 0);
        list.add(t);
        Task m = new Task("bn", "07", "High", 0);
        list.add(m);
        Task r = new Task("rn", "07", "High", 0);
        list.add(r);

        //Pull what task to delete
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(DisplayTask.DATA_ENTERED)) {
            int task = getIntent().getIntExtra(DisplayTask.DATA_ENTERED, 9);
            num = task;
            list.remove(num);
        }
        //set Text for num of Task
        numTask = findViewById(R.id.textView);
        numTask.setText("You have " + list.size() + " tasks");


        //View Tasks --> Calls Alert Box
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog();



        }

    });
        //Create Task
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, CreateTask.class);
                startActivity(intent);
            }

        });

        }

        //(Alert Box)
        public void onCreateDialog(){
            //CharSequence[] objects = list.toArray();
            CharSequence[] myObjects = new CharSequence[list.size()];
            for(int i = 0; i< list.size(); i++){
                myObjects[i] = list.get(i).getName();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Task");
            builder.setItems(myObjects, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    Intent intent = new Intent(MainActivity.this, DisplayTask.class);
                    intent.putExtra(USE_KEY,
                            new Task(( list.get(which).getName()),
                                    (list.get(which).getDate()),
                                    (( list.get(which).getPriority())),
                                    which));

                    startActivity(intent);
                }
            });
             builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.create();
            builder.show();

        }
}

