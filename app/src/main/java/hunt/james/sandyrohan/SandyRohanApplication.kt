package hunt.james.sandyrohan

import android.app.Application
import hunt.james.sandyrohan.data.di.scope.app.AppComponent
import hunt.james.sandyrohan.data.di.scope.app.DaggerAppComponent
import hunt.james.sandyrohan.data.di.scope.app.PageBuilderModule
import hunt.james.sandyrohan.data.di.scope.app.PageModelBuilder
import javax.inject.Inject

/**
 * Created by James on 7/10/2017.
 */
class SandyRohanApplication: Application() {

    object di {
        lateinit var component: AppComponent
    }


    override fun onCreate() {
        super.onCreate()

       SandyRohanApplication.di.component = DaggerAppComponent
                .builder()
                .pageBuilderModule(PageBuilderModule())
                .build()

        SandyRohanApplication.di.component.inject(this)
    }


}