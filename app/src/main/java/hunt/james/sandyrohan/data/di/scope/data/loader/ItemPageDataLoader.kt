package hunt.james.sandyrohan.data.di.scope.data.loader

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
import javax.inject.Inject

/**
 * Created by James on 7/11/2017.
 */
class ItemPageDataLoader: PageDataLoader {

    @Inject
    lateinit var service: UnofficialGWService
    lateinit var disposable: Disposable

    override fun loadData(pageModel: PageModel) {

        SandyRohanApplication.di.component.inject(this)

        val itemPageModel: ItemPageModel = pageModel as ItemPageModel

        if(itemPageModel.mPreviousPageModel!=null) {

            itemPageModel.itemName = (itemPageModel.mPreviousPageModel as TestPageModel).itemName

            itemPageModel.dataFinishedBinding()
            //getAllItems(itemPageModel)
        }

        //itemPageModel.dataFinishedBinding()
    }

    fun getAllItems(itemPageModel: ItemPageModel) {
        disposable = service.getAllItems().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->

                    Log.d("result",result.toString())
                    if(result.results!=null) {
                        val items: List<Item> = result.results as List<Item>
                        Log.d("Result", "There are ${items[0].name} Java developers in Lagos")
                        disposable.dispose()
                        itemPageModel.dataFinishedBinding()
                    }
                }, { error ->
                    disposable.dispose()
                    error.printStackTrace()
                })

    }
}