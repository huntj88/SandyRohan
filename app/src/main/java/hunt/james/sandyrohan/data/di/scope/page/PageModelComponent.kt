package hunt.james.sandyrohan.data.di.scope.page

import dagger.Component
import hunt.james.sandyrohan.data.di.scope.app.AppComponent
import hunt.james.sandyrohan.view.pages.ItemPage
import hunt.james.sandyrohan.view.pages.SearchPage
import hunt.james.sandyrohan.view.pages.TestPage

/**
 * Created by James on 7/10/2017.
 */

@PageScope
@Component(modules = arrayOf(PageModelModule::class), dependencies = arrayOf(AppComponent::class))
interface PageModelComponent {
    fun inject(itemPage: ItemPage)
    fun inject(testPage: TestPage)
    fun inject(searchPage: SearchPage)
}