package com.example.student.rpointdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText mAgeInput;
    private EditText mWeightInput;

    private int age;
    private double weight;
    private int gender;//male=0, female=1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_page);



        mWeightInput=(EditText) findViewById(R.id.weight_input);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked) {
                    gender=0;
                    break;
                }
            case R.id.radio_female:
                if (checked)
                    gender=1;
                    break;
        }

        Context context = getApplicationContext();
        CharSequence text = ""+gender+"";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onGenderClick(View view){
        setContentView(R.layout.age_page);
    }

    public void onAgeClick(View view){
        mAgeInput=(EditText) findViewById(R.id.age_input);

        age=Integer.parseInt(mAgeInput.getText().toString());




        Context context = getApplicationContext();
        CharSequence text = ""+age+"";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void onWeightClick(View view){
        weight=Integer.parseInt(mWeightInput.getText().toString());
        Context context = getApplicationContext();
        CharSequence text = ""+weight+"";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
