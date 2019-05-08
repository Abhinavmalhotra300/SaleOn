package com.skgroup.saleon.utils.InfinitePager

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.ViewPager

class MyPageIndicator(val mContext: Context, private val mContainer: LinearLayout?, private val mViewPager: ViewPager,
                      @param:DrawableRes private var mDrawable: Int) : ViewPager.OnPageChangeListener {
    private var mSpacing: Int = 0
    private var mSize: Int = 0
    private var mPageCount: Int = 0
    private var mInitialPage = 0

    private val defaultSizeInDp = 10
    private val defaultSpacingInDp = 8

    init {
        if (mContainer == null) {
            throw IllegalArgumentException("containerView cannot be null")
        } else if (mViewPager.adapter == null) {
            throw IllegalArgumentException("ViewPager does not have an adapter set on it.")
        }

    }

    fun setPageCount(pageCount: Int) {
        mPageCount = pageCount
    }

    fun setInitialPage(page: Int) {
        mInitialPage = page
    }

    fun setDrawable(@DrawableRes drawable: Int) {
        mDrawable = drawable
    }

    fun setSpacingRes(@DimenRes spacingRes: Int) {
        mSpacing = spacingRes
    }

    fun setSize(@DimenRes dimenRes: Int) {
        mSize = dimenRes
    }

    fun show() {
        initIndicators()
        setIndicatorAsSelected(mInitialPage)
    }

    private fun initIndicators() {
        if (mContainer == null || mPageCount <= 0) {
            return
        }

        mViewPager.addOnPageChangeListener(this)
        val res = mContext.resources
        mContainer.removeAllViews()
        for (i in 0 until mPageCount) {
            val view = View(mContext)
            val dimen = if (mSize != 0) res.getDimensionPixelSize(mSize) else res.displayMetrics.density.toInt() * defaultSizeInDp
            val margin = if (mSpacing != 0) res.getDimensionPixelSize(mSpacing) else res.displayMetrics.density.toInt() * defaultSpacingInDp
            val lp = LinearLayout.LayoutParams(dimen, dimen)
            lp.setMargins(if (i == 0) 0 else margin, 0, 0, 0)
            view.layoutParams = lp
            view.setBackgroundResource(mDrawable)
            view.isSelected = i == 0
            mContainer.addView(view)
        }
    }

    private fun setIndicatorAsSelected(index: Int) {
        if (mContainer == null) {
            return
        }
        for (i in 0 until mContainer.childCount) {
            val view = mContainer.getChildAt(i)
            view.isSelected = i == index
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        val index = position % mPageCount
        setIndicatorAsSelected(index)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    fun cleanup() {
        mViewPager.clearOnPageChangeListeners()
    }
}
