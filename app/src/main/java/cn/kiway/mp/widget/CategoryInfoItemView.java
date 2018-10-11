package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CategoryInfoItemView extends LinearLayout {

    @BindView(cn.kiway.mp.R.id.icon)
    ImageView mIcon;
    @BindView(cn.kiway.mp.R.id.title)
    TextView mTitle;

    public CategoryInfoItemView(Context context) {
        this(context, null);
    }

    public CategoryInfoItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.view_category_info, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(String title, String url) {
        mTitle.setText(title);
        String imageUrl = url;
        Glide.with(getContext()).load(imageUrl).placeholder(cn.kiway.mp.R.drawable.ic_default).into(mIcon);
    }
}
