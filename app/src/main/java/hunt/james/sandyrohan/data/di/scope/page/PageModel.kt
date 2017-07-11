package hunt.james.sandyrohan.data.di.scope.page

import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.view.pages.util.PageID

/**
 * Created by James on 7/9/2017.
 */
interface PageModel {
    var previousPageModel: PageModel?
    var pageID: PageID

    fun dataFinishedBinding()
}