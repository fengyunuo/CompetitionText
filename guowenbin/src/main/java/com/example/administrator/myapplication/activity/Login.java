package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.dao.PwdDAO;

import com.example.administrator.myapplication.R;

public class Login extends AppCompatActivity {
    EditText txtlogin;
    Button btnlogin, btnclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtlogin = (EditText) findViewById(R.id.txtLogin);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        btnclose = (Button) findViewById(R.id.btnClose);

        btnlogin.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Login.this, MainActivity.class);
                PwdDAO pwdDAO = new PwdDAO(Login.this);

                if (pwdDAO.getCount() == 0 ||
                        pwdDAO.find().getPassword().isEmpty()) {
                    if(txtlogin.getText().toString().isEmpty()){
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "请不要输入任何密码登录系统！",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {

                    if (pwdDAO.find().getPassword()
                            .equals(txtlogin.getText().toString())) {
                        startActivity(intent);
                    } else {

                        Toast.makeText(Login.this, "请输入正确的密码！",
                        Toast.LENGTH_SHORT).show();
                    }
                }
                txtlogin.setText("");
            }
        });

        btnclose.setOnClickListener(new OnClickListener() {// 为取消按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}

