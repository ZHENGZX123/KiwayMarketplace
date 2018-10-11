package cn.kiway.mp.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.network.DownloadManager;
import cn.kiway.mp.network.HeiMaRetrofit;
import cn.kiway.mp.widget.AppDetailBottomBar;
import cn.kiway.mp.widget.AppDetailDesView;
import cn.kiway.mp.widget.AppDetailGalleryView;
import cn.kiway.mp.widget.AppDetailInfoView;
import cn.kiway.mp.widget.AppDetailSecurityView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AppDetailFragment extends BaseFragment {

    private String appId;
    private String packName;
    private AppDetailBean mAppDetailBean;

    @Override
    protected void startLoadData() {
        appId = getActivity().getIntent().getStringExtra("appId");
        packName = getActivity().getIntent().getStringExtra("packName");
        Call<AppDetailBean> appDetailBeanCall = HeiMaRetrofit.getInstance().getApi().appDetail(appId);
        appDetailBeanCall.enqueue(new Callback<AppDetailBean>() {
            @Override
            public void onResponse(Call<AppDetailBean> call, Response<AppDetailBean> response) {

                mAppDetailBean = response.body();
                if (mAppDetailBean.getStatusCode() == 200) {
                    onDataLoadedSuccess();
                } else {
                    onDataLoadedError();
                }
            }

            @Override
            public void onFailure(Call<AppDetailBean> call, Throwable t) {
                onDataLoadedError();
            }
        });
    }

    @Override
    protected View onCreateContentView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                0, 1);
        scrollView.setLayoutParams(layoutParams);

        LinearLayout linearLayoutInScrollView = new LinearLayout(getContext());
        linearLayoutInScrollView.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        contentParams.topMargin = getResources().getDimensionPixelSize(cn.kiway.mp.R.dimen.padding);

        //应用信息
        AppDetailInfoView appDetailInfoView = new AppDetailInfoView(getContext());
        appDetailInfoView.bindView(mAppDetailBean);

        //应用安全
        AppDetailSecurityView appDetailSecurityView = new AppDetailSecurityView(getContext());
        appDetailSecurityView.setLayoutParams(contentParams);
        appDetailSecurityView.bindView(mAppDetailBean);

        //应用截图
        AppDetailGalleryView appDetailGalleryView = new AppDetailGalleryView(getContext());
        appDetailGalleryView.setLayoutParams(contentParams);
        appDetailGalleryView.bindView(mAppDetailBean);

        //应用描述
        AppDetailDesView appDetailDesView = new AppDetailDesView(getContext());
        appDetailDesView.setLayoutParams(contentParams);
        appDetailDesView.bindView(mAppDetailBean);

        linearLayoutInScrollView.addView(appDetailInfoView);
        linearLayoutInScrollView.addView(appDetailGalleryView);
        linearLayoutInScrollView.addView(appDetailDesView);
        linearLayoutInScrollView.addView(appDetailSecurityView);
        scrollView.addView(linearLayoutInScrollView);
        linearLayout.addView(scrollView);

        //底部bar
        AppDetailBottomBar appDetailBottomBar = new AppDetailBottomBar(getContext());
        appDetailBottomBar.bindView(mAppDetailBean);
        linearLayout.addView(appDetailBottomBar);
        return linearLayout;
    }


    @Override
    public void onPause() {
        super.onPause();
        DownloadManager.getInstance().removeObserver(packName);
    }
}