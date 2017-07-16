package hunt.james.sandyrohan.data.di.scope.data.loader

import android.content.Context
import android.util.Log
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.TestPageModel
import hunt.james.sandyrohan.data.di.scope.app.network.UnofficialGWService
import hunt.james.sandyrohan.data.di.scope.data.loader.models.Item
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject
import android.content.Context.MODE_PRIVATE
import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import java.io.*
import android.media.MediaScannerConnection
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall


/**
 * Created by James on 7/11/2017.
 */
class ItemPageDataLoader: PageDataLoader {

    @Inject
    lateinit var service: UnofficialGWService

    @Inject
    lateinit var context: Context

    lateinit var disposable: Disposable

    override fun loadData(pageModel: PageModel) {

        SandyRohanApplication.di.component.inject(this)

        val itemPageModel: ItemPageModel = pageModel as ItemPageModel

        if(itemPageModel.mPreviousPageModel!=null) {

            itemPageModel.itemName = (itemPageModel.mPreviousPageModel as TestPageModel).itemName

            getItem(itemPageModel)

        }
    }

    fun getItem(itemPageModel: ItemPageModel) {

        val realm: Realm = Realm.getDefaultInstance()

        val item: Item? = realm.where(Item::class.java).equalTo("dataID",19703).findFirst()

        if(item != null && !item.isExpired()) {
            Log.d("load","used cache")
            itemPageModel.itemName = item.name!!
            itemPageModel.dataFinishedBinding()
        } else {
            Log.d("load","used network")
            getItemFromNetwork(itemPageModel)
        }

    }

    fun getItemFromNetwork(itemPageModel: ItemPageModel) {
        disposable = service.getSpecificItem(19703).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->

                    Log.d("result",result.toString())
                    if(result.result!=null) {
                        val item: Item = result.result as Item

                        val realm: Realm = Realm.getDefaultInstance()
                        realm.executeTransaction {
                            realm.insertOrUpdate(item)

                        }

                        itemPageModel.itemName = item.name!!

                        disposable.dispose()
                        itemPageModel.dataFinishedBinding()
                    }
                }, { error ->
                    disposable.dispose()
                    error.printStackTrace()
                })
    }
}