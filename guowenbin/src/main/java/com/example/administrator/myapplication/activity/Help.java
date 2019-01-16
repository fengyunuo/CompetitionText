package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.myapplication.R;

public class Help extends AppCompatActivity {
    EditText txtFlag;
    Button btnflagSaveButton;
    Button btnflagCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        WebView webview=(WebView)findViewById(R.id.webView1);

        StringBuilder sb=new StringBuilder();
        sb.append("<div>《家庭理财通》使用帮助：</div>");
        sb.append("<ul>");
        sb.append("<li>修改密码：选择“系统设置”模块可以修改登录密码，项目运行时， 默认没有密码。</li>");
        sb.append("<li>支出管理：选择“新增支出”模块可以添加支出信息；选择“我的支 出”模块可以查看、修改或删除支出信息。</li>");
        sb.append("<li>收入管理：选择“新增收入”模块可以添加收入信息；选择“我的收 入”模块可以查看、修改或删除收入信息。</li>");
        sb.append("<li>便签管理：选择“收支便签”模块可以添加便签信息；选择“数据管 理”模块中的“便签信息”按钮可以查看、修改或删除便签信息。</li>");
        sb.append("<li>退出系统：选择“退出”模块可以退出《家庭理财通》项目。 </li>");
        sb.append("</ul>");
        webview.loadDataWithBaseURL(null, sb.toString(),"text/html","utf-8",null);
    }
}

