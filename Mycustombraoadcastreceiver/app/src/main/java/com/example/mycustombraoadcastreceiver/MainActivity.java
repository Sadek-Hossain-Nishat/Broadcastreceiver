package com.example.mycustombraoadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);



    }

    public void sendBroadcast(View view) {

        Intent intent = new Intent("com.example.EXAMPLE_ACTION");


        intent.setPackage("com.example.broadcasetreceiverandroidapp");

        // it does not give proper gurentee

//        sendBroadcast(intent);
        // to ensure a proper broadcast with gurantee
//        sendOrderedBroadcast(intent,null);
        // TO TRIGER ANOTHER BROADCAST RECEIVER
        Bundle extras = new Bundle();
        extras.putString("stringExtra","Start");
        sendOrderedBroadcast(intent,null,new SenderReceiver(),null,0,"Start",extras);

    }


}