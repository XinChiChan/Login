package com.example.rediobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change extends AppCompatActivity {
    EditText UserName2,PassWord2,RePassWord2;
    Button Enter2;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        UserName2.findViewById(R.id.UserName2);
        PassWord2.findViewById(R.id.Password2);
        RePassWord2.findViewById(R.id.RePassword1);
        Enter2.findViewById(R.id.Enter2);
        db = new DBHelper(this);

//        Enter2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String UserName = UserName2.getText().toString().trim();
//                String PassWord = PassWord2.getText().toString().trim();
//                String RePassWord  = RePassWord2.getText().toString().trim();
//                if(UserName.equals("")||PassWord.equals("")||RePassWord.equals("")){
//                    Toast.makeText(Change.this,"請輸入帳號或密碼",Toast.LENGTH_SHORT).show();
//                }else {
//                    PassWord.equals(RePassWord){
//
//                    }
//                }
//            }
//        });
    }
}