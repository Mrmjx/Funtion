package com.mo.bottommenu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.mo.bottommenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjx on 2017/9/13.
 */
public class KeyListenActivity extends Activity {
    TextView key_linsterr;
    List<String> list = new ArrayList<>(6);
    int index =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.key_main);
        key_linsterr = (TextView)findViewById(R.id.key_linsterr);
        key_linsterr.setFocusable(true);
        key_linsterr.setOnKeyListener(new TextView.OnKeyListener(){

            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    keyCodeListener(i);
                }
                return false;
            }
        });
    }

    public String keyCodeListener(int keyCode){
        switch (keyCode){
            case 29:
                showInput("1",true);
                return "1";
            case 30:
                showInput("2",true);
                return "2";
            case 7:
                showInput("3",true);
                return "3";
            case 16:
                showInput("4",true);
                return "4";
            case 13:
                showInput("5",true);
                return "5";
            case 8:
                showInput("6",true);
                return "6";
            case 15:
                showInput("7",true);
                return "7";
            case 12:
                showInput("8",true);
                return "8";
            case 9:
                showInput("9",true);
                return "9";
            case 11:
                showInput("0",true);
                return "0";
            case 14:
                showInput("#",true);
                return "#";
            case 10:
                showInput("*",false);
                return "*";
        }
        return "";
    }

    private void showInput(String value, boolean add) {
        if (add) {
            list.add(index, value);
            final StringBuilder builder = new StringBuilder();
            for (int i = 0;i<list.size();i++){
                builder.append(list.get(i));
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    key_linsterr.setText(builder);
                }
            });

            index++;
        } else {
            if (index == 0) {
                return;
            }
            index--;
            list.remove(index);
            final StringBuilder builder = new StringBuilder();
            for (int i = 0;i<list.size();i++){
                builder.append(list.get(i));
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    key_linsterr.setText(builder);
                }
            });
        }
    }
}
