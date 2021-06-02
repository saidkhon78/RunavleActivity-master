package com.example.runavleactivity;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    boolean running = true;
    String TAG2 = "THREAD2";
    //String TAG = "THREAD";

   /* class WorkerThread extends Thread{
        public void run(){
            int i =0;
            for(i = 0; i < 20 && running; i++){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                }
                Log.v(TAG2, "Thread time=" + i);
            }
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;
       // wr = new WorkerThread();
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                for(i = 0; i < 20 && running; i++){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                    }
                    Log.v(TAG2, "Runable time=" + i);
                    Log.v(TAG2, "Thread time=" + i);
                }
            }
        });
        wr.start();
        Log.v(TAG2, "Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG2, "Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        Log.v(TAG2, "Now I am in onPause");
    }
}