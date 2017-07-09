package hunt.james.sandyrohan.pages.util

import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by James on 7/8/2017.
 */
class PageAdapter(var listener: PageAddedListener) : PagerAdapter(), PageRequired.Adapter {


    private var pages: Stack<PageRequired> = Stack()

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

    fun addPage(page: PageRequired) {
        pages.add(page)
        notifyDataSetChanged()
        listener.pageAdded(pages.size-1)
    }

    override fun addPage(pageID: PageID) {
        addPage(pageID.build())
    }

    fun removePageFromStack() {
        pages.pop()
        notifyDataSetChanged()
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

        pages[position].bindLayout(collection.context, this)
        collection.addView(pages[position].mViewGroup)
        return pages[position].mViewGroup
    }


    interface PageAddedListener {
        fun pageAdded(indexToGoTo: Int)
    }
}