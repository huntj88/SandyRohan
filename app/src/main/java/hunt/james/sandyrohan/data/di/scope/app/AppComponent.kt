package hunt.james.sandyrohan.data.di.scope.app

import dagger.Component
import hunt.james.sandyrohan.SandyRohanApplication
import javax.inject.Singleton

/**
 * Created by James on 7/10/2017.
 */

@Singleton
@Component(modules= arrayOf(PageBuilderModule::class))
interface AppComponent {
    fun pageModelBuilder(): PageModelBuilder
    fun inject(sandyRohanApplication: SandyRohanApplication)
}