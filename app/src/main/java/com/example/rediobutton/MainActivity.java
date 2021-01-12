package com.example.rediobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioButton r1;
    RadioButton r2;
    Button enter;
    TextView textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        textname = findViewById(R.id.text_name);
        r1 = findViewById(R.id.Rb);
        r2 = findViewById(R.id.Rg);
        RadioGroup radioGroup = findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton r = (RadioButton) findViewById(checkedId);
            }
        });
    }
        public void enter(View v) {
            CharSequence str = "", name2 = "";
            name2 = name.getText().toString();
            
            if (r1.isChecked())
            {
                str = r1.getText();
            }
            else if (r2.isChecked())
            {
                str = r2.getText();
            }
            textname.setText("您輸入的姓名是:" + name2 + "\n" + "您選擇的性別是:" + str);
        }
    }
