package com.example.myeventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

public class Main2Activity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = (Button) findViewById(R.id.button);
        /**
         * 当点击第二个activity上面的按钮的时候向第一个Activity发送消息，
         * 当第一个Activity收到消息后，一方面将消息Toast显示，一方面放入textView中显示。
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //发送消息是使用EventBus中的Post方法来实现发送的，发送过去的是我们新建的类的实例！
                EventBus.getDefault().post(
                        new FirstEvent("我是孟向阳"));
            }
        });
    }
}
