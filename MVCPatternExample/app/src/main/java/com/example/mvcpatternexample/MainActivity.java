package com.example.mvcpatternexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginResultInterface {

    ProgressBar mProgressBar;
    EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressBar.setVisibility(View.VISIBLE);
                doLogin();
            }
        });
    }

    @Override
    public void loginResult(boolean result) {
        mProgressBar.setVisibility(View.INVISIBLE);
        if(result) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Login Fail",Toast.LENGTH_SHORT).show();
        }
    }

    private void initUI() {
        mProgressBar = findViewById(R.id.progress_login);
        mUsername = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
    }

    private void doLogin() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        final LoginAPI loginAPI = new LoginAPI(username, password, this);
        loginAPI.doLogin();
    }
}
