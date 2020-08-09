package com.daniil.mediplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView play;
    private SeekBar positionBar;
    private MediaPlayer mp;
    private int totalTime;
    private TextView timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        play = findViewById(R.id.playbutton);
        positionBar = findViewById(R.id.seekBar);
        timeLeft = findViewById(R.id.remainingTime);
        Intent intent = getIntent();

        //create string parameter for every element
        String songName = intent.getStringExtra("song_name");
        TextView txt_songName = findViewById(R.id.trackTitle_p);
        txt_songName.setText(songName);
        String imageLink = intent.getStringExtra("track_image");
        ImageView img_trackImage = findViewById(R.id.songImage_p);
        Glide.with(this).load(imageLink).centerCrop().into(img_trackImage);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mp.isPlaying()){
                    mp.start();
                    Glide.with(getApplicationContext()).load(R.drawable.pause).centerCrop().into(play);
                }
                else{
                    mp.pause();
                    Glide.with(getApplicationContext()).load(R.drawable.play).centerCrop().into(play);
                }
            }
        });
        //mediaplayer initialize
        mp = MediaPlayer.create(this, R.raw.music);
        mp.setLooping(true);
        mp.seekTo(0); //sets position to 0 time on the seekbar
        //mp.setVolume(0.5f,0.5f);
        totalTime = mp.getDuration();
        //positionbar initialize
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mp.seekTo(progress);                    //this function when the duration of the track has changed. i.e. if the song is 1 minute long and plays for 1 second, the player knows that the duration is no 59 seconds not 1 minute
                    positionBar.setProgress(progress);      //changes the progress bar in accordance to the track duration that's left
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Thread(new Runnable() {                                     //literally all of this just to report that the total time changes so that the position bar can move accordingly -_-
            @Override
            public void run() {
                while(mp != null){
                    try{
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();                 // msg.what
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException exception){

                    }
                }
            }
        }).start();

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            int currentPosition = msg.what;
            positionBar.setProgress(currentPosition);
            String remTime = createTimeLabel(totalTime-currentPosition);
            timeLeft.setText("- " + remTime);
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }
}
