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

    lateinit var component: AppComponent

    @Inject
    lateinit var pageModelBuilder: PageModelBuilder


    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
                .builder()
                .pageBuilderModule(PageBuilderModule())
                .build()

        component.inject(this)

        pageModelBuilder.test()
    }


}