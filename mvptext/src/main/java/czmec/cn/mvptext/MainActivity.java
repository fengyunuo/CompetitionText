package czmec.cn.mvptext;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import czmec.cn.mvptext.view.BaseActivity;
import czmec.cn.mvptext.view.IGirlView;
import czmec.cn.mvptext.adapter.GirlAdapter;
import czmec.cn.mvptext.bean.Girl;
import czmec.cn.mvptext.presenter.GirlPresenter;

public class MainActivity extends BaseActivity<IGirlView,GirlPresenter<IGirlView>> implements IGirlView{

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        girlPresenter.frech();
    }

    @Override
    protected GirlPresenter<IGirlView> createPresenter() {
        return new GirlPresenter<>();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"加载完成",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(List<Girl> girls) {
        GirlAdapter girlAdapter=new GirlAdapter(this,girls);
        listView.setAdapter(girlAdapter);
    }
}
