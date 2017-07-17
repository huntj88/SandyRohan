package hunt.james.sandyrohan.data.di.scope.page

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired

/**
 * Created by James on 7/9/2017.
 */
interface PageModel {
    var mPreviousPageModel: PageModel?
    var mPageModelBuilder: PageModelBuilder
    var mPageID: PageID
    var mPageRequired: PageRequired
    var mPageDataLoader: PageDataLoader

    fun bindModelToView(pageRequired: PageRequired)
    fun dataFinishedBinding()

    interface PrelimData {
        fun preDataFinishedBinding()
    }
}