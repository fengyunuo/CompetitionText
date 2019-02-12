package czmec.cn.mvptext.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by 风雨诺 on 2019/2/12.
 */

public class BasePresenter<T> {
    //1.view层的引用
    protected WeakReference<T> mViewRef;
    //进行绑定
    public void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }
    //进行解绑
    public void detachView(){
        mViewRef.clear();
    }
}
