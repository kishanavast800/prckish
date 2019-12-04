package com.example.prckish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    Button but,but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        but=findViewById(R.id.logout);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentL=new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intentL);
                finish();
                Toast.makeText(ThirdActivity.this,"Successfully logout",Toast.LENGTH_SHORT).show();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentA=new Intent(ThirdActivity.this,QuizActivity.class);
                startActivity(intentA);
            }
        });

    }
}
