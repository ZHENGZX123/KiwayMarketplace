package cn.kiway.mp.adapter;

import android.content.Context;

import java.util.List;

import cn.kiway.mp.bean.SubjectBean;
import cn.kiway.mp.widget.SubjectListItemView;


public class SubjectListAdapter extends BaseLoadMoreListAdapter<SubjectBean> {


    public SubjectListAdapter(Context context, List<SubjectBean> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindNormalViewHolder(ViewHolder viewHolder, int position) {
        ((SubjectListItemView)viewHolder.holdView).bindView(getDataList().get(position));
    }

    @Override
    protected ViewHolder onCreateNormalViewHolder() {
        return new ViewHolder(new SubjectListItemView(getContext()));
    }

}
