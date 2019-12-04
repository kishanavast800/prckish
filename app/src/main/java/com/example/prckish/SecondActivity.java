package com.example.prckish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
    Button b3,b4;
    EditText ed1, ed2, ed3, RegisterPassword,RegisterConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ed1 = findViewById(R.id.name);
        b3 = findViewById(R.id.Submit);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.username);
        b4=findViewById(R.id.sign_in);
        RegisterPassword = findViewById(R.id.password);
        RegisterConfirmPassword=findViewById(R.id.con_pass);
        closeKeyboard();
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1= new Intent(SecondActivity.this,MainActivity.class);

                startActivity(in1);
            }
        });




        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDataEntered();
            }
            });
        }

        boolean isEmail(EditText text){
        CharSequence email=text.getText().toString();
        return (!TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches());
        }

        boolean isEmpty(EditText text)
        {
            CharSequence str=text.getText().toString();
            return TextUtils.isEmpty(str);
        }

        void CheckDataEntered() {
            if (isEmpty(ed1)) {
                Toast t = Toast.makeText(this, "You must enter the full name", Toast.LENGTH_SHORT);
                t.show();
                ed1.setError("enter name");
            }
            if (isEmail(ed3) == false) {
                ed3.setError("Enter valid email");
            }



            if(isEmpty(RegisterPassword))
            {
                RegisterPassword.setError("Enter your password.");
            }

            if(isEmpty(RegisterConfirmPassword))
            {
                RegisterConfirmPassword.setError("Enter your confirmation password");

                if (!RegisterConfirmPassword.equals(RegisterPassword))
                {
                   Toast t1=Toast.makeText(this,"check the password",Toast.LENGTH_SHORT);
                   t1.show();
                }
            }
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(SecondActivity.this,ThirdActivity.class);

                    startActivity(in);
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
