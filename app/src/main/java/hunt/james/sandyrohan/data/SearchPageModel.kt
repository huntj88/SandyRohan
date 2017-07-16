package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.data.di.scope.data.loader.SearchPageDataLoader
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import hunt.james.sandyrohan.view.pages.util.PageID
import hunt.james.sandyrohan.view.pages.util.PageRequired

/**
 * Created by James on 7/16/2017.
 */

class SearchPageModel(pageModelBuilder: PageModelBuilder): PageModel {

    override var mPreviousPageModel: PageModel? = null
    override var mPageID: PageID = PageID.SEARCH
    override var mPageModelBuilder: PageModelBuilder = pageModelBuilder
    override lateinit var mPageRequired: PageRequired
    override var mPageDataLoader: PageDataLoader = SearchPageDataLoader()

    var mSearchString: String = ""
    lateinit var mResults: ArrayList<ItemSmall>

    override fun bindModelToView(pageRequired: PageRequired) {
        mPageRequired = pageRequired
        mPageModelBuilder.buildModel(this)
    }

    override fun dataFinishedBinding() {
        mPageRequired.bindDataFinished()
    }

    fun search(searchString: String) {
        mSearchString = searchString
        mPageDataLoader.loadData(this)
    }
}