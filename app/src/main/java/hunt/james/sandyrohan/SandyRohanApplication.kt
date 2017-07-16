package hunt.james.sandyrohan

import android.app.Application
import hunt.james.sandyrohan.data.di.scope.app.*
import hunt.james.sandyrohan.data.di.scope.app.network.NetworkClientModule
import io.realm.Realm

/**
 * Created by James on 7/10/2017.
 */
class SandyRohanApplication : Application() {

    object di {
        lateinit var component: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        SandyRohanApplication.di.component = DaggerAppComponent
                .builder()
                .pageBuilderModule(PageBuilderModule())
                .networkClientModule(NetworkClientModule())
                .build()

        SandyRohanApplication.di.component.inject(this)
    }


}