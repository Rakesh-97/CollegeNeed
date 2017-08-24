package com.example.rakesh.collegeneed;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static com.example.rakesh.collegeneed.MainActivity.aedayOfMonth;
import static com.example.rakesh.collegeneed.MainActivity.aehourOfDay;
import static com.example.rakesh.collegeneed.MainActivity.aeminute;
import static com.example.rakesh.collegeneed.MainActivity.aemonthOfYear;
import static com.example.rakesh.collegeneed.MainActivity.aeyear;
import static com.example.rakesh.collegeneed.MainActivity.asdayOfMonth;
import static com.example.rakesh.collegeneed.MainActivity.ashourOfDay;
import static com.example.rakesh.collegeneed.MainActivity.asminute;
import static com.example.rakesh.collegeneed.MainActivity.asmonthOfYear;
import static com.example.rakesh.collegeneed.MainActivity.asyear;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void oncreate()
    {
        Toast.makeText(this,"Services is created",Toast.LENGTH_SHORT).show();
    }

    public void onStart(Intent intent, int startId) {

        final android.os.Handler handler = new android.os.Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        //try {

                        //Toast.makeText(getApplicationContext(),"OK Button Clicked",Toast.LENGTH_SHORT).show();
                        Calendar now =Calendar.getInstance();
                        // Toast.makeText(getApplicationContext(),String.valueOf(asminute),Toast.LENGTH_SHORT).show();
                        if(((now.get(Calendar.YEAR))==asyear) && (now.get(Calendar.MONTH )==asmonthOfYear) && (now.get(Calendar.DAY_OF_MONTH )==asdayOfMonth) && (now.get(Calendar.HOUR_OF_DAY)==ashourOfDay) &&
                                (now.get(Calendar.MINUTE)==asminute))
                        {
                            AudioManager as;

                            as =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

                            as.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        }


                        else if((now.get(Calendar.YEAR )==aeyear) && (now.get(Calendar.MONTH )==aemonthOfYear) && (now.get(Calendar.DAY_OF_MONTH )==aedayOfMonth) &&(now.get(Calendar.HOUR_OF_DAY)==aehourOfDay )  &&
                                (now.get(Calendar.MINUTE)==aeminute))
                        {
                            AudioManager ae;

                            ae =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

                            ae.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        }

                        // } catch (Exception e) {
                        // TODO Auto-generated catch block
                        // }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 1000); //execute in every 50000 ms


    }

    public void onDestroy()
    {
        Toast.makeText(this,"Services is Destroyed",Toast.LENGTH_SHORT).show();
    }
}
