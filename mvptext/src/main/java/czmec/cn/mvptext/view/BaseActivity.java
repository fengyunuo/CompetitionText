package czmec.cn.mvptext.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import czmec.cn.mvptext.presenter.BasePresenter;

/**
 * Created by 风雨诺 on 2019/2/12.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity {
    public T girlPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        girlPresenter=createPresenter();
        girlPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        girlPresenter.detachView();
    }

    protected abstract T createPresenter();
}
