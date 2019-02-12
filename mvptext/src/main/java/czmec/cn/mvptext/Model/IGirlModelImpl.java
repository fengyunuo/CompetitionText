package czmec.cn.mvptext.Model;

import java.util.ArrayList;
import java.util.List;

import czmec.cn.mvptext.R;
import czmec.cn.mvptext.bean.Girl;

/**
 * Created by 风雨诺 on 2019/1/23.
 */

public class IGirlModelImpl implements IGirlModel {

    @Override
    public void loadGirl(OnLoadGirlListener onLoadGirlListener) {
        List<Girl> list=new ArrayList<>();
        list.add(new Girl(R.drawable.girl1,"一颗星","沙皮王破旧停车坪"));
        list.add(new Girl(R.drawable.girl2,"两颗星","沙皮王破旧停车坪"));
        list.add(new Girl(R.drawable.girl3,"三颗星","沙皮王破旧停车坪"));
        list.add(new Girl(R.drawable.girl4,"四颗星","沙皮王破旧停车坪"));
        list.add(new Girl(R.drawable.girl5,"五颗星","沙皮王破旧停车坪"));
        list.add(new Girl(R.drawable.girl6,"六颗星","天赋异禀六号铺"));
        list.add(new Girl(R.drawable.wangtao1,"八颗星","王老板更衣室的故事"));
        list.add(new Girl(R.drawable.wangtao2,"十颗星","王老板公交车的故事"));
        onLoadGirlListener.onComplete(list);
    }
}
