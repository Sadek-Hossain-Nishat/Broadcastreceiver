package com.example.broadcasetreceiverandroidapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {






    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "EBR Triggered", Toast.LENGTH_SHORT).show();

       PendingResult pendingResult = goAsync();
       // heavy work on a background thread
        pendingResult.finish();
    }
}
