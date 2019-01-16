package czmec.cn.competitiontest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import czmec.cn.competitiontest.bean.TrafficLightBean;
import czmec.cn.competitiontest.utli.HttpUtli;
import czmec.cn.competitiontest.utli.UrlUtlis;

public class RoadActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x0001:
                    SimpleAdapter simpleAdapter = new SimpleAdapter(RoadActivity.this, list, R.layout.roadlist_item,
                            new String[]{"roadId", "redTime", "greenTime", "yellowTime"},
                            new int[]{R.id.item_roadId, R.id.item_redTime, R.id.item_greenTime, R.id.item_yellowTime});
                    listView.setAdapter(simpleAdapter);
                    dialog.dismiss();
                    break;
            }
        }
    };
    private Spinner spinner;
    private ListView listView;
    private int order_index = 0;
    private ArrayList<Map<String, String>> list = new ArrayList<>();
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
        init();
        createDialog();
    }

    private void createDialog() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("正在加载....")
                .create();
    }

    private void init() {
        listView = findViewById(R.id.road_listview);
        spinner = findViewById(R.id.road_spinner);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.firstactivity_in, R.anim.activity_out);
    }

    public void selectTrafficLight(View view) {
        dialog.show();
        list.clear();
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 1; i <= 3; i++) {
                    String json = new HttpUtli().postByOkhttp(UrlUtlis.GetTrafficLightInfo, "TrafficLightId", i + "");
                    Gson gson = new Gson();
                    TrafficLightBean trafficLightBean = gson.fromJson(json, TrafficLightBean.class);
                    TrafficLightBean.ServerInfoBean serverInfo = trafficLightBean.getServerInfo();
                    String redTime = serverInfo.getRedTime();
                    String greenTime = serverInfo.getGreenTime();
                    String yellowTime = serverInfo.getYellowTime();
                    Map<String, String> map = new HashMap<>();
                    map.put("roadId", i + "");
                    map.put("redTime", redTime);
                    map.put("greenTime", greenTime);
                    map.put("yellowTime", yellowTime);
                    list.add(map);
                }
                sort();
                Message msg = new Message();
                msg.what = 0x0001;
                handler.sendMessage(msg);
            }
        }.start();
    }

    private void sort() {
        switch (order_index) {
            case 0:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o2.get("redTime").compareTo(o1.get("redTime"));
                    }
                });
                break;
            case 1:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o1.get("redTime").compareTo(o2.get("redTime"));
                    }
                });
                break;
            case 2:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o2.get("greenTime").compareTo(o1.get("greenTime"));
                    }
                });
                break;
            case 3:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o1.get("greenTime").compareTo(o2.get("greenTime"));
                    }
                });
                break;
            case 4:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o2.get("yellowTime").compareTo(o1.get("yellowTime"));
                    }
                });
                break;
            case 5:
                Collections.sort(list, new Comparator<Map<String, String>>() {
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return o1.get("yellowTime").compareTo(o2.get("yellowTime"));
                    }
                });
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        order_index = i;
//        Log.i("test", "onItemSelected: "+i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
