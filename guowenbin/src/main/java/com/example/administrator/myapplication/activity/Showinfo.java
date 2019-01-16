package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapplication.dao.FlagDAO;
import com.example.administrator.myapplication.model.Tb_flag;

import java.util.List;

import com.example.administrator.myapplication.R;

public class Showinfo extends Activity {
    public static final String FLAG = "id";
    Button btnoutinfo, btnininfo, btnflaginfo;
    ListView lvinfo;
    String strType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfo);

        lvinfo = (ListView) findViewById(R.id.lvinfo);

        btnoutinfo = (Button) findViewById(R.id.btnoutinfo);

        btnininfo = (Button) findViewById(R.id.btnininfo);

        btnflaginfo = (Button) findViewById(R.id.btnflaginfo);

        btnoutinfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                ShowInfo(R.id.btnoutinfo);
            }
        });
        btnininfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                ShowInfo(R.id.btnininfo);
            }
        });
        btnflaginfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                ShowInfo(R.id.btnflaginfo);
            }
        });

        lvinfo.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strInfo = String.valueOf(((TextView) view).getText());
                String strid = strInfo.substring(0, strInfo.indexOf('|'));
                Intent intent = null;
                if (strType == "btnflaginfo") {
                    intent = new Intent(Showinfo.this, FlagManage.class);
                    intent.putExtra(FLAG, strid);
                    startActivity(intent);
                }
            }
        });
    }

    private void ShowInfo(int intType) {
        String[] strInfos = null;
        ArrayAdapter<String> arrayAdapter = null;
        Intent intent = null;
        switch (intType) {
            case R.id.btnoutinfo:
                strType = "outinfo";
                intent = new Intent(Showinfo.this, TotalChart.class);
                intent.putExtra("passType", strType);
                startActivity(intent);
                break;
            case R.id.btnininfo:

                strType = "ininfo";
                intent = new Intent(Showinfo.this, TotalChart.class);
                intent.putExtra("passType", strType);
                startActivity(intent);
                break;
            case R.id.btnflaginfo:
                strType = "btnflaginfo";
                FlagDAO flaginfo = new FlagDAO(Showinfo.this);
                List<Tb_flag> listFlags = flaginfo.getScrollData(0,
                        (int) flaginfo.getCount());
                strInfos = new String[listFlags.size()];
                int n = 0;
                for (Tb_flag tb_flag : listFlags) {
                    strInfos[n] = tb_flag.get_id() + "|" + tb_flag.getFlag();
                    if (strInfos[n].length() > 30)
                        strInfos[n] = strInfos[n].substring(0, 30) + "……";
                    n++;
                }
                arrayAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, strInfos);
                lvinfo.setAdapter(arrayAdapter);
                break;
        }
    }

}
