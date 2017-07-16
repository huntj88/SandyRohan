package hunt.james.sandyrohan.view.pages.util

import android.content.Context
import android.view.ViewGroup

/**
 * Created by James on 7/8/2017.
 */
interface PageRequired {
    var mViewGroup: ViewGroup
    var mAdapter: Adapter
    var mPageID: PageID
    var layoutBound: Boolean


    fun bindLayout(context: Context, adapter: Adapter)
    fun bindDataFinished()

    interface Adapter{
        fun addPage(pageID: PageID)
    }
}