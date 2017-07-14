package hunt.james.sandyrohan.data.di.scope.app

import dagger.Component
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.di.scope.app.network.NetworkClientModule
import hunt.james.sandyrohan.data.di.scope.data.loader.ItemPageDataLoader
import javax.inject.Singleton

/**
 * Created by James on 7/10/2017.
 */

@Singleton
@Component(modules = arrayOf(PageBuilderModule::class, NetworkClientModule::class))
interface AppComponent {
    fun pageModelBuilder(): PageModelBuilder
    fun inject(sandyRohanApplication: SandyRohanApplication)
    fun inject(itemPageDataLoader: ItemPageDataLoader)
}