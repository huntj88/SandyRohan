package hunt.james.sandyrohan.pages.util

import android.support.v4.view.ViewPager
import com.jakewharton.rxbinding2.support.v4.view.RxViewPager
import io.reactivex.disposables.Disposable

/**
 * Created by James on 7/8/2017.
 */

class PageManager(viewPager: SwipeOptionalViewPager) : PageAddedListener {

    var mViewPager: SwipeOptionalViewPager = viewPager

    var mPageAdapter: PageAdapter = PageAdapter(this)

    var scrollStateDisposable: Disposable

    init {
        mViewPager.adapter = mPageAdapter
        mPageAdapter.addPage(PageID.TEST)


        scrollStateDisposable = RxViewPager.pageScrollStateChanges(mViewPager).subscribe({ e ->
            if (e == ViewPager.SCROLL_STATE_IDLE) {
                mViewPager.adapter = mPageAdapter
                mViewPager.currentItem = mPageAdapter.count - 1

            }
        })
    }

    override fun pageAdded(indexToGoTo: Int, pageID: PageID) {
        mViewPager.setCurrentItem(indexToGoTo, true)

    }

    fun backPressed(): Boolean {
        val backNotEmpty: Boolean = mViewPager.backPressed(mPageAdapter.backPressed()) //singlePageAdapter.backPressed() returns indexToGoTo
        mPageAdapter.removePageFromStack()

        return backNotEmpty
    }

    fun onDestroy() {
        scrollStateDisposable.dispose()
    }
}