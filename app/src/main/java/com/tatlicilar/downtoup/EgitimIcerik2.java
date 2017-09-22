package com.tatlicilar.downtoup;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class EgitimIcerik2 extends AppCompatActivity {
    int puan=1;
    EditText editText;
    TextView textView;
    TextView textView2;
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egitim_icerik2);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button2.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (!text.equalsIgnoreCase("")) {
                    int saniye = Integer.valueOf(text);
                    CountDownTimer countDownTimer = new CountDownTimer(saniye * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {
                            textView.setText("Saniye:" + (int) (millis / 1000));
                            button.setVisibility(View.INVISIBLE);
                            button2.setVisibility(View.VISIBLE);
                            editText.setVisibility(View.INVISIBLE);

                        }

                        @Override
                        public void onFinish() {
                            textView.setText("Süre doldu!");
                            button2.setVisibility(View.INVISIBLE);
                            button.setVisibility(View.VISIBLE);
                            editText.setVisibility(View.VISIBLE);

                        }
                    }.start();

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Random r = new Random();
                int buttonHeight=220,buttonWidth=120;
                int x = r.nextInt(480-buttonWidth);
                int y = r.nextInt(800-buttonHeight);

                button2.setX(x);
                button2.setY(y);

                textView2.setVisibility(View.VISIBLE);
                textView2.setText(String.valueOf("Puan:"+(puan++)));

            }
        });


    }
}
