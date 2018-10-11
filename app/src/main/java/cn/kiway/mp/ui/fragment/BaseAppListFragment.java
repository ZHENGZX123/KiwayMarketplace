package cn.kiway.mp.ui.fragment;

import android.content.Intent;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.kiway.mp.adapter.AppListAdapter;
import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.ui.activity.AppDetailActivity;


public abstract class BaseAppListFragment extends BaseLoadMoreListFragment {

    List<AppListItem.DataBean.ListBean> mAppListItems = new ArrayList<AppListItem.DataBean.ListBean>();

    @Override
    protected BaseAdapter onCreateAdapter() {
        return new AppListAdapter(getContext(), mAppListItems);
    }

    @Override
    protected void initListView() {
        super.initListView();
        setListDivider(getResources().getDimensionPixelSize(cn.kiway.mp.R.dimen.app_list_divider_height));
    }


    @Override
    public void onResume() {
        super.onResume();
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
        }
    }


    @Override
    protected void onListItemClick(int i) {
        Intent intent = new Intent(getContext(), AppDetailActivity.class);
        intent.putExtra("appId", getAppList().get(i).getId());
        intent.putExtra("packName", getAppList().get(i).getPackageName());
        startActivity(intent);
    }

    protected List<AppListItem.DataBean.ListBean> getAppList() {
        return mAppListItems;
    }
}
