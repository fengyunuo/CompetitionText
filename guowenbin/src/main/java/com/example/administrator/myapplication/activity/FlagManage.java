package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.dao.FlagDAO;
import com.example.administrator.myapplication.model.Tb_flag;

import com.example.administrator.myapplication.R;

public class FlagManage extends AppCompatActivity {
    EditText txtFlag;
    Button btnEdit, btnDel;
    String strid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_manage);
        txtFlag = (EditText) findViewById(R.id.txtFlagManage);
                btnEdit = (Button) findViewById(R.id.btnFlagManageEdit);
                btnDel = (Button) findViewById(R.id.btnFlagManageDelete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        strid = bundle.getString(Showinfo.FLAG);
        final FlagDAO flagDAO = new FlagDAO(FlagManage.this);
        txtFlag.setText(flagDAO.find(Integer.parseInt(strid)).getFlag());

        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Tb_flag tb_flag = new Tb_flag();
                tb_flag.set_id(Integer.parseInt(strid));
                tb_flag.setFlag(txtFlag.getText().toString());
                flagDAO.update(tb_flag);

                Toast.makeText(FlagManage.this, "〖便签数据〗修改成功！", Toast.LENGTH_SHORT).show();          }
        });

        btnDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                flagDAO.detele(Integer.parseInt(strid));
                Toast.makeText(FlagManage.this, "〖便签数据〗删除成功！", Toast.LENGTH_SHORT).show();}
        });
    }

}