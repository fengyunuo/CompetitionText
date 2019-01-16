package czmec.cn.competitiontest.utli;


import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 风雨诺 on 2019/1/15.
 */

public class HttpUtli {

    public String postByOkhttp(String url, String key, String value){
        OkHttpClient okHttpClient=new OkHttpClient();
        //创建表单请求体
        FormBody.Builder formbody=new FormBody.Builder();
        if (key!=null&&value!=null){
                formbody.add(key,value);
        }
        Request request=new Request.Builder()
                .url(url)
                .post(formbody.build())
                .build();
        try {
            //发送请求，并得到响应
            Response response = okHttpClient.newCall(request).execute();
            String s = response.body().string();
            Log.i("text", s);
            //关闭连接
            okHttpClient.dispatcher().cancelAll();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String postByOkhttp(String url, Map<String,String> map){
        OkHttpClient okHttpClient=new OkHttpClient();
        //创建表单请求体
        FormBody.Builder formbody=new FormBody.Builder();
        if (map!=null){
            for (Map.Entry<String,String> entry:map.entrySet()){
                formbody.add(entry.getKey(),entry.getValue());
            }
        }
        Request request=new Request.Builder()
                .url(url)
                .post(formbody.build())
                .build();
        try {
            //发送请求，并得到响应
            Response response = okHttpClient.newCall(request).execute();
            String s = response.body().string();
            //关闭连接
            okHttpClient.dispatcher().cancelAll();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
