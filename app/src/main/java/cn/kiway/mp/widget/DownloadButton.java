package cn.kiway.mp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.network.DownloadInfo;
import cn.kiway.mp.network.DownloadManager;



public class DownloadButton extends Button implements Observer {

    private Drawable mDrawable;

    private float mMax = 100;

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
        postInvalidate();
    }

    public float getMax() {
        return mMax;
    }

    public void setMax(float max) {
        mMax = max;
    }

    private float mProgress;

    private boolean enableProgress = true;

    public DownloadButton(Context context) {
        this(context, null);
    }

    public DownloadButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDrawable = new ColorDrawable(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //是否绘制进度
        if (enableProgress) {
            //根据进度计算出drawable的右边位置
            int right = (int) ((mProgress / mMax) * getWidth());
            mDrawable.setBounds(0, 0, right, getHeight());
            //将drawable绘制到画布上
            mDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    /**
     * 清空进度
     */
    public void clearProgress() {
        enableProgress = false;
        invalidate();
    }

    public void syncState(AppDetailBean appDetailBean) {
        DownloadManager.getInstance().addObserver(appDetailBean.getData().getApp().getPackageName(), this);
        DownloadInfo downloadInfo = DownloadManager.getInstance().initDownloadInfo(getContext(), appDetailBean
                .getData().getApp().getPackageName(), appDetailBean.getData().getApp().getSize(), appDetailBean
                .getData().getApp().getDownUrl(), appDetailBean.getData().getApp().getSuffix(), appDetailBean.getData
                ().getApp().getVersion());
        updateStatus(downloadInfo);
    }

    @Override
    public void update(Observable o, Object arg) {
        final DownloadInfo downloadInfo = (DownloadInfo) arg;
        post(new Runnable() {
            @Override
            public void run() {
                updateStatus(downloadInfo);
            }
        });
    }


    private void updateStatus(DownloadInfo downloadInfo) {
        setBackgroundResource(cn.kiway.mp.R.drawable.selector_app_detail_bottom_normal);
        switch (downloadInfo.getDownloadStatus()) {
            case DownloadManager.STATE_UN_DOWNLOAD:
                setText(cn.kiway.mp.R.string.download);
                break;
            case DownloadManager.STATE_DOWNLOADING:
                setBackgroundResource(cn.kiway.mp.R.drawable.selector_app_detail_bottom_downloading);
                setMax(downloadInfo.getSize());
                setProgress(downloadInfo.getProgress());
                int ration = (int) (downloadInfo.getProgress() * 1.0f / downloadInfo.getSize() * 100);
                String progress = String.format(getContext().getString(cn.kiway.mp.R.string.download_progress), ration);
                setText(progress);
                break;
            case DownloadManager.STATE_DOWNLOADED:
                setText(cn.kiway.mp.R.string.install);
                clearProgress();
                break;
            case DownloadManager.STATE_PAUSE:
                setText(cn.kiway.mp.R.string.continue_download);
                break;
            case DownloadManager.STATE_WAITING:
                setText(cn.kiway.mp.R.string.waiting);
                break;
            case DownloadManager.STATE_INSTALLED:
                setText(cn.kiway.mp.R.string.open);
                break;
            case DownloadManager.STATE_FAILED:
                setText(cn.kiway.mp.R.string.retry);
                break;
        }
    }
}
