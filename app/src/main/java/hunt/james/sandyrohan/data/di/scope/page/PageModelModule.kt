package hunt.james.sandyrohan.data.di.scope.page

import dagger.Module
import dagger.Provides
import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder

/**
 * Created by James on 7/10/2017.
 */

@Module
class PageModelModule {

    @PageScope
    @Provides
    fun providePageModel(pageModelBuilder: PageModelBuilder): ItemPageModel {
        //pageModelBuilder.test()
        return ItemPageModel(pageModelBuilder)
    }

}