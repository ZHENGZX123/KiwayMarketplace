package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;


public class LoadingMoreProgressView extends RelativeLayout {

    public LoadingMoreProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingMoreProgressView(Context context) {
        this(context, null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(cn.kiway.mp.R.layout.list_loading_item, this);
    }
}
