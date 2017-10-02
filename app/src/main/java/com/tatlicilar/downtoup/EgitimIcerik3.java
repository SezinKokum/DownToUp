package com.tatlicilar.downtoup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
public class EgitimIcerik3 extends AppCompatActivity {

        Button button;
        EditText EditText2;
        EditText EditText3;
        EditText EditText4;
        TextView ToplamTutar;           //std tanımlamalar
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_egitim_icerik3);
            configureImageButton ();            //resmi değiştirecek fonksiyonu çağırdım
            button = (Button)findViewById(R.id.button);
            EditText2=(EditText)findViewById(R.id.EditText2);   //edittexleri çağırdım ve görünmeez yaptım. ileride resme dokununca çıkarcam diye planladım
            EditText2.setVisibility(View.INVISIBLE);
            EditText3=(EditText)findViewById(R.id.EditText3);
            EditText3.setVisibility(View.INVISIBLE);
            EditText4=(EditText) findViewById(R.id.EditText4);
            EditText4.setVisibility(View.INVISIBLE);
            ToplamTutar=(TextView)findViewById(R.id.ToplamTutar);
            button.setOnClickListener(new View.OnClickListener() {     //
                @Override
                public void onClick(View v) {
                    int x=Integer.parseInt(EditText2.getText().toString());
                    int y=Integer.parseInt(EditText3.getText().toString());
                    int z=Integer.parseInt(EditText4.getText().toString());
                    int k=(x)+(y*2)+(z*7);
                    int almali=k+5;
                    ToplamTutar.setText(String.valueOf(k));
                    Toast.makeText(EgitimIcerik3.this,"Şimdi en yakın markete gitmelisin. Profilinden konumuna yakın marketleri arayabilirsin.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(EgitimIcerik3.this,"Yanına en az "+ almali +"tl almalısın ", Toast.LENGTH_SHORT).show();


                }
            });
        }
        public void configureImageButton() {

            ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
            ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
            ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);

            button2.setOnClickListener(new View.OnClickListener() { //resim-butona onclick tanımladım. seçilirse adet girmek için
                boolean showingFirst = true;

                @Override
                public void onClick(View v) {

                    if (showingFirst == true) {  ///resmi secimi geri almak icin
                        Toast.makeText(EgitimIcerik3.this, "Ekmek sectiniz.", Toast.LENGTH_LONG).show();
                        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
                        button2.setImageResource(R.drawable.ekmekpressed);
                        int a = 0;
                        EditText2.setText(String.valueOf(a));
                        EditText2.setVisibility(View.VISIBLE);
                        showingFirst = false;
                    } else {
                        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
                        button2.setImageResource(R.drawable.ekmek);
                        EditText2.setVisibility(View.INVISIBLE);
                        int a = 0;
                        EditText2.setText(String.valueOf(a));
                        showingFirst = true;
                    }
                }
            });


            button3.setOnClickListener(new View.OnClickListener() {  //resim-butona onclick tanımladım. seçilirse adet girmek için
                boolean showingFirst = true;

                @Override
                public void onClick(View v) {
                    if (showingFirst == true) {  //resmi secimi geri almak icin
                        Toast.makeText(EgitimIcerik3.this, "Su sectiniz.", Toast.LENGTH_LONG).show();
                        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
                        button3.setImageResource(R.drawable.supressed);
                        int a = 0;
                        EditText3.setText(String.valueOf(a));
                        EditText3.setVisibility(View.VISIBLE);
                        showingFirst = false;
                    } else {
                        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
                        button3.setImageResource(R.drawable.su);
                        EditText3.setVisibility(View.INVISIBLE);
                        int a = 0;
                        EditText3.setText(String.valueOf(a));
                        showingFirst = true;
                    }
                }
            });


            button4.setOnClickListener(new View.OnClickListener() {   //resim-butona onclick tanımladım. seçilirse adet girmek için
                boolean showingFirst = true; //resmi secimi geri almak icin

                @Override
                public void onClick(View v) {
                    if (showingFirst == true) {
                        Toast.makeText(EgitimIcerik3.this, "Yumurta sectiniz.", Toast.LENGTH_LONG).show();
                        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
                        button4.setImageResource(R.drawable.yumurtapressed);
                        int a = 0;
                        EditText4.setText(String.valueOf(a));
                        EditText4.setVisibility(View.VISIBLE);
                        showingFirst = false;
                    } else {
                        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
                        button4.setImageResource(R.drawable.yumurta);
                        EditText4.setVisibility(View.INVISIBLE);
                        int a = 0;
                        EditText4.setText(String.valueOf(a));
                        showingFirst = true;
                    }


                }
            });

        }

    }
