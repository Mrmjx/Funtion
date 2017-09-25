package com.mo.functiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mo.functiondemo.activity.ThreadWeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button downloadBitmap,thread_weakreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadBitmap = (Button) findViewById(R.id.loadbitmap_tosave_bitmap);
        downloadBitmap.setOnClickListener(this);
        thread_weakreference = (Button) findViewById(R.id.thread_weakreference);
        thread_weakreference.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadbitmap_tosave_bitmap:
                 Intent intent = new Intent(MainActivity.this,DownImageActivity.class);
                startActivity(intent);
                break;
            case R.id.thread_weakreference:
                Intent intentThread = new Intent(MainActivity.this,ThreadWeakReference.class);
                startActivity(intentThread);
                break;
        }
    }
}
