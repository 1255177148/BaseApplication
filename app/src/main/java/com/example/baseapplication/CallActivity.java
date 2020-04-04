package com.example.baseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

public class CallActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
    private EditText editText;

    /**
     * 动态获取打电话权限
     * @param activity
     */
    private void getCallPermissions(Activity activity){
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
        if (permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        } else {
            callPhone();
        }
    }

    private void callPhone(){
        String number = editText.getText().toString();
        if (StringUtils.isBlank(number)){
            Toast.makeText(getApplicationContext(), "号码不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();// 意图对象：动作 + 数据
            intent.setAction(Intent.ACTION_CALL);//设计动作
            Uri data = Uri.parse("tel:" + number);//设置数据
            intent.setData(data);
            startActivity(intent);// 激活Activity组件
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        editText = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCallPermissions(CallActivity.this);
            }
        });
    }

    /**
     * 处理申请权限结果后的回调
     * @param requestCode 在调用requestPermissions()时设置的参数，根据这个去匹配申请了那个权限
     * @param permissions 申请的权限数组
     * @param grantResults 授权结果数组
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("电话回调函数", "已经获得回调");
        switch (requestCode){
            case REQUEST_EXTERNAL_STORAGE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    callPhone();
                } else {
                    Toast.makeText(this, "授权失败！", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
