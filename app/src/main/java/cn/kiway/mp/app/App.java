package cn.kiway.mp.app;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.weidian.lib.hera.config.HeraConfig;
import com.weidian.lib.hera.main.HeraService;
import com.weidian.lib.hera.trace.HeraTrace;

import cn.kiway.mp.network.HeiMaRetrofit;


public class App extends Application {
    private int classify;

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HeiMaRetrofit.getInstance().init(getApplicationContext());
        initHera();
        initX5();
    }

    //小程序集成
    private void initHera() {
        if (HeraTrace.isMainProcess(this)) {
            HeraConfig config = new HeraConfig.Builder()
                    .setDebug(true) // 调试模式
                    .build();
            HeraService.start(this.getApplicationContext(), config);
        }
    }

    //腾讯X5WebView集成
    private void initX5() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }
            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
