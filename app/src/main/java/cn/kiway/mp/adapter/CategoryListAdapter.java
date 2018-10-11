package cn.kiway.mp.adapter;

import android.content.Context;

import java.util.List;

import cn.kiway.mp.bean.CategoryBean;
import cn.kiway.mp.widget.CategoryItemView;


public class CategoryListAdapter extends BaseListAdapter<CategoryBean> {


    public CategoryListAdapter(Context context, List<CategoryBean> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, int position) {
        ((CategoryItemView)viewHolder.holdView).bindView(getDataList().get(position));
    }

    @Override
    protected ViewHolder onCreateViewHolder(int position) {
        return new ViewHolder(new CategoryItemView(getContext()));
    }
}
