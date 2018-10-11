package cn.kiway.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class RatioLayout extends FrameLayout{

    private static final String TAG = "RatioLayout";

    private float DEFAULT_RATION = 2.43f;

    public RatioLayout(Context context) {
        this(context, null);
    }

    public RatioLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = getChildAt(0);
        //如果宽度是Exactly模式,动态计算高度
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            heightSize = (int)(widthSize / DEFAULT_RATION + 0.5f);

            int childWidth = widthSize;
            int childHeight = heightSize;

            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
            int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);

            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        }
        setMeasuredDimension(widthSize, heightSize);
    }
}
