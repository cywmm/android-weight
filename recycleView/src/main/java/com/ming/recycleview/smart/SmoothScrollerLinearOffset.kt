package com.ming.recycleview.smart

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearSmoothScroller

/**
 * date: 2021/11/26 18:13
 * author: wangming
 * dec: 控制滚动速度和偏移量
 */
class SmoothScrollerLinearOffset(
    private val context: Context?,
    private val offsetValue: Int,
    private val callback: Callback?
) : LinearSmoothScroller(context) {
    private val TAG = "SmoothScroller"
    private var scrollSpeed = 1f

    fun setScrollSpeed(speed: Float) {
        if (speed < 0f) scrollSpeed = 1f
        scrollSpeed = speed
    }

    override fun getVerticalSnapPreference(): Int {
        return SNAP_TO_START
    }

    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
        val densityDpi = (displayMetrics?.densityDpi ?: 1f).toFloat()
        val speedPerPixel = densityDpi / (densityDpi * scrollSpeed)
        Log.d(TAG, "calculateSpeedPerPixel: $speedPerPixel-----${displayMetrics?.densityDpi}")
        return speedPerPixel
    }

    override fun calculateDyToMakeVisible(v: View?, snapPreference: Int): Int {
        return super.calculateDyToMakeVisible(
            v, snapPreference
        ) + (context?.resources?.getDimensionPixelSize(offsetValue) ?: 0)
    }

    override fun onStop() {
        super.onStop()
        callback?.onSmoothScrollerStop()
    }

    interface Callback {
        fun onSmoothScrollerStop()
    }
}