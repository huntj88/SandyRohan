package hunt.james.sandyrohan.view.pages.util

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import java.util.*
import javax.inject.Inject

/**
 * Created by James on 7/8/2017.
 */
class PageAdapter(var listener: PageAddedListener) : PagerAdapter(), PageRequired.Adapter {


    private var pages: Stack<PageRequired> = Stack()

    @Inject
    lateinit var pageModelBuilder: PageModelBuilder

    init {
        SandyRohanApplication.di.component.inject(this)
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

    fun addPage(page: PageRequired) {
        pages.push(page)
        notifyDataSetChanged()
        listener.pageAdded(pages.size - 1, page.mPageID)
    }

    override fun addPage(pageID: PageID) {
        addPage(pageID.build())
    }

    fun removePageFromStack() {
        pages.pop()
        pageModelBuilder.removeTop()
        notifyDataSetChanged()
    }

    fun getVisiblePageID(): PageID {
        return pages.peek().mPageID
    }

    fun backPressed(): Int {   //tells you the index of the page you are going to

        val lastIndex = pages.size - 1
        val secondToLastIndex = lastIndex - 1

        return secondToLastIndex
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {

        if (!pages[position].layoutBound) {
            pages[position].layoutBound = true
            pages[position].bindLayout(collection.context, this)
        }
        collection.addView(pages[position].mViewGroup)
        return pages[position].mViewGroup
    }
}