package com.weidian.lib.hera.api.login;

import android.content.Context;
import android.util.Log;

import com.weidian.lib.hera.api.AbsModule;
import com.weidian.lib.hera.api.HeraApi;
import com.weidian.lib.hera.interfaces.IApiCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/6/27.
 */
@HeraApi(names = {"getUserInfo ,login"})
public class LoginModule extends AbsModule {

    public LoginModule(Context context) {
        super(context);
    }

    @Override
    public void invoke(String event, String params, IApiCallback callback) {
        if (event.equals("login")) {//微信登录接口
            Log.e("Hera","login");
        } else if (event.equals("getUserInfo")) {//获取用户个人信息
            Log.e("Hera","getUserInfo");
            JSONObject result = new JSONObject();
            try {
                result.put("userName", "123");
                result.put("password", "123");
                callback.onResult(packageResultData(event, RESULT_OK, result));
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onResult(packageResultData(event, RESULT_FAIL, null));
            }
        }
    }
}
