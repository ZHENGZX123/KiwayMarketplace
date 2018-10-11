package cn.kiway.mp.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.weidian.lib.hera.main.HeraService;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.network.DownloadInfo;
import cn.kiway.mp.network.DownloadManager;
import cn.kiway.mp.ui.activity.WebActivity;
import cn.kiway.mp.utils.Utils;

import static cn.kiway.mp.network.DownloadManager.STATE_DOWNLOADED;
import static cn.kiway.mp.network.DownloadManager.STATE_INSTALLED;


public class CircleDownloadView extends FrameLayout implements Observer {

    private static final String TAG = "DownloadProgressView";

    @BindView(cn.kiway.mp.R.id.download)
    ImageView mDownload;
    @BindView(cn.kiway.mp.R.id.download_info)
    TextView mDownloadText;

    private Paint mPaint;
    private RectF mRectF;
    private DownloadInfo mDownloadInfo;

    private boolean enableProgress;

    public CircleDownloadView(Context context) {
        this(context, null);
    }

    public CircleDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.view_download_progress, this);
        ButterKnife.bind(this, this);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mRectF = new RectF();
        //一般情况下自定义的ViewGroup不会绘制自己，除非给它设置背景，所以我们打开绘制自定义ViewGroup的开关
        setWillNotDraw(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int left = mDownload.getLeft() - 3;
        int top = mDownload.getTop() - 3;
        int right = mDownload.getRight() + 3;
        int bottom = mDownload.getBottom() + 3;
        mRectF.set(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (enableProgress) {
            float sweepAngle = (mDownloadInfo.getProgress() * 1.0f / mDownloadInfo.getSize()) * 360;
            canvas.drawArc(mRectF, -90, sweepAngle, false, mPaint);
        }
    }

    @OnClick(cn.kiway.mp.R.id.download)
    public void onClick() {
        if (mDownloadInfo.getSuffix().equals(".zip")) {
            if (mDownloadInfo.getDownloadStatus() == STATE_DOWNLOADED || mDownloadInfo.getDownloadStatus() ==
                    STATE_INSTALLED) {
                String userId = "123F";//标识宿主App业务用户id
                String appId = mDownloadInfo.getPackageName();//小程序的id
                String appPath = mDownloadInfo.getFilePath();//小程序的本地存储路径
                HeraService.launchHome(getContext().getApplicationContext(), userId, appId, appPath);
            } else {
                DownloadManager.getInstance().handleDownloadAction(getContext(), mDownloadInfo.getPackageName());
            }
        } else if (mDownloadInfo.getSuffix().equals(".html")) {
            getContext().startActivity(new Intent(getContext(), WebActivity.class).putExtra("url", mDownloadInfo
                    .getDownloadUrl()));
        } else if (mDownloadInfo.getSuffix().equals(".exe")) {
            Utils.showMessage(getContext(), "exe文件无法下载");
        } else {
            DownloadManager.getInstance().handleDownloadAction(getContext(), mDownloadInfo.getPackageName());
        }
    }


    public void syncState(AppListItem.DataBean.ListBean item) {
        //由于ListView回收的影响，如果mDownloadInfo不为空则表示CircleDownload之前监听过其他app的下载
        if (mDownloadInfo != null) {
            //移除之前的监听
            DownloadManager.getInstance().removeObserver(mDownloadInfo.getPackageName());
        }
        mDownloadInfo = DownloadManager.getInstance().initDownloadInfo(getContext(), item.getPackageName(), item
                .getSize(), item.getDownUrl(), item.getSuffix(), item.getVersion());
        DownloadManager.getInstance().addObserver(mDownloadInfo.getPackageName(), this);
        updateStatus(mDownloadInfo);
    }


    private void updateStatus(DownloadInfo downloadInfo) {
        //当移除之前的观察者后，还有残留的runnable没有执行，这里过滤掉之前的runnable
        if (!downloadInfo.getPackageName().equals(mDownloadInfo.getPackageName())) {
            return;
        }
        mDownloadInfo = downloadInfo;
        File file = new File(downloadInfo.getFilePath());
        switch (downloadInfo.getDownloadStatus()) {
            case DownloadManager.STATE_UN_DOWNLOAD:
                if (file.exists())
                    file.delete();
                mDownloadText.setText(cn.kiway.mp.R.string.download);
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_download);
                break;
            case STATE_DOWNLOADED:
                if (downloadInfo.getSuffix().equals(".apk")) {
                    mDownloadText.setText(cn.kiway.mp.R.string.install);
                } else {
                    downloadInfo.setDownloadStatus(STATE_INSTALLED);
                    mDownloadText.setText(cn.kiway.mp.R.string.open);
                }
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_install);
                enableProgress = false;
                break;
            case DownloadManager.STATE_DOWNLOADING:
                int progress = (int) (mDownloadInfo.getProgress() * 1.0f / mDownloadInfo.getSize() * 100);
                mDownloadText.setText(String.format(getResources().getString(cn.kiway.mp.R.string.download_progress), progress));
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_pause);
                updateProgress();
                break;
            case DownloadManager.STATE_FAILED:
                if (file.exists())
                    file.delete();
                mDownloadText.setText(cn.kiway.mp.R.string.retry);
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_redownload);
                break;
            case STATE_INSTALLED:
                mDownloadText.setText(cn.kiway.mp.R.string.open);
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_install);
                break;
            case DownloadManager.STATE_PAUSE:
                //zzx add
                if (file.exists())
                    file.delete();
                mDownloadInfo.setProgress(0);
                mDownloadText.setText(cn.kiway.mp.R.string.continue_download);
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_download);
                break;
            case DownloadManager.STATE_WAITING:
                mDownloadText.setText(cn.kiway.mp.R.string.waiting);
                mDownload.setImageResource(cn.kiway.mp.R.drawable.ic_cancel);
                break;
        }
    }

    private void updateProgress() {
        enableProgress = true;
        postInvalidate();
    }

    @Override
    public void update(Observable o, final Object arg) {
        post(new Runnable() {
            @Override
            public void run() {
                updateStatus((DownloadInfo) arg);
            }
        });
    }

}
