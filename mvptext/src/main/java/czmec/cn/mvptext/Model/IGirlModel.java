package czmec.cn.mvptext.Model;


import java.util.List;

import czmec.cn.mvptext.bean.Girl;

/**
 * 用来加载数据
 */

public interface IGirlModel {
    void loadGirl(OnLoadGirlListener onLoadGirlListener);
    interface OnLoadGirlListener{
        void onComplete(List<Girl> girls);
    }
}
