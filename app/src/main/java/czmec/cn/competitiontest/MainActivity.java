package czmec.cn.competitiontest;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import czmec.cn.competitiontest.activity.IPSetActivity;
import czmec.cn.competitiontest.activity.MapActivity;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    LinearLayout start;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.main_layout);
        start = findViewById(R.id.start);
        listView = findViewById(R.id.main_listView);

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                switch (i) {
                    case 0://我的座驾

                        break;
                    case 1://我的路况
                        intent.setClass(MainActivity.this, RoadActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.activity_in, R.anim.firstactivity_out);
                        break;
                    case 2://离线地图
                        intent.setClass(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                        break;
                    case 3://ETC查询
                        break;
                    case 4://IP设置
                        intent.setClass(MainActivity.this, IPSetActivity.class);
                        startActivity(intent);
                }
            }
        });
    }

    //在每次打开时确保主界面获得焦点
    @Override
    protected void onStart() {
        super.onStart();
        drawer.closeDrawer(start);
    }

    long lastTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis()-lastTime)>2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
                lastTime = System.currentTimeMillis();
            }else {
//                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
