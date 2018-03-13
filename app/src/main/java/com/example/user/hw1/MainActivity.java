package com.example.user.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        mok.setOnClickListener(buttonOnClick);
    }

    private View.OnClickListener buttonOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String strSex = minputsex.getText().toString();
            int Age = Integer.parseInt(minputage.getText().toString());

            String strSug = getString(R.string.txtR);
            if (strSex.equals(getString(R.string.sex_male)) || strSex.equals(getString(R.string.male)))
                if(Age < 30)
                    strSug += getString(R.string.sug_not_hurry);
                 else if(Age >= 30 && Age <= 35)
                    strSug += "get marry";
                 else
                    strSug += getString(R.string.sug_find_couple);
            else
                if(Age < 28)
                    strSug += getString(R.string.sug_not_hurry);
                else if(Age >= 28 && Age <= 32 )
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_find_couple);

            mtxtR.setText(strSug);
        }

    };
}
