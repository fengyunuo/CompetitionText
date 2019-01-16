package czmec.cn.competitiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toRoadActivity(View view) {
        Intent intent = new Intent(this, RoadActivity.class);
        startActivity(intent);
        //参数一：第二个界面进入动画，参数二：第一个界面退出动画
        overridePendingTransition(R.anim.activity_in,R.anim.firstactivity_out);
    }
}
