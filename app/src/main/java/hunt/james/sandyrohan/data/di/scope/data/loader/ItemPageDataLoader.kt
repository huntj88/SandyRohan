package hunt.james.sandyrohan.data.di.scope.data.loader

import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.TestPageModel
import hunt.james.sandyrohan.data.di.scope.page.PageModel

/**
 * Created by James on 7/11/2017.
 */
class ItemPageDataLoader: PageDataLoader {

    override fun loadData(pageModel: PageModel) {

        val itemPageModel: ItemPageModel = pageModel as ItemPageModel

        if(itemPageModel.mPreviousPageModel!=null) {

            itemPageModel.itemName = (itemPageModel.mPreviousPageModel as TestPageModel).itemName
        }

        itemPageModel.dataFinishedBinding()
    }
}