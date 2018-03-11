package com.example.user.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText minputsex, minputage;
    private Button mok;
    private TextView mtxtR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minputsex = (EditText) findViewById(R.id.editText);
        minputage = (EditText) findViewById(R.id.editText2);
        mok = (Button) findViewById(R.id.button);
        mtxtR = (TextView) findViewById(R.id.textView2);
    }
}
