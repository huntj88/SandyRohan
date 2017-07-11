package hunt.james.sandyrohan.data.di.scope.app

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by James on 7/10/2017.
 */

@Module
class PageBuilderModule {

    @Provides
    @Singleton
    fun providePageBuilder(): PageModelBuilder {
        return PageModelBuilder()
    }
}