package com.example.administrator.ddms_exp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class main extends AppCompatActivity {
    private  static final String ACTIVITY_TAG="LogDemo";
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {

                Log.v(main.ACTIVITY_TAG,"This is Verbose");
                Log.d(main.ACTIVITY_TAG,"This is Debug");
                Log.i(main.ACTIVITY_TAG,"This is Information");
                Log.w(main.ACTIVITY_TAG,"This is Warnning.");
                Log.e(main.ACTIVITY_TAG,"This is Error");
            }
        });
    }
}
