package com.example.broadcasetreceiverandroidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;

public class OrderedReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Handler handler = new Handler();

        PendingResult pendingResult = goAsync();

        new Thread(new Runnable() {

            @Override
            public void run() {

                SystemClock.sleep(10000);



                int resultCode = pendingResult.getResultCode();
                String resultData = pendingResult.getResultData();
                Bundle resultExtras = pendingResult.getResultExtras(true);
                String stringExtra = resultExtras.getString("stringExtra");

                resultCode++;
                stringExtra+="->OR2";

                String toastText = "OR2\n"+
                        "resultCode: "+resultCode+"\n"+
                        "resultData: "+resultData+"\n"+
                        "stringExtra: "+stringExtra;



                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

                    }
                });




                resultData = "OR2";
                resultExtras.putString("stringExtra",stringExtra);

                pendingResult.setResult(resultCode,resultData,resultExtras);

                //to send to the next receiver
                pendingResult.finish();



            }
        }).start();



    }
}
