package com.bawei.yuekaoA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView mMyView =  (MyView) findViewById(R.id.MyView);
        mMyView.setMjiekou(new MyView.jiekou() {
            @Override
            public void yuannei()
            {
                Toast.makeText(MainActivity.this, "小圆内", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);


            }

            @Override
            public void yuanwai()
            {
                Toast.makeText(MainActivity.this, "小圆外", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
