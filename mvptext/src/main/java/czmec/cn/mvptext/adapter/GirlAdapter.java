package czmec.cn.mvptext.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import czmec.cn.mvptext.R;
import czmec.cn.mvptext.bean.Girl;

/**
 * 数据适配器
 */

public class GirlAdapter extends BaseAdapter {



    @Override
    public int getCount() {
        return girls.size();
    }

    @Override
    public Object getItem(int i) {
        return girls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private LayoutInflater layoutInflater;
    private List<Girl> girls;

    public GirlAdapter(Context context, List<Girl> girls) {
        this.layoutInflater = LayoutInflater.from(context);
        this.girls = girls;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //解析布局文件
        View view1 =null;
        if (view==null){
            view1 = layoutInflater.inflate(R.layout.item, viewGroup, false);
            view=view1;
        }else {
            view1=view;
        }

        //填充每项数据
        Girl girl=girls.get(i);
        ImageView imgGirl=view1.findViewById(R.id.item_imggirl);
        imgGirl.setImageResource(girl.getimg());
        TextView tv_user=view1.findViewById(R.id.item_tv_user);
        tv_user.setText(girl.getLevel());
        TextView tv_info=view1.findViewById(R.id.item_tv_info);
        tv_info.setText(girl.getInfo());
        return view1;
    }
}
