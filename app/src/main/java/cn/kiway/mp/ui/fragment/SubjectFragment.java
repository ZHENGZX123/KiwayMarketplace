package cn.kiway.mp.ui.fragment;

import android.widget.BaseAdapter;

import java.util.List;

import cn.kiway.mp.adapter.SubjectListAdapter;
import cn.kiway.mp.bean.SubjectBean;


public class SubjectFragment extends BaseLoadMoreListFragment {
    private List<SubjectBean> mSubjects;

    @Override
    protected void startLoadData() {

    }

    @Override
    protected BaseAdapter onCreateAdapter() {
        return new SubjectListAdapter(getContext(), mSubjects);
    }

    @Override
    protected void onStartLoadMore() {

    }
}
