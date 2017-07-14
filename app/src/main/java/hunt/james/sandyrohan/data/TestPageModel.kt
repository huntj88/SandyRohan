package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired

/**
 * Created by James on 7/9/2017.
 */
class TestPageModel(pageModelBuilder: PageModelBuilder): PageModel {

    override var mPreviousPageModel: PageModel? = null
    override var mPageID: PageID = PageID.TEST

    override var mPageModelBuilder: PageModelBuilder = pageModelBuilder
    override lateinit var mPageRequired: PageRequired


    override fun bindModelToView(pageRequired: PageRequired) {
        mPageRequired = pageRequired
    }

    override fun dataFinishedBinding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}