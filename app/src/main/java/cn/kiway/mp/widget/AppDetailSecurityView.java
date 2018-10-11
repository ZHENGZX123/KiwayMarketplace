package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.kiway.mp.R;
import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.utils.UIUtils;


public class AppDetailSecurityView extends RelativeLayout {

    @BindView(cn.kiway.mp.R.id.app_detail_security_tags)
    LinearLayout mAppDetailSecurityTags;
    @BindView(cn.kiway.mp.R.id.app_detail_security_arrow)
    ImageView mAppDetailSecurityArrow;
    @BindView(cn.kiway.mp.R.id.app_detail_security_des)
    LinearLayout mAppDetailSecurityDes;

    private boolean securityInfoOpen = false;


    public AppDetailSecurityView(Context context) {
        this(context, null);
    }

    public AppDetailSecurityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.view_app_detail_security, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppDetailBean appDetailBean) {
        TextView tag = new TextView(getContext());
        tag.setText("网友评论");
        tag.setGravity(Gravity.CENTER_VERTICAL);
        mAppDetailSecurityTags.addView(tag);
        if (appDetailBean.getData().getComents().size() <= 0) {
            TextView tag1 = new TextView(getContext());
            tag1.setGravity(Gravity.CENTER_VERTICAL);
            tag1.setText("暂无评论");
            mAppDetailSecurityDes.addView(tag1);
        } else {
            for (int i = 0; i < appDetailBean.getData().getComents().size(); i++) {
                AppDetailBean.DataBean.ComentsBean safeBean = appDetailBean.getData().getComents().get(i);
                //Add tag
                LinearLayout line = (LinearLayout) LinearLayout.inflate(getContext(), R.layout.comment_item, null);
                ImageView ivDes = (ImageView) line.findViewById(R.id.avatar);
                TextView tvDes = (TextView) line.findViewById(R.id.comment);
                TextView userName = (TextView) line.findViewById(R.id.userName);
                tvDes.setText(safeBean.getComment());
                userName.setText(safeBean.getUserName());
                Glide.with(getContext())
                        .load(safeBean.getAvater()).placeholder(cn.kiway.mp.R.drawable.ic_default)
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .into(ivDes);
                mAppDetailSecurityDes.addView(line);
            }
        }
        collapseAppDetailSecurity();
    }

    private void collapseAppDetailSecurity() {
        ViewGroup.LayoutParams layoutParams = mAppDetailSecurityDes.getLayoutParams();
        layoutParams.height = 0;
        mAppDetailSecurityDes.setLayoutParams(layoutParams);
    }

    @OnClick(cn.kiway.mp.R.id.app_detail_security_arrow)
    public void onClick() {
        toggleSecurityInfo();
    }

    /**
     * 打开或者关闭安全信息
     */
    private void toggleSecurityInfo() {
        if (securityInfoOpen) {
            //关闭
            int measuredHeight = mAppDetailSecurityDes.getMeasuredHeight();
            UIUtils.animateViewHeight(mAppDetailSecurityDes, measuredHeight, 0);
            UIUtils.rotateView(mAppDetailSecurityArrow, -180, 0);
        } else {
            //打开
            //测量模式为UNSPECIFIED
            mAppDetailSecurityDes.measure(0, 0);
            //获取mAppDetailSecurityDes完全展开应该有的高度
            int measuredHeight = mAppDetailSecurityDes.getMeasuredHeight();
            UIUtils.animateViewHeight(mAppDetailSecurityDes, 0, measuredHeight);
            UIUtils.rotateView(mAppDetailSecurityArrow, 0, -180);
        }
        securityInfoOpen = !securityInfoOpen;
    }
}
