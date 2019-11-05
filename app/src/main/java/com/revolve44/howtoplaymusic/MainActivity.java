package com.revolve44.howtoplaymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button one = (Button) this.findViewById(R.id.button);
        mp = MediaPlayer.create(context, R.raw.dnky);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                String ButtonText=one.getText().toString();
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.dnky);
                    } else {
                        mp.start(); // Attention !!! now we can play and stop any sound!
                    }
                } catch(Exception e) { e.printStackTrace(); }

                if(ButtonText.equals("Play")){

                    one.setText("Stop");
                }else {

                    one.setText("Play");
                }
            }

        });
    }
}
