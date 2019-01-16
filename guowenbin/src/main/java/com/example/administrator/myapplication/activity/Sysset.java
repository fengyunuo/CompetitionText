package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.dao.PwdDAO;
import com.example.administrator.myapplication.model.Tb_pwd;

import com.example.administrator.myapplication.R;

public class Sysset extends AppCompatActivity {
    EditText txtpwd;
    Button btnSet, btnsetCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sysset);
        txtpwd = (EditText) findViewById(R.id.txtPwd);
        btnSet = (Button) findViewById(R.id.btnSet);
        btnsetCancel = (Button) findViewById(R.id.btnsetCancel);

        btnSet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                PwdDAO pwdDAO = new PwdDAO(Sysset.this);
                Tb_pwd tb_pwd = new Tb_pwd(txtpwd.getText().toString());
                if (pwdDAO.getCount() == 0) {
                    pwdDAO.add(tb_pwd);
                } else {
                    pwdDAO.update(tb_pwd);
                }

                Toast.makeText(Sysset.this, "〖密码〗设置成功！",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        btnsetCancel.setOnClickListener(new OnClickListener() {

            @Override          public void onClick(View arg0) {
                // TODO Auto-generated method stub
                txtpwd.setText("");
                txtpwd.setHint("请输入密码");
            }
        });
    }
}

