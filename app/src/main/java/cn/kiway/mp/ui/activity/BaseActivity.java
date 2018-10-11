package cn.kiway.mp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import cn.kiway.mp.app.App;



public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public App app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (App) getApplicationContext();
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
    }

    @Override
    public void onClick(View v) {

    }

    protected void init() {
    }

    public abstract int getLayoutResId();
}
