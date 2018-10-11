package cn.kiway.mp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import java.io.File;

import butterknife.BindView;
import cn.kiway.mp.R;
import cn.kiway.mp.adapter.InsPgAdapter;
import cn.kiway.mp.network.DownloadManager;



public class InsPackageActivity extends BaseActivity {
    @BindView(R.id.listView)
    ListView listView;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_inspg;
    }

    public void finish(View view) {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void init() {
        super.init();
        InsPgAdapter adapter = new InsPgAdapter(this, new File(DownloadManager.DOWNLOAD_DIRECTORY).listFiles());
        listView.setAdapter(adapter);
    }
}
