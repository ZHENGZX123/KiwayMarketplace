package cn.kiway.mp.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.kiway.mp.R;
import cn.kiway.mp.adapter.AppListAdapter;
import cn.kiway.mp.adapter.MainPagerAdapter;
import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.bean.ClassifyBean;
import cn.kiway.mp.bean.TitleBean;
import cn.kiway.mp.network.DownloadManager;
import cn.kiway.mp.network.HeiMaRetrofit;
import cn.kiway.mp.utils.Utils;
import cn.kiway.mp.widget.pop.PopCommon;
import cn.kiway.mp.widget.pop.PopModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(cn.kiway.mp.R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(cn.kiway.mp.R.id.vp)
    ViewPager mVp;
    @BindView(cn.kiway.mp.R.id.navigation)
    NavigationView mNavigationView;
    @BindView(cn.kiway.mp.R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(cn.kiway.mp.R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.seacrh)
    EditText seacrh;
    @BindView(R.id.listView)
    ListView listView;

    ImageView avatar;
    TextView userName;
    TextView email;
    PopCommon popCommon;
    MainPagerAdapter adpater;
    private ActionBarDrawerToggle mToggle;
    List<PopModel> list = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return cn.kiway.mp.R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        initView();
        initActionBar();
        initEvent();
        checkStoragePermission();
        initDrawer();
        loadClassify();
    }

    private void loadClassify() {
        final Call<ClassifyBean> classify = HeiMaRetrofit.getInstance().getApi().classify();
        classify.enqueue(new Callback<ClassifyBean>() {
            @Override
            public void onResponse(Call<ClassifyBean> call, Response<ClassifyBean> response) {
                list.clear();
                if (response.body().getStatusCode() == 200) {
                    PopModel allItem = new PopModel();
                    allItem.setDrawableId(0);
                    allItem.setItemDesc("所有应用");
                    allItem.setType(-1);
                    list.add(allItem);
                    for (int i = 0; i < response.body().getData().getList().size(); i++) {
                        PopModel item = new PopModel();
                        item.setDrawableId(0);
                        item.setItemDesc(response.body().getData().getList().get(i).getName());
                        item.setType(response.body().getData().getList().get(i).getType());
                        list.add(item);
                    }
                }
                if (list.size() > 0) {
                    category.setVisibility(View.VISIBLE);
                    category.setText(list.get(0).getItemDesc());
                    app.setClassify(list.get(0).getType());
                } else {
                    category.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ClassifyBean> call, Throwable t) {

            }
        });
    }

    private void initDrawer() {
        View headerView = mNavigationView.getHeaderView(0);
        avatar = (ImageView) headerView.findViewById(R.id.avatar);
        userName = (TextView) headerView.findViewById(R.id.username);
        email = (TextView) headerView.findViewById(R.id.emial);
        userName.setOnClickListener(this);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Utils.showMessage(MainActivity.this, "menu_home");
                        break;
//                    case R.id.menu_setting:
//                        Utils.showMessage(MainActivity.this, "menu_setting");
//                        break;
//                    case R.id.menu_theme:
//                        Utils.showMessage(MainActivity.this, "menu_theme");
//                        break;
                    case R.id.menu_scans:
//                        Utils.showMessage(MainActivity.this, "menu_scans");
                        startActivity(new Intent(MainActivity.this,InsPackageActivity.class));
                        break;
//                    case R.id.menu_feedback:
//                        Utils.showMessage(MainActivity.this, "menu_feedback");
//                        break;
                    case R.id.menu_updates:
                        Utils.showMessage(MainActivity.this, "已经是最新版本");
                        break;
                    case R.id.menu_about:
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        break;
                    case R.id.menu_exit:
                        Utils.showMessage(MainActivity.this, "退出成功");
                        getSharedPreferences("kiway", 0).edit().clear();
                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = getSharedPreferences("kiway", 0).getString("userInfo", "");
        if (!s.equals("")) {
            try {
                JSONObject data = new JSONObject(s);
                userName.setText(data.optString("nickName"));
                email.setText(data.optString("email"));
                Glide.with(this).load(data.optString("userImg")).placeholder(R.drawable.avatar).into(avatar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.username:
                // if (userName.equals("未登录"))
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    public void category(View v) {
        popCommon.showPop(category);
    }

    private void checkStoragePermission() {
        int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_DENIED) {
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, permissions, 0);
        }
    }

    private void initEvent() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                mNavigationView.setCheckedItem(item.getItemId());
                return false;
            }
        });
    }


    private void initView() {
        Call<TitleBean> appDetailBeanCall = HeiMaRetrofit.getInstance().getApi().appTitle();
        appDetailBeanCall.enqueue(new Callback<TitleBean>() {
            @Override
            public void onResponse(Call<TitleBean> call, Response<TitleBean> response) {
                TitleBean titleBean = response.body();
                if (titleBean.getStatusCode() == 200) {
                    adpater = new MainPagerAdapter(titleBean.getData().getList(),
                            getSupportFragmentManager());
                    mVp.setAdapter(adpater);
                    mTabLayout.setupWithViewPager(mVp);
                } else {
                }
            }

            @Override
            public void onFailure(Call<TitleBean> call, Throwable t) {
            }
        });

        popCommon = new PopCommon(this, list, new PopCommon.OnPopCommonListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                category.setText(list.get(position).getItemDesc());
                app.setClassify(list.get(position).getType());
                int currentItem = mVp.getCurrentItem();
                mVp.setAdapter(adpater);
                mVp.getAdapter().notifyDataSetChanged();
                mVp.setCurrentItem(currentItem);
            }
            @Override
            public void onDismiss() {
            }
        });
        initSearch();
    }

    //输入框
    private void initSearch() {
        seacrh.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, final int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {//搜索按键action
                    String content = seacrh.getText().toString();
                    if (TextUtils.isEmpty(content)) {
                        return true;
                    }
                    Call<AppListItem> applikes = HeiMaRetrofit.getInstance().getApi().likeApps(content);
                    applikes.enqueue(new Callback<AppListItem>() {
                        @Override
                        public void onResponse(Call<AppListItem> call, Response<AppListItem> response) {
                            if (response.body().getStatusCode() == 200) {
                                AppListAdapter adapter = new AppListAdapter(MainActivity.this, response.body()
                                        .getData().getList());
                                listView.setAdapter(adapter);
                                findViewById(R.id.app_list).setVisibility(View.GONE);
                                findViewById(R.id.seacrhLinear).setVisibility(View.VISIBLE);
                                if (adapter.getCount() > 0) {
                                    listView.setVisibility(View.VISIBLE);
                                    findViewById(R.id.loading_error).setVisibility(View.GONE);
                                } else {
                                    findViewById(R.id.listView).setVisibility(View.GONE);
                                    findViewById(R.id.loading_error).setVisibility(View.VISIBLE);
                                }
                            } else {
                                Utils.showMessage(MainActivity.this, response.body().getErrorMsg().toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<AppListItem> call, Throwable t) {
                            Utils.showMessage(MainActivity.this, t.toString());
                        }
                    });
                    return true;
                }
                return false;
            }
        });
        seacrh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.getFilters().length <= 0) {
                    findViewById(R.id.app_list).setVisibility(View.VISIBLE);
                    findViewById(R.id.seacrhLinear).setVisibility(View.GONE);
                }
            }
        });
    }


    private void initActionBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置back按钮是否可见
        initActionBarDrawerLayoutToggle();
    }

    private void initActionBarDrawerLayoutToggle() {
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, cn.kiway.mp.R.string.open,
                cn.kiway.mp.R.string.close);
        mToggle.syncState();
        mDrawerLayout.addDrawerListener(mToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, getString(cn.kiway.mp.R.string.permission_denied), Toast.LENGTH_SHORT).show();
                } else {
                    DownloadManager.getInstance().createDownloadDirectory();
                }
                break;
        }
    }
}
