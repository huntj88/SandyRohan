package hunt.james.sandyrohan.pages.util

import hunt.james.sandyrohan.pages.util.PageID

/**
 * Created by James on 7/9/2017.
 */
interface PageAddedListener {
    fun pageAdded(indexToGoTo: Int, pageID: PageID)
}