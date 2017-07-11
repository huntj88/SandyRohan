package hunt.james.sandyrohan.data.di.scope.data.loader

import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.di.scope.page.PageModel

/**
 * Created by James on 7/11/2017.
 */
class ItemPageDataLoader: PageDataLoader {

    override fun loadData(pageModel: PageModel) {

        val itemPageModel: ItemPageModel = pageModel as ItemPageModel
        itemPageModel.itemName = "silver thing"
        itemPageModel.dataFinishedBinding()

        //todo: use pageModel.previousModel to get the query info
    }
}