package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.network.DownloadManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class AppDetailBottomBar extends RelativeLayout {

    @BindView(cn.kiway.mp.R.id.favorite)
    Button mFavorite;
    @BindView(cn.kiway.mp.R.id.download)
    DownloadButton mDownload;
    @BindView(cn.kiway.mp.R.id.share)
    Button mShare;

    private AppDetailBean mAppDetailBean;

    public AppDetailBottomBar(Context context) {
        this(context, null);
    }

    public AppDetailBottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.view_app_detail_bottom_bar, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppDetailBean appDetailBean) {
        mAppDetailBean = appDetailBean;
        mDownload.syncState(appDetailBean);
    }

    @OnClick(cn.kiway.mp.R.id.download)
    public void onClick() {
        DownloadManager.getInstance().handleDownloadAction(getContext(), mAppDetailBean.getData().getApp()
                .getPackageName());
    }
}
