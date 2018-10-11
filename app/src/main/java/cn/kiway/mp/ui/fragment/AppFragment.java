package cn.kiway.mp.ui.fragment;

import android.annotation.SuppressLint;

import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.bean.TitleBean;
import cn.kiway.mp.network.HeiMaRetrofit;
import cn.kiway.mp.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AppFragment extends BaseAppListFragment {
    TitleBean.DataBean.ListBean listBean;
    private int total = 1;

    @SuppressLint("ValidFragment")
    public AppFragment(TitleBean.DataBean.ListBean listBean) {
        super();
        this.listBean = listBean;
    }

    @Override
    protected void startLoadData() {
        getAppList().clear();
        total = 1;
        Call<AppListItem> listCall = null;
        if (app.getClassify() == -1) {
            listCall = HeiMaRetrofit.getInstance().getApi().listApps(listBean.getType(), total);
        } else {
            listCall = HeiMaRetrofit.getInstance().getApi().listApps(listBean.getType(), total, app
                    .getClassify());
        }
        listCall.enqueue(new Callback<AppListItem>() {
            @Override
            public void onResponse(Call<AppListItem> call, Response<AppListItem> response) {
                AppListItem listItem = response.body();
                if (listItem.getStatusCode() == 200) {
                    getAppList().addAll(listItem.getData().getList());
                    if (getAppList().size() > 0) {
                        onDataLoadedSuccess();
                    } else {
                        onDataLoadedError();
                    }
                }
            }
            @Override
            public void onFailure(Call<AppListItem> call, Throwable t) {
                onDataLoadedError();
            }
        });
    }


    @Override
    protected void onStartLoadMore() {
        total = total + 1;
        Call<AppListItem> listCall = null;
        if (app.getClassify() == -1) {
            listCall = HeiMaRetrofit.getInstance().getApi().listApps(listBean.getType(), total);
        } else {
            listCall = HeiMaRetrofit.getInstance().getApi().listApps(listBean.getType(), total, app
                    .getClassify());
        }
        listCall.enqueue(new Callback<AppListItem>() {
            @Override
            public void onResponse(Call<AppListItem> call, Response<AppListItem> response) {
                AppListItem listItem = response.body();
                if (listItem.getStatusCode() == 200) {
                    if (listItem.getData().getList().size() > 0) {
                        getAppList().addAll(listItem.getData().getList());
                        getAdapter().notifyDataSetChanged();
                    } else {
                        Utils.showMessage(getActivity(), "已加载全部");
                    }
                }
                onDataLoadedSuccess();
            }

            @Override
            public void onFailure(Call<AppListItem> call, Throwable t) {
                if (getAdapter().getCount() <= 0)
                    onDataLoadedError();
            }
        });
    }
}
