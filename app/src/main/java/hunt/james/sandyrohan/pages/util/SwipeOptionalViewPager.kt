package hunt.james.sandyrohan.pages.util

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by James on 7/8/2017.
 */
class SwipeOptionalViewPager(context: Context, attr: AttributeSet): ViewPager(context,attr) {

    var isPagingEnabled: Boolean = false

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return isPagingEnabled && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return isPagingEnabled && super.onInterceptTouchEvent(ev)
    }

    fun backPressed(index: Int): Boolean {
        if(index>=0) {
            setCurrentItem(index,true)
            return true
        } else {
            return false
        }
    }


}