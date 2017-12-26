package com.lqm.slidetopmenudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickOne(View view){
        startActivity(new Intent(MainActivity.this,Test1Activity.class));
    }

    public void clickTwo(View view){
        startActivity(new Intent(MainActivity.this,Test2Activity.class));
    }
}
