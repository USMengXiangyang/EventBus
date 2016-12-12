package com.example.myeventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在接受消息的界面注册EventBus
        EventBus.getDefault().register(this);
        text = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
    //在MainActivity中重写onEventMainThread（FirstEvent event），参数就是我们自己定义的类：
    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        text.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    //生命周期
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消订阅EventBus
        EventBus.getDefault().unregister(this);
    }
}
