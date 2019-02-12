package czmec.cn.mvptext.presenter;

import java.util.List;

import czmec.cn.mvptext.Model.IGirlModel;
import czmec.cn.mvptext.Model.IGirlModelImpl;
import czmec.cn.mvptext.view.IGirlView;
import czmec.cn.mvptext.bean.Girl;

/**
 * 表示层
 */

public class GirlPresenter<T extends IGirlView> extends BasePresenter<T>{

    //2.model层引用
    IGirlModel iGirlModel=new IGirlModelImpl();

    //4.执行操作
    public void frech(){
        if (mViewRef!=null){
            mViewRef.get().showLoading();
            if (iGirlModel!=null){
                iGirlModel.loadGirl(new IGirlModel.OnLoadGirlListener() {
                    @Override
                    public void onComplete(List<Girl> girls) {
                        if (mViewRef!=null){
                            mViewRef.get().showGirls(girls);
                        }
                    }
                });
            }
        }
    }
}
