package com.zcl.practice.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zcl.practice.R;
import com.zcl.practice.mvp.bean.User;
import com.zcl.practice.mvp.presenter.UserLoginPresenter;
import com.zcl.practice.mvp.view.IUserLoginView;

/**
 * Description TODO
 * Author ZhangChenglong
 * Date 18/1/10 11:58
 */

public class UserLoginActivity extends Activity implements IUserLoginView {
    
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        
        initViews();
    }
    
    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);
        
        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);
        
        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);
        
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });
        
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }
    
    
    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }
    
    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }
    
    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }
    
    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }
    
    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }
    
    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }
    
    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
