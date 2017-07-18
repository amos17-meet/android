package com.example.student.rpointdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button mGenderButton;
    private Button mAgeButton;
    private Button mWeightButton;
    private EditText mInputAge;
    private EditText mInputWeight;
    private EditText mInputGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_page);

        mGenderButton=(Button) findViewById(R.id.gender_button);
    }
}
