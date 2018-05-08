package edu.ntut.user.myhw3;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private MainActivity self;
    private RadioGroup sex;
    private RadioButton male,female;
    private Spinner mSpnAge;
    private String msAge;
    private CheckBox music,sing,dance,travel,reading,writing,climbing,swim,eating,drawing;
    private Button mBtnOK;
    private TextView mTxtSug;
    private TextView mTxtHob;
    private String selectedSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;

        sex = (RadioGroup) findViewById(R.id.rdgsex);
        male = (RadioButton) findViewById(R.id.radioButton1);
        female = (RadioButton) findViewById(R.id.radioButton2);
        mSpnAge = (Spinner) findViewById(R.id.spinner);

        music = (CheckBox) findViewById(R.id.checkBox1);
        sing = (CheckBox) findViewById(R.id.checkBox2);
        dance = (CheckBox) findViewById(R.id.checkBox3);
        travel = (CheckBox) findViewById(R.id.checkBox4);
        reading = (CheckBox) findViewById(R.id.checkBox5);
        writing = (CheckBox) findViewById(R.id.checkBox6);
        climbing = (CheckBox) findViewById(R.id.checkBox7);
        swim = (CheckBox) findViewById(R.id.checkBox8);
        eating = (CheckBox) findViewById(R.id.checkBox9);
        drawing = (CheckBox) findViewById(R.id.checkBox10);

        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        mTxtHob = (TextView) findViewById(R.id.txtHob) ;
        sex.setOnCheckedChangeListener(Age_OnCheckedChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private RadioGroup.OnCheckedChangeListener Age_OnCheckedChange = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            RadioButton target = (RadioButton) radioGroup.findViewById(id);
            Resources res = getResources();
            ArrayAdapter<String> x;

            if (target == male) {
                x = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.male_age_list));
            }
            else {
                x = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.female_age_list));
            }

            mSpnAge.setAdapter(x);
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MarriageSuggestion ms = new MarriageSuggestion();
            boolean check = male.isChecked();
            String sexSTR = check ? "male" : "female";
            if (check) {
                switch(mSpnAge.getSelectedItem().toString()) {
                    case "less than 30":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 1));
                        break;
                    case "30 ~ 40":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 2));
                        break;
                    case "more than 40":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 3));
                }
            }
            else {
                switch(mSpnAge.getSelectedItem().toString()) {
                    case "less than 28":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 1));
                        break;
                    case "28 ~ 35":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 2));
                        break;
                    case "more than 35":
                        mTxtSug.setText(ms.getSuggestion(sexSTR, 3));
                }
            }


            String habitInfo = "興趣: ";
            /*for (CheckBox radio : listChkHabits) {
                if (radio.isChecked()) {
                    habitInfo += radio.getText().toString() + " ";
                }
            }*/
            if(music.isChecked())
            {
                habitInfo += music.getText().toString() + " ";
            }
            if(sing.isChecked())
            {
                habitInfo += sing.getText().toString() + " ";
            }
            if(dance.isChecked())
            {
                habitInfo += dance.getText().toString() + " ";
            }
            if(travel.isChecked())
            {
                habitInfo += travel.getText().toString() + " ";
            }
            if(reading.isChecked())
            {
                habitInfo += reading.getText().toString() + " ";
            }
            if(writing.isChecked())
            {
                habitInfo += writing.getText().toString() + " ";
            }
            if(climbing.isChecked())
            {
                habitInfo += climbing.getText().toString() + " ";
            }
            if(swim.isChecked())
            {
                habitInfo += swim.getText().toString() + " ";
            }
            if(eating.isChecked())
            {
                habitInfo += eating.getText().toString() + " ";
            }
            if(drawing.isChecked())
            {
                habitInfo += drawing.getText().toString() + " ";
            }

            mTxtHob.setText(habitInfo);

        }
    };
}
