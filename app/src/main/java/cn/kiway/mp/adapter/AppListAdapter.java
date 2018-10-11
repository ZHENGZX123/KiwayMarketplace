package cn.kiway.mp.adapter;

import android.content.Context;

import java.util.List;

import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.widget.AppListItemView;


public class AppListAdapter extends BaseLoadMoreListAdapter<AppListItem.DataBean.ListBean> {


    public AppListAdapter(Context context, List<AppListItem.DataBean.ListBean> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindNormalViewHolder(ViewHolder viewHolder, int position) {
        ((AppListItemView)(viewHolder.holdView)).bindView(getDataList().get(position));
    }

    @Override
    protected ViewHolder onCreateNormalViewHolder() {
        return new ViewHolder(new AppListItemView(getContext()));
    }

}
