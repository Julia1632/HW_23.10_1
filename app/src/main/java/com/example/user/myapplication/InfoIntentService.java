package com.example.user.myapplication;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;

/**
 * Created by User on 31.10.2017.
 */

public class InfoIntentService extends IntentService {

    public InfoIntentService() {
        super("InfoIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        final PendingIntent pi=intent.getParcelableExtra(Constant.PI_KEY);
        final int first=intent.getIntExtra(Constant.FIRST_KEY,0);
       try {
           String result="Data from servise"+first;
           Intent resultIntent=new Intent().putExtra(Constant.RESULT_KEY,result);
           pi.send(InfoIntentService.this,Constant.SERVISE_RESULT,resultIntent);
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }


    }
}
