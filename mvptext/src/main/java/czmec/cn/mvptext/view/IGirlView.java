package czmec.cn.mvptext.view;

import java.util.List;

import czmec.cn.mvptext.bean.Girl;

/**
 * 定义所有的ui逻辑
 */

public interface IGirlView {
    void showLoading();
    void showGirls(List<Girl> girls);
}
