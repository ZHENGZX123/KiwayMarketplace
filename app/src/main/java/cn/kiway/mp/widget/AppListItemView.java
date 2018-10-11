package cn.kiway.mp.widget;

import android.content.Context;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.kiway.mp.bean.AppListItem;


public class AppListItemView extends RelativeLayout {
    private static final String TAG = "AppListItemView";
    @BindView(cn.kiway.mp.R.id.app_icon)
    ImageView mAppIcon;
    @BindView(cn.kiway.mp.R.id.app_name)
    TextView mAppName;
    @BindView(cn.kiway.mp.R.id.app_rating)
    RatingBar mAppRating;
    @BindView(cn.kiway.mp.R.id.app_size)
    TextView mAppSize;
    @BindView(cn.kiway.mp.R.id.app_des)
    TextView mAppDes;
    @BindView(cn.kiway.mp.R.id.download_progress)
    CircleDownloadView mDownloadProgressView;

    public AppListItemView(Context context) {
        this(context, null);
    }

    public AppListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.list_app_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppListItem.DataBean.ListBean item) {
        mAppName.setText(item.getAppName());
        mAppDes.setText(item.getIntroduce());
        mAppSize.setText(Formatter.formatFileSize(getContext(), item.getSize()));
        mAppRating.setRating(5);
     //   Glide.with(getContext()).load(Constant.URL_IMAGE + item.getIconUrl()).placeholder(cn.kiway.mp.R.drawable.ic_default).into(mAppIcon);
        Glide.with(getContext()).load(item.getAppIcon()).placeholder(cn.kiway.mp.R.drawable.ic_default).into(mAppIcon);
        mDownloadProgressView.syncState(item);
    }
}
