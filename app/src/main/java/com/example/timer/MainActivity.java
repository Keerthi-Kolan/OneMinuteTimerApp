package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        TextView textView=findViewById(R.id.textView);
        CountDownTimer Timer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(" "+millisUntilFinished / 1000);

            }
            @Override
            public void onFinish() {
                textView.setTextSize(50);
                textView.setText("\n  Time Up!");

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    Timer.start();
                    button.setText("CANCEL");
                    flag=1;
                }
                else
                {
                    textView.setText(" 00");
                    Timer.cancel();
                    flag=0;
                    button.setText("START");
                }
            }
        });

    }
}