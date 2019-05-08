package com.skgroup.saleon.utils
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager

abstract  class EndlessNestedOnScrollListener(val mLin: LinearLayoutManager) : NestedScrollView.OnScrollChangeListener {
    private var previousTotal = 0 // The total number of items in the dataset after the last load
    private var loading = true // True if we are still waiting for the last set of data to load.
    protected var visibleThreshold = 10 // The minimum amount of items to have below your current scroll position before loading more.
    internal var firstVisibleItem: Int = 0
    internal var visibleItemCount: Int = 0
    internal var totalItemCount: Int = 0
    private var current_page = 0
    override fun onScrollChange(v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                scrollY > oldScrollY) {
            visibleItemCount = mLin.getChildCount();
            totalItemCount = mLin.getItemCount();
            firstVisibleItem = mLin.findFirstVisibleItemPosition();

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false
                    previousTotal = totalItemCount
                }
            }
            if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
                // End has been reached
                // Do something
                current_page++
                  onLoadMore(current_page)
                loading = true
            }
        }
        if (scrollY>=oldScrollY)
        {
            onShow(true)
        }
        else
        {
            onShow(false)
        }

    }
    abstract fun onLoadMore(current_page: Int)
    abstract fun onShow(b: Boolean)
}