package cn.kiway.mp.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.kiway.mp.app.App;


public abstract class BaseFragment extends Fragment {

    @BindView(cn.kiway.mp.R.id.loading_progress)
    ProgressBar mLoadingProgress;
    @BindView(cn.kiway.mp.R.id.loading_error)
    LinearLayout mLoadingError;

    private FrameLayout mBaseView;
    private Handler mHandler = new Handler();
    App app;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView = (FrameLayout) inflater.inflate(cn.kiway.mp.R.layout.fragment_base, null);
        app= (App) getActivity().getApplicationContext();
        ButterKnife.bind(this, mBaseView);
        return mBaseView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        startLoadData();
    }

    /**
     * 子类去实现自己的数据加载
     */
    protected abstract void startLoadData();

    /**
     * 当数据加载成功后刷新UI
     */
    protected void onDataLoadedSuccess() {
        mLoadingProgress.setVisibility(View.GONE);
        mLoadingError.setVisibility(View.GONE);
        mBaseView.addView(onCreateContentView());
    }

    /**
     * 当数据加载失败后刷新UI
     */
    protected void onDataLoadedError() {
        mLoadingError.setVisibility(View.VISIBLE);
        mLoadingProgress.setVisibility(View.GONE);
    }

    /**
     * 子类必须实现该方法提供内容的视图
     */
    protected abstract View onCreateContentView();

    protected void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    @OnClick(cn.kiway.mp.R.id.error_btn_retry)
    public void onClick() {
        startLoadData();
    }
}
