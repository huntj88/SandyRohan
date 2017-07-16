package hunt.james.sandyrohan.data.di.scope.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by James on 7/15/2017.
 */

@Module
class AppModule(context: Context) {

    var mContent: Context = context

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return (mContent)
    }
}