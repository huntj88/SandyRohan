package hunt.james.sandyrohan.data.di.scope.app

import android.util.Log
import hunt.james.sandyrohan.data.di.scope.data.loader.PageDataLoader
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import java.util.*

/**
 * Created by James on 7/9/2017.
 */
class PageModelBuilder {

    var modelStack: Stack<PageModel> = Stack()

    fun buildModel(pageModel: PageModel, pageDataLoader: PageDataLoader) {
        modelStack.push(pageModel)
        pageDataLoader.loadData(pageModel)
    }

    fun test() {
        Log.d("blH","FRFDFD")
    }
}