package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.kiway.mp.bean.AppDetailBean;


public class AppDetailGalleryView extends FrameLayout {

    @BindView(cn.kiway.mp.R.id.app_detail_pic_container)
    LinearLayout mAppDetailPicContainer;

    public AppDetailGalleryView(Context context) {
        this(context, null);
    }

    public AppDetailGalleryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.app_detail_gallery, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppDetailBean appDetailBean) {
        if (appDetailBean.getData().getApp().getScreenshot() != null) {
            String screens = appDetailBean.getData().getApp().getScreenshot().toString();
            if (screens != null && !screens.equals("")) {
                for (int i = 0; i < screens.split("::").length; i++) {
                    String screen = screens.split("::")[i];
                    ImageView imageView = new ImageView(getContext());

                    int padding = getResources().getDimensionPixelSize(cn.kiway.mp.R.dimen.app_detail_pic_padding);
                    if (i != screens.split("::").length - 1) {
                        imageView.setPadding(0, 0, padding, 0);
                    }
                    Glide.with(getContext()).load(screen).override(180, 320).into
                            (imageView);
                    mAppDetailPicContainer.addView(imageView);
                }
            }
        }
    }
}
