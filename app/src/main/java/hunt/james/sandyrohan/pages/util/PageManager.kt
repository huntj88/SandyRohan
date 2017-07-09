package hunt.james.sandyrohan.pages.util

/**
 * Created by James on 7/8/2017.
 */

class PageManager(viewPager: SwipeOptionalViewPager): PageAdapter.PageAddedListener {

    var mViewPager:SwipeOptionalViewPager = viewPager

    var mPageAdapter: PageAdapter = PageAdapter(this)

    init {
        mViewPager.adapter = mPageAdapter
        mPageAdapter.addPage(PageID.TEST)

    }

    override fun pageAdded(indexToGoTo: Int) {
        mViewPager.setCurrentItem(indexToGoTo, true)
    }

    fun backPressed(): Boolean {
        val backNotEmpty:Boolean = mViewPager.backPressed(mPageAdapter.backPressed()) //singlePageAdapter.backPressed() returns indexToGoTo
        mPageAdapter.removePageFromStack()

        return backNotEmpty
    }

}