package com.example.smdlab._11_1b_ServiceExamples.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.smdlab.R;

public class MyBoundService extends Service {

    public Binder myBinder = new MyBinder();
    public MediaPlayer mediaPlayer;

    public MyBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.mp3_file);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public void Play() {
        mediaPlayer.start();
    }

    public void Pause() {
        mediaPlayer.pause();
    }

    public boolean isPlay() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        MyBoundService getServiceMethod() {
            return MyBoundService.this;
        }
    }

}