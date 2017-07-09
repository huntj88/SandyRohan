package hunt.james.sandyrohan.toolbar

import hunt.james.sandyrohan.pages.util.PageID

/**
 * Created by James on 7/9/2017.
 */
interface ToolbarController {
    fun buildToolbarForPage(pageID: PageID)
}