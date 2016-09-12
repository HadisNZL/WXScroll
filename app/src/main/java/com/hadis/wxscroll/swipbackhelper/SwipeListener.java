package com.hadis.wxscroll.swipbackhelper;

public interface SwipeListener {
    void onScroll(float percent, int px);

    void onEdgeTouch();

    /**
     * 调用时滚动首次超过阈值百分比
     */
    void onScrollToClose();
}