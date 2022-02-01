package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayTask extends AppCompatActivity {

    final static public String DATA_ENTERED = "DATA ENTERED";
    int num;
    TextView name;
    TextView date;
    TextView priority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Display Task");
        setContentView(R.layout.activity_display_task);
        name = findViewById(R.id.textViewName);
        date = findViewById(R.id.textViewDate);
        priority = findViewById(R.id.textViewPriority);
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.USE_KEY)) {
            Task task = (Task) getIntent().getSerializableExtra(MainActivity.USE_KEY);
            name.setText(task.name);
            date.setText(task.date);
            priority.setText(task.priority);
            num = task.num;
    }

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayTask.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayTask.this, MainActivity.class);
                intent.putExtra(DATA_ENTERED, num);
                startActivity(intent);
            }
        });


}
}