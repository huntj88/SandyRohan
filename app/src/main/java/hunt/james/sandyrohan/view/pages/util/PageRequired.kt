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
    fun bindLayout(context: Context, adapter: Adapter)

    interface Adapter{
        fun addPage(pageID: PageID)
    }
}