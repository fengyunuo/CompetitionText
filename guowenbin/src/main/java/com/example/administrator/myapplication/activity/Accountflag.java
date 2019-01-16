package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.dao.FlagDAO;
import com.example.administrator.myapplication.model.Tb_flag;
import com.example.administrator.myapplication.R;

public class Accountflag extends AppCompatActivity {
    EditText txtFlag;
    Button btnflagSaveButton;
    Button btnflagCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountflag);
        txtFlag = findViewById(R.id.txtFlag);
        btnflagSaveButton = findViewById(R.id.btnflagSave);
        btnflagCancelButton = findViewById(R.id.btnflagCancel);
        btnflagSaveButton.setOnClickListener(new OnClickListener() {// 为保存按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String strFlag = txtFlag.getText().toString();
                if (!strFlag.isEmpty()) {
                    FlagDAO flagDAO = new FlagDAO(Accountflag.this);
                    Tb_flag tb_flag = new Tb_flag(
                            flagDAO.getMaxId() + 1, strFlag);
                    flagDAO.add(tb_flag);

                    Toast.makeText(Accountflag.this, "〖新增便签〗数据添加成功！",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Accountflag.this, "请输入便签！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnflagCancelButton.setOnClickListener(new OnClickListener() {// 为取消按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                txtFlag.setText("");
            }
        });
    }
}

