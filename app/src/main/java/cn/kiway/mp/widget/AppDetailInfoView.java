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
import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.utils.Utils;



public class AppDetailInfoView extends RelativeLayout {

    @BindView(cn.kiway.mp.R.id.app_icon)
    ImageView mAppIcon;
    @BindView(cn.kiway.mp.R.id.app_name)
    TextView mAppName;
    @BindView(cn.kiway.mp.R.id.app_rating)
    RatingBar mAppRating;
    @BindView(cn.kiway.mp.R.id.download_count)
    TextView mDownloadCount;
    @BindView(cn.kiway.mp.R.id.version_code)
    TextView mVersionCode;
    @BindView(cn.kiway.mp.R.id.time)
    TextView mTime;
    @BindView(cn.kiway.mp.R.id.app_size)
    TextView mAppSize;

    public AppDetailInfoView(Context context) {
        this(context, null);
    }

    public AppDetailInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.view_app_detail_info, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppDetailBean appDetailBean) {
        String iconUrl = appDetailBean.getData().getApp().getAppIcon();
        Glide.with(getContext()).load(iconUrl).placeholder(cn.kiway.mp.R.drawable.icon).into(mAppIcon);
        mAppName.setText(appDetailBean.getData().getApp().getAppName());
        mAppRating.setRating(appDetailBean.getData().getApp().getStar());

        String downloadCount = String.format(getResources().getString(cn.kiway.mp.R.string.download_count),
                appDetailBean.getData().getApp().getDownNumber()+"");
        mDownloadCount.setText(downloadCount);

        String versionCode = String.format(getResources().getString(cn.kiway.mp.R.string.version_code), appDetailBean
                .getData().getApp().getVersion());
        mVersionCode.setText(versionCode);

        String timestamp = String.format(getResources().getString(cn.kiway.mp.R.string.time), Utils.getDateField
                (appDetailBean.getData().getApp().getUpdateTime(), 6));
        mTime.setText(timestamp);

        String size = String.format(getResources().getString(cn.kiway.mp.R.string.app_size), Formatter.formatFileSize
                (getContext(), appDetailBean.getData().getApp().getSize()));
        mAppSize.setText(size);
    }
}
