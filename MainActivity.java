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

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Task> list = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Task t = new Task("HW", "07", "High");
        list.add(t);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //builder.setMessage(R.string.dialog_message)
                onCreateDialog();



        }

    });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, CreateTask.class);
                startActivity(intent);
            }

        });

        }
    public void getActivity(){

    }

        public void onCreateDialog(){
            //CharSequence[] objects = list.toArray();
            CharSequence[] objects = {"foo", "coo"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Task");
            builder.setItems(objects, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){

                }
            });

            builder.create();
            builder.show();

        }
}

