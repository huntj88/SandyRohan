package hunt.james.sandyrohan.data.di.scope.app

import dagger.Component
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.di.scope.app.network.NetworkClientModule
import hunt.james.sandyrohan.data.di.scope.data.loader.ItemPageDataLoader
import hunt.james.sandyrohan.view.pages.util.PageAdapter
import javax.inject.Singleton

/**
 * Created by James on 7/10/2017.
 */

@Singleton
@Component(modules = arrayOf(PageBuilderModule::class, NetworkClientModule::class, AppModule::class))
interface AppComponent {
    fun pageModelBuilder(): PageModelBuilder
    fun inject(sandyRohanApplication: SandyRohanApplication)
    fun inject(pageAdapter: PageAdapter)
    fun inject(itemPageDataLoader: ItemPageDataLoader)
}