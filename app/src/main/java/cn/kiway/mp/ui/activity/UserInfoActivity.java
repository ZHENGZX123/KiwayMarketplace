package cn.kiway.mp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.kiway.mp.R;
import cn.kiway.mp.bean.UserInfoBean;
import cn.kiway.mp.network.HeiMaRetrofit;
import cn.kiway.mp.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserInfoActivity extends BaseActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    private void loadData() {
        Call<UserInfoBean> call = HeiMaRetrofit.getInstance().getApi().getUserInfo(getSharedPreferences("kiway", 0)
                .getString("x-auth-token", ""));
        call.enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                UserInfoBean user = response.body();
                if (user.getStatusCode() == 200) {
                } else {
                    Utils.showMessage(UserInfoActivity.this, user.getErrorMsg().toString());
                }
            }

            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {
            }
        });
    }
}
