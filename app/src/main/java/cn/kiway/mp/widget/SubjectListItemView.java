package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.kiway.mp.bean.SubjectBean;

public class SubjectListItemView extends RelativeLayout {

    @BindView(cn.kiway.mp.R.id.subject_list_item_image)
    ImageView mSubjectListItemImage;
    @BindView(cn.kiway.mp.R.id.subject_list_item_title)
    TextView mSubjectListItemTitle;

    public SubjectListItemView(Context context) {
        this(context, null);
    }

    public SubjectListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.list_subject_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(SubjectBean bean) {
        mSubjectListItemTitle.setText(bean.getDes());
        Glide.with(getContext()).load( bean.getUrl()).into(mSubjectListItemImage);
    }
}
