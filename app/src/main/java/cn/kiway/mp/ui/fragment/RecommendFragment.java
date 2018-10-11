package cn.kiway.mp.ui.fragment;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.kiway.mp.adapter.RecommendAdapter;
import cn.kiway.mp.widget.StellarMap;


public class RecommendFragment extends BaseFragment {

    private List<String> mData = new ArrayList<String>();

    @Override
    protected void startLoadData(){

    }

    @Override
    protected View onCreateContentView() {
        //创建星状图
        StellarMap stellarMap = new StellarMap(getContext());
        //设置adapter
        stellarMap.setAdapter(new RecommendAdapter(getContext(), mData));
        int padding = getResources().getDimensionPixelSize(cn.kiway.mp.R.dimen.padding);
        //设置星状图内部padding
        stellarMap.setInnerPadding(padding, padding, padding, padding);
        //设置布局网格15*20，越大分布越平均
        stellarMap.setRegularity(15, 20);
        //设置初始化组
        stellarMap.setGroup(0);
        return stellarMap;
    }
}
