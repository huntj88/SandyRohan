package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import hunt.james.sandyrohan.data.di.scope.data.loader.ItemPageDataLoader
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import hunt.james.sandyrohan.view.pages.util.PageID

/**
 * Created by James on 7/10/2017.
 */
class ItemPageModel(pageModelBuilder: PageModelBuilder): PageModel {
    override var previousPageModel: PageModel? = null //TODO: make this not null. only first page should be null, but its null right now because im using it to test
    override var pageID: PageID = PageID.ITEM

    lateinit var itemName: String

    init {
        pageModelBuilder.buildModel(this, ItemPageDataLoader())
    }

    override fun dataFinishedBinding() {
        //TODO: implement this method
        // To change body of created functions use File | Settings | File Templates.
    }
}