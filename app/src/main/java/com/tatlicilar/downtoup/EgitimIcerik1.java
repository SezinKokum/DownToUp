package com.tatlicilar.downtoup;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

//public class EgitimIcerik1 extends AppCompatActivity {
public class EgitimIcerik1 extends AppCompatActivity  {
    private MediaPlayer mp;
    private ImageButton resim1;
    private ImageButton resim2;
    private ImageButton resim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egitim_icerik1);
        mp = MediaPlayer.create(EgitimIcerik1.this, R.raw.sheep);

        // her image butona click metodu koydum

        resim1 = (ImageButton)findViewById(R.id.imageButton);
        resim2 = (ImageButton)findViewById(R.id.imageButton2);
        resim3 = (ImageButton)findViewById(R.id.imageButton3);
        resim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("Test", "Cow Button");
                mp = MediaPlayer.create(EgitimIcerik1.this, R.raw.cow);
                mp.start();

            }
        });
        resim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("Test", "Duck Button");
                mp = MediaPlayer.create(EgitimIcerik1.this, R.raw.duck);
                mp.start();

            }
        });
        resim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(EgitimIcerik1.this, R.raw.sheep);
                mp.start();

            }
        });
    }
//   @Override
//   public void onPause() {
//       super.onPause();
//       // media player bırakmak icin
//       if(mp != null) mp.release();
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        finish();
    }
}
