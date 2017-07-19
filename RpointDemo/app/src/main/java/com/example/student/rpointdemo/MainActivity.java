package com.example.student.rpointdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText mAgeInput;
    private EditText mWeightInput;
    private int times;
    private int overTime;
    //befor choosing
    private int age=-1;
    private double weight;
    //before choosing gender=-1
    private int gender=-1;//male=0, female=1
    private String freq;
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
                if (checked) {
                    gender = 1;
                    break;
                }
        }

        Context context = getApplicationContext();
        CharSequence text = ""+gender+"";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onGenderClick(View view){
        if(gender==-1){

            Context context = getApplicationContext();
            CharSequence text = "Choose Gender";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            setContentView(R.layout.gender_page);
        }
        else {
            setContentView(R.layout.age_page);

        }
    }
    public void goToAgePage(){
        setContentView(R.layout.age_page);
    }
    public void onAgeClick(View view){
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        Toast toast;

        mAgeInput=(EditText) findViewById(R.id.age_input);
        if (mAgeInput.getText().toString().compareTo("")==0){
            text="Enter Your Age";
            toast=Toast.makeText(context,text,duration);
            toast.show();

        }
        else {
            age = Integer.parseInt(mAgeInput.getText().toString());
            if (age < 16) {
                text = "Choose legal age";
                toast = Toast.makeText(context, text, duration);
                toast.show();
                setContentView(R.layout.age_page);
            } else {
                setContentView(R.layout.weight_page);
                text = ""+age;
                toast = Toast.makeText(context, text, duration);
                toast.show();
                setContentView(R.layout.weight_page);
            }

        }
    }

    public void onWeightClick(View view){
        mWeightInput=(EditText) findViewById(R.id.weight_input);

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        Toast toast;

        mWeightInput=(EditText) findViewById(R.id.weight_input);
        if (mWeightInput.getText().toString().compareTo("")==0){
            text="Enter Your Weight";
            toast=Toast.makeText(context,text,duration);
            toast.show();

        }
        else {
            weight = Integer.parseInt(mWeightInput.getText().toString());
            setContentView(R.layout.f_page);
            text=""+weight;
            toast=Toast.makeText(context,text,duration);
            toast.show();
            goToFreqPage();

        }

    }

//Build the two lists in the F page
    public void makeFrequencyLists() {

        //times spinner
        Spinner spinner_times = (Spinner) findViewById(R.id.times_id);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_times = ArrayAdapter.createFromResource(this,
                R.array.times_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_times.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_times.setAdapter(adapter_times);

        //over time spinner
        Spinner spinner_over_time = (Spinner) findViewById(R.id.over_time_id);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_over_time = ArrayAdapter.createFromResource(this,
                R.array.over_time_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_over_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_over_time.setAdapter(adapter_over_time);
    }

    public void goToFreqPage(){
        setContentView(R.layout.f_page);
        makeFrequencyLists();

    }

    public void onFreqClick(View view){
        Context context = getApplicationContext();
        CharSequence text;
        Toast toast;
        int duration = Toast.LENGTH_SHORT;

        Spinner spinner_times = (Spinner) findViewById(R.id.times_id);
        Spinner spinner_over_time = (Spinner) findViewById(R.id.over_time_id);
        //getting the information from spinner

        freq= spinner_times.getSelectedItem().toString()+" a "+spinner_over_time.getSelectedItem().toString();
        text = freq;


        toast = Toast.makeText(context, text, duration);
        toast.show();

        if(freq.compareTo("choose a choose")==0){
            text="choose an option from the lists";
            toast=Toast.makeText(context,text,duration);
            toast.show();
        }
        else {
            text = freq;


            toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }





}
