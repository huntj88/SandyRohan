package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.ItemPageDataLoader
import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired

/**
 * Created by James on 7/10/2017.
 */
class ItemPageModel(pageModelBuilder: PageModelBuilder): PageModel, PageModel.PrelimData {

    override var mPreviousPageModel: PageModel? = null
    override var mPageID: PageID = PageID.ITEM
    override var mPageModelBuilder: PageModelBuilder = pageModelBuilder
    override lateinit var mPageRequired: PageRequired
    override var mPageDataLoader: PageDataLoader = ItemPageDataLoader()


    lateinit var itemName: String

    override fun bindModelToView(pageRequired: PageRequired) {
        mPageRequired = pageRequired
        mPageModelBuilder.buildModel(this)
    }

    override fun dataFinishedBinding() {
        mPageRequired.bindDataFinished()
    }

    override fun preDataFinishedBinding() {
        (mPageRequired as PageRequired.PrelimData).preDataFinishedBinding()
    }
}