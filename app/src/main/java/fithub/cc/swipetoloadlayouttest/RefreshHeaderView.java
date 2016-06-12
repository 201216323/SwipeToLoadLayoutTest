package fithub.cc.swipetoloadlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by hosa2015 on 2016-6-12.
 */
public class RefreshHeaderView extends TextView implements SwipeRefreshTrigger, SwipeTrigger {
    private boolean isRefresh;

    public RefreshHeaderView(Context context) {
        super(context);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //4
    @Override
    public void onRefresh() {
//        setText("REFRESHING");
//        setText("我正在刷新数据啊 啊     啊啊啊。。。");
//        Toast.makeText(getContext(),"aa", Toast.LENGTH_SHORT).show();
    }

    //1
    @Override
    public void onPrepare() {
        setText("");
    }

    //2
    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {

        if (!isComplete) {
            if (yScrolled >= getHeight()) {
//                setText("RELEASE TO REFRESH");
                if (!isRefresh) {
                    setText("释放完成刷新");
                } else {
                    setText("正在刷新。。。");

                }

            } else {
//                setText("SWIPE TO REFRESH");
                setText("下拉可以刷新");
            }
        }

        else {
//            setText("刷新");//refresh returning
            isRefresh = false;
        }

    }

    //3
    @Override
    public void onRelease() {
        isRefresh = true;
        setText("正在刷新。。。");
    }

    //5
    @Override
    public void onComplete() {
//        setText("COMPLETE");
        setText("刷新完成");

    }

    //6
    @Override
    public void onReset() {
        setText("");
    }
}