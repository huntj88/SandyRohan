package hunt.james.sandyrohan.data.di.scope.data.loader

import hunt.james.sandyrohan.data.TestPageModel
import hunt.james.sandyrohan.data.di.scope.page.PageModel

/**
 * Created by James on 7/13/2017.
 */
class TestPageDataLoader: PageDataLoader {

    override fun loadData(pageModel: PageModel) {

        val testPageModel: TestPageModel = pageModel as TestPageModel
        testPageModel.itemName = "silver thing"


        if(testPageModel.mPreviousPageModel!=null) {
            //TODO: load the data here and put into the model
        }

        testPageModel.dataFinishedBinding()
    }
}