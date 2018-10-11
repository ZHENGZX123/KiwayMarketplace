package cn.kiway.mp.ui.fragment;

import android.widget.BaseAdapter;

import java.util.List;

import cn.kiway.mp.adapter.CategoryListAdapter;
import cn.kiway.mp.bean.CategoryBean;


public class CategoryFragment extends BaseListFragment {

    private List<CategoryBean> mCategories;

    @Override
    protected void initListView() {
        super.initListView();
        setListDivider(getResources().getDimensionPixelOffset(cn.kiway.mp.R.dimen.app_list_divider_height));
    }

    @Override
    protected void startLoadData() {

    }

    @Override
    protected BaseAdapter onCreateAdapter() {
        return new CategoryListAdapter(getContext(), mCategories);
    }

}
