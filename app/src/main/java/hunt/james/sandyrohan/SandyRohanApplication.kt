package hunt.james.sandyrohan

import android.app.Application
import android.util.Log
import hunt.james.sandyrohan.data.di.scope.app.*
import hunt.james.sandyrohan.data.di.scope.app.network.NetworkClientModule
import hunt.james.sandyrohan.data.di.scope.app.network.UnofficialGWService
import hunt.james.sandyrohan.data.di.scope.data.loader.models.Item
import hunt.james.sandyrohan.view.GetAllData
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

/**
 * Created by James on 7/10/2017.
 */
class SandyRohanApplication : Application() {

    object di {
        lateinit var component: AppComponent
    }


    @Inject
    lateinit var service: UnofficialGWService


    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        SandyRohanApplication.di.component = DaggerAppComponent
                .builder()
                .pageBuilderModule(PageBuilderModule())
                .networkClientModule(NetworkClientModule())
                .appModule(AppModule(applicationContext))
                .build()

        SandyRohanApplication.di.component.inject(this)

        //getAllData()
        deleteBigItems()

    }

    fun deleteBigItems() {
        val realm: Realm = Realm.getDefaultInstance()

        val items: RealmResults<Item> = realm.where(Item::class.java).findAll()

        Log.d("items",items.size.toString())

        realm.executeTransaction {
            items.deleteAllFromRealm()
        }

        Log.d("items",items.size.toString())

        realm.close()
    }

    fun getAllData() {
        Realm.deleteRealm(Realm.getDefaultConfiguration())
        val data: GetAllData = GetAllData(service)
        data.getAllItems()
    }

}