package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.TestPageDataLoader
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


    lateinit var itemName: String


    override fun bindModelToView(pageRequired: PageRequired) {
        mPageRequired = pageRequired
        mPageModelBuilder.buildModel(this, TestPageDataLoader())
    }

    override fun dataFinishedBinding() {
        mPageRequired.bindDataFinished()
    }
}