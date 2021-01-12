package com.example.rediobutton;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Activity {
    EditText UserName1,PassWord1,RePassWord;
    Button Enter1;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        UserName1 = findViewById(R.id.UserName1);
        PassWord1 = findViewById(R.id.Password1);
        RePassWord = findViewById(R.id.RePassword);
        Enter1 = findViewById(R.id.Enter1);
        db = new DBHelper(this);

        Enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = UserName1.getText().toString().trim();
                String PassWord = PassWord1.getText().toString().trim();
                String RPW = RePassWord.getText().toString().trim();

                if(User.equals("")||PassWord.equals("")||RPW.equals("")){
                    Toast.makeText(register.this,"請正確輸入帳號或密碼",Toast.LENGTH_SHORT).show();
                }else {
                    if(PassWord.equals(RPW)){
                        boolean CheckUser = db.CheckUserName(User);
                        if(CheckUser == false){
                            boolean insert = db.insert(User,PassWord);
                            if(insert == true){
                                Toast.makeText(register.this,"註冊成功",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }else{
                        Toast.makeText(register.this,"密碼輸入錯誤",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}