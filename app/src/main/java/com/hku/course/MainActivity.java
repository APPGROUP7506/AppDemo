package com.hku.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hku.course.utils.HttpPostRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText et_username;

    private EditText et_password;

    private Button btn_login;

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPage();
    }

    private void loginPage() {
        //绑定控件
        et_username = findViewById(R.id.edit_username);
        et_password = findViewById(R.id.edit_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        //为登录按钮设置点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://127.0.0.1:8080/user/lgoin";

                //请求传入的参数
                RequestBody requestBody = new FormBody.Builder()
                        .add("username", et_username.getText().toString())
                        .add("password", et_password.getText().toString())
                        .build();

                HttpPostRequest.okhttpPost(url, requestBody, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "post请求失败", Toast.LENGTH_SHORT).show();

                        //假设登录成功，此处应该放在onResponse函数中，由后端确认登录信息正确
                        Intent intent = new Intent(MainActivity.this, MainPage.class);
                        startActivity(intent);

                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "成功,用户名为：" + et_username.getText().toString(), Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                });
            }
        });

        //为注册按钮设置点击事件
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
