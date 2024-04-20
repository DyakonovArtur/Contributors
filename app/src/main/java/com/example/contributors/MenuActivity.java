package com.example.contributors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBtn1 = findViewById(R.id.button2);
        mBtn2 = findViewById(R.id.button3);
        mBtn3 = findViewById(R.id.button4);
        mBtn4 = findViewById(R.id.button5);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void onClick2(View view) {
        Intent intent = new Intent(MenuActivity.this, MainActivity2.class);
        startActivity(intent);
    }
    public void onClick3(View view) {
        Intent intent = new Intent(MenuActivity.this, MainActivity3.class);
        startActivity(intent);
    }
    public void onClick4(View view) {
        Intent intent = new Intent(MenuActivity.this, MainActivity4.class);
        startActivity(intent);
    }
}