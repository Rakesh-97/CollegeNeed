package com.example.rakesh.collegeneed;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button sdatepicker,edatepicker,stimepicker,etimepicker,okbtn;
    EditText textsdate,textedate,textstime,textetime;
    public static int msYear,msMonth,msDay,msHour,msMinute,meYear,meMonth,meDay,meHour,meMinute;
    public static int asyear,asmonthOfYear,asdayOfMonth,aeyear, aemonthOfYear,aedayOfMonth,ashourOfDay,asminute, aehourOfDay, aeminute;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView =(TextView)findViewById(R.id.link);
        sdatepicker=(Button)findViewById(R.id.starting_date);
        edatepicker=(Button)findViewById(R.id.ending_date);
        stimepicker=(Button)findViewById(R.id.starting_time);
        etimepicker=(Button)findViewById(R.id.ending_time);
        textsdate=(EditText)findViewById(R.id.in_date);
        textstime=(EditText)findViewById(R.id.in_time);
        textedate=(EditText)findViewById(R.id.out_date);
        textetime=(EditText)findViewById(R.id.out_time);
        sdatepicker.setOnClickListener(this);
        stimepicker.setOnClickListener(this);
        edatepicker.setOnClickListener(this);
        etimepicker.setOnClickListener(this);
        okbtn = (Button)findViewById(R.id.ok_btn);




    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.about:
                startActivity(new Intent(this,About.class));
                break;
            case R.id.team:
                startActivity(new Intent(this,Team.class));
                break;
        }
        return true;
    }

    public void onClick(View v)
    {

        if (v.getId()   == R.id.starting_date) {
            Calendar c = Calendar.getInstance();
            msYear = c.get(Calendar.YEAR);
            msMonth = c.get(Calendar.MONTH);
            msDay = c.get(Calendar.DAY_OF_MONTH);
            MainActivity ma= new MainActivity();
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int syear, int smonthOfYear, int sdayOfMonth) {
                    textsdate.setText(sdayOfMonth + "/" + (smonthOfYear + 1) + "/" + syear);
                    asyear=syear;
                    asmonthOfYear=smonthOfYear;
                    asdayOfMonth = sdayOfMonth;
                }
            }, msYear, msMonth, msDay);

            datePickerDialog.show();


        }

        else if (v.getId() == R.id.ending_date) {
            Calendar c = Calendar.getInstance();
            meYear = c.get(Calendar.YEAR);
           meMonth = c.get(Calendar.MONTH);
           meDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int eyear, int emonthOfYear, int edayOfMonth) {
                    textedate.setText(edayOfMonth + "/" + (emonthOfYear + 1) + "/" + eyear);

                    aeyear=eyear;
                    aedayOfMonth = edayOfMonth;
                    aemonthOfYear= emonthOfYear;

                }
            }, meYear, meMonth, meDay);


                    datePickerDialog.show();
        }

        else if (v.getId() == R.id.starting_time) {
            Calendar c = Calendar.getInstance();
           msHour = c.get(Calendar.HOUR_OF_DAY);
           msMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int shourOfDay,
                                      int sminute) {

                    textstime.setText(shourOfDay + ":" + sminute);
                    ashourOfDay=shourOfDay;
                    asminute=sminute;

                }
            }, msHour, msMinute, false);

            timePickerDialog.show();
        }


        else if (v.getId() == R.id.ending_time) {
            Calendar c = Calendar.getInstance();
           meHour = c.get(Calendar.HOUR_OF_DAY);
           meMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int ehourOfDay,
                                      int eminute) {

                    textetime.setText(ehourOfDay + ":" + eminute);
                    aehourOfDay=ehourOfDay;
                    aeminute=eminute;
                }
            }, msHour, meMinute, false);

            timePickerDialog.show();
        }

    }


    public void okfunction(View v) {

        startService(new Intent(this, MyService.class));
        Toast.makeText(getApplicationContext(),"You are Safe",Toast.LENGTH_SHORT).show();
        /*final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {

                            //Toast.makeText(getApplicationContext(),"OK Button Clicked",Toast.LENGTH_SHORT).show();
                            Calendar now =Calendar.getInstance();
                           // Toast.makeText(getApplicationContext(),String.valueOf(asminute),Toast.LENGTH_SHORT).show();
                            if(//((now.get(Calendar.YEAR))==asyear) && (now.get(Calendar.MONTH )==asmonthOfYear) && (now.get(Calendar.DAY_OF_MONTH )==asdayOfMonth) && (now.get(Calendar.HOUR_OF_DAY)==ashourOfDay) &&
                                    (now.get(Calendar.MINUTE)==asminute))
                            {
                                AudioManager as;

                                as =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

                                as.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                            }


                            else if(//(now.get(Calendar.YEAR )==aeyear) && (now.get(Calendar.MONTH )==aemonthOfYear) && (now.get(Calendar.DAY_OF_MONTH )==aedayOfMonth) &&(now.get(Calendar.HOUR_OF_DAY)==aehourOfDay )  &&
                                    (now.get(Calendar.MINUTE)==aeminute))
                            {
                                AudioManager ae;

                                ae =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

                                ae.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                            }

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 1000); //execute in every 50000 ms

        */
    }

}
