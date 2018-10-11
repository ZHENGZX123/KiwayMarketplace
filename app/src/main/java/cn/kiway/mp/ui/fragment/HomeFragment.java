package cn.kiway.mp.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.leon.loopviewpagerlib.FunBanner;

import java.util.ArrayList;
import java.util.List;

import cn.kiway.mp.ui.activity.AppDetailActivity;



public class HomeFragment extends BaseAppListFragment {

    private List<String> mLooperDataList = new ArrayList<String>();

    @Override
    protected void startLoadData() {
        mLooperDataList.clear();
        getAppList().clear();

    }


    @Override
    protected View onCreateHeaderView() {
        FunBanner banner = new FunBanner(getContext());
        //设置图片的宽高比
        banner.setRatio(0.377f);
        //设置自动轮播
        banner.setEnableAutoLoop(true);
        banner.setImageUrlHost("");
        banner.setImageUrls(mLooperDataList);
        return banner;
    }

    @Override
    protected void onStartLoadMore() {

    }

    /**
     * 处理item的点击事件，由于多加了一个头，获取点击位置的数据时下标减1
     */
    @Override
    protected void onListItemClick(int i) {
        Intent intent = new Intent(getContext(), AppDetailActivity.class);
        intent.putExtra("appId", getAppList().get(i - 1).getId());
        intent.putExtra("packName", getAppList().get(i - 1).getPackageName());
        startActivity(intent);
    }

    /**
     * 返回加载更多时的位置
     */
    @Override
    protected int getLoadMorePosition() {
        return getAdapter().getCount();
    }
}
