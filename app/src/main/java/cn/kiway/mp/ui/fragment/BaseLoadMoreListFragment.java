package cn.kiway.mp.ui.fragment;

import android.widget.AbsListView;


public abstract class BaseLoadMoreListFragment extends BaseListFragment{


    @Override
    protected void initListView() {
        super.initListView();
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (view.getLastVisiblePosition() == getLoadMorePosition()) {
                        onStartLoadMore();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    protected abstract void onStartLoadMore();

    protected int getLoadMorePosition() {
        return getAdapter().getCount() - 1;
    }
}
