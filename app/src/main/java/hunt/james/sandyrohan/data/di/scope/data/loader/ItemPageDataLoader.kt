package hunt.james.sandyrohan.data.di.scope.data.loader

import android.content.Context
import android.util.Log
import hunt.james.sandyrohan.SandyRohanApplication
import hunt.james.sandyrohan.data.ItemPageModel
import hunt.james.sandyrohan.data.di.scope.app.network.UnofficialGWService
import hunt.james.sandyrohan.data.di.scope.data.loader.models.Item
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import javax.inject.Inject
import hunt.james.sandyrohan.data.SearchPageModel


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

            itemPageModel.itemName = (itemPageModel.mPreviousPageModel as SearchPageModel).selectedItem.name!!

            getItem(itemPageModel)

        }
    }

    fun getItem(itemPageModel: ItemPageModel) {

        val realm: Realm = Realm.getDefaultInstance()

        val dataID = (itemPageModel.mPreviousPageModel  as SearchPageModel).selectedItem.dataID

        val item: Item? = realm.where(Item::class.java).equalTo("dataID",dataID).findFirst()

        if(item != null && !item.isExpired()) {
            Log.d("load","used cache")
            itemPageModel.itemName = item.name!!
            itemPageModel.dataFinishedBinding()
        } else {
            Log.d("load","used network")
            getItemFromNetwork(itemPageModel, dataID!!)
        }

    }

    fun getItemFromNetwork(itemPageModel: ItemPageModel, dataID: Int) {
        disposable = service.getSpecificItem(dataID).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
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