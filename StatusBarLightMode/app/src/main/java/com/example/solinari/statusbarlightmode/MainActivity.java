package com.example.solinari.statusbarlightmode;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChangeStatusBar = (Button) findViewById(R.id.btnChangeStatusBar);
        btnChangeStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int flags = getWindow().getDecorView().getSystemUiVisibility();
                    if(flags != 8192){//8192為SYSTEM_UI_FLAG_LIGHT_STATUS_BAR的值
                        flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//淺色背景搭配灰色文字、圖示
                        getWindow().setStatusBarColor(getResources().getColor(R.color.lightStatus,null));
                    }
                    else{
                        flags = 0;//深色背景搭配預設(白色)文字、圖示
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark,null));
                    }
                    getWindow().getDecorView().setSystemUiVisibility(flags);
                }
                else{//版本低於Android 6.0時，出現提示訊息
                    Toast.makeText(MainActivity.this,"This version is not supported !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
