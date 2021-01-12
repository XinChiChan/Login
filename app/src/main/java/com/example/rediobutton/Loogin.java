package com.example.rediobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loogin extends Activity {


    EditText Username,Password;
    Button Enter,Register;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_loogin);

        Username = findViewById(R.id.UserName);
        Password = findViewById(R.id.Password);
        Enter = findViewById(R.id.Enter);
        Register = findViewById(R.id.register);
        db = new DBHelper(this);


        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = Username.getText().toString().trim();
                String PassWord = Password.getText().toString().trim();
                if(UserName.equals("")||PassWord.equals("")){
                    Toast.makeText(Loogin.this,"請輸入帳號或密碼",Toast.LENGTH_SHORT).show();
                }else{
                    boolean CheckUserNamePassWord = db.CheckUserNamePassWord(UserName,PassWord);
                    if(CheckUserNamePassWord == false){
                        Toast.makeText(Loogin.this,"沒有此帳號",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Loogin.this,"登入成功",Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(Loogin.this,MainActivity.class);
                        startActivity(intent);
                        Username.setText("");
                        Password.setText("");
                    }
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loogin.this,register.class);
                startActivity(intent);
            }
        });
    }

    public void change(View view) {
        Intent intent = new Intent(Loogin.this,Change.class);
        startActivity(intent);
    }
}