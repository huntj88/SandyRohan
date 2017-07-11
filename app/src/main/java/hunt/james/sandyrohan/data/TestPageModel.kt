package hunt.james.sandyrohan.data

import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import hunt.james.sandyrohan.view.pages.util.PageID

/**
 * Created by James on 7/9/2017.
 */
class TestPageModel: PageModel {

    override var previousPageModel: PageModel? = null
    override var pageID: PageID = PageID.TEST


    override fun dataFinishedBinding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}