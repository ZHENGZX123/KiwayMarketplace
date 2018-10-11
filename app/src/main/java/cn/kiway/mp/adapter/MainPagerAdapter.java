package cn.kiway.mp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.kiway.mp.bean.TitleBean;
import cn.kiway.mp.factory.FragmentFactory;
import cn.kiway.mp.ui.fragment.AppFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<TitleBean.DataBean.ListBean> listBean;

    private  List<AppFragment> appFragments;

    public MainPagerAdapter(List<TitleBean.DataBean.ListBean> listBean, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.listBean = listBean;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance().getFragment(position, listBean.get(position));
    }

    @Override
    public int getCount() {
        return listBean.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listBean.get(position).getName();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
