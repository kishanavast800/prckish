package com.example.prckish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b2;
    EditText ed1,ed2;
    TextView tx1,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.sign_up);
        b2=findViewById(R.id.button);
        ed1=findViewById(R.id.username);
        ed2=findViewById(R.id.password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,SecondActivity.class);

                startActivity(in);
            }
        });

        closeKeyboard();//calling open and close key board on press key
        tx1 = findViewById(R.id.forget_password);
        tx1.setVisibility(View.GONE);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("admin") || ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    b2.setBackgroundColor(Color.BLUE);

                            Intent on=new Intent(MainActivity.this,ThirdActivity.class);
                            startActivity(on);

                } else {


                    tx1.setVisibility(View.VISIBLE);
                    //tx1.setBackgroundColor(Color.RED);
                    //b2.setBackgroundColor(Color.RED);



                }
            }
        });


    }
    private void closeKeyboard(){
        View view=this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            int flags=0 ;
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(),flags);
        }
    }
}
