package com.zcl.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Description Activity基类
 * Author ZhangChenglong
 * Date 17/12/14 14:59
 */

public abstract class BaseActivity extends AppCompatActivity {
    
    protected String TAG;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getLocalClassName();
    }
}
