package com.example.student.rpointdemo;

import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button contiuneButton;
    private TextView textView;
    private TextView bacView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contiuneButton=(Button) findViewById(R.id.continu_button);
        textView=(TextView) findViewById(R.id.text_view);

    }
    public void onClick(View view){
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText("continue blowing: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView.setText("done!");
                setContentView(R.layout.bac);

                bacView=(TextView) findViewById(R.id.bac_view);
                bacView.setText("hiiiiiii");

            }
        }.start();
    }


}

