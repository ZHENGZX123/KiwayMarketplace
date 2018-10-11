package cn.kiway.mp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import cn.kiway.mp.R;
import cn.kiway.mp.bean.LoginBean;
import cn.kiway.mp.bean.ResigerBean;
import cn.kiway.mp.network.HeiMaRetrofit;
import cn.kiway.mp.utils.StatusBarUtil;
import cn.kiway.mp.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends BaseActivity {
    @BindView(cn.kiway.mp.R.id.userName)
    EditText userName;
    @BindView(cn.kiway.mp.R.id.passWord)
    EditText passWord;
    @BindView(R.id.resigter)
    TextView resigter;
    @BindView(R.id.ok)
    Button ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.immersive(this);
    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }


    public void finish(View view) {
        if (ok.getText().toString().equals("登    录")) {
            finish();
        } else {
            resigter.setVisibility(View.VISIBLE);
            userName.setText("");
            passWord.setText("");
            ok.setText("登    录");
        }
    }

    public void ok(View view) {
        if (userName.getText().toString().equals(""))
            Utils.showMessage(this, "用户名不能为空");
        if (passWord.getText().toString().equals(""))
            Utils.showMessage(this, "密码不能为空");
        if (ok.getText().toString().equals("登    录")) {
            Call<LoginBean> loginCall = HeiMaRetrofit.getInstance().getApi().login(userName.getText().toString(),
                    passWord.getText().toString());
            loginCall.enqueue(new Callback<LoginBean>() {
                @Override
                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    LoginBean loginBean = response.body();
                    if (loginBean.getStatusCode() == 200) {
                        getSharedPreferences("kiway", 0).edit().putString("x-auth-token", loginBean.getData()
                                .getToken()).commit();
                        getSharedPreferences("kiway", 0).edit().putString("userInfo", new Gson().toJson(loginBean
                                .getData().getData()).toString()).commit();
                        Utils.showMessage(LoginActivity.this, "登录成功");
                        finish();
                    } else {
                        Utils.showMessage(LoginActivity.this, loginBean.getErrorMsg().toString());
                    }
                }
                @Override
                public void onFailure(Call<LoginBean> call, Throwable t) {
                    Utils.showMessage(LoginActivity.this, "用户名或者密码错误");
                }
            });
        } else {
            Call<ResigerBean> loginCall = HeiMaRetrofit.getInstance().getApi().register(userName.getText().toString(),
                    passWord.getText().toString());
            loginCall.enqueue(new Callback<ResigerBean>() {
                @Override
                public void onResponse(Call<ResigerBean> call, Response<ResigerBean> response) {
                    ResigerBean resigerBean = response.body();
                    if (resigerBean.getStatusCode() == 200) {
                        Utils.showMessage(LoginActivity.this, "注册成功，请登录");
                        resigter.setVisibility(View.VISIBLE);
                        ok.setText("登    录");
                    } else {
                        Utils.showMessage(LoginActivity.this, resigerBean.getErrorMsg().toString());
                    }
                }

                @Override
                public void onFailure(Call<ResigerBean> call, Throwable t) {
                    Utils.showMessage(LoginActivity.this, "用户名或者密码错误");
                }
            });
        }
    }

    public void register(View view) {
        resigter.setVisibility(View.GONE);
        ok.setText("注    册");
    }
}
