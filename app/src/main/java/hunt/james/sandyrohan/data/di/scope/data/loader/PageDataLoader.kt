package hunt.james.sandyrohan.data.di.scope.data.loader

import hunt.james.sandyrohan.data.di.scope.page.PageModel

/**
 * Created by James on 7/11/2017.
 */
interface PageDataLoader {
    fun loadData(pageModel: PageModel)
}