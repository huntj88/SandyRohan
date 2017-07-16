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



            itemPageModel.dataFinishedBinding()
            //getAllItems(itemPageModel)
            //removeBadItems()
            //test()
            //createRealmBackup()
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


                        val realm: Realm = Realm.getDefaultInstance()
                        realm.executeTransaction {

                            realm.insertOrUpdate(items)

                        }

                        disposable.dispose()
                        itemPageModel.dataFinishedBinding()
                    }
                }, { error ->
                    disposable.dispose()
                    error.printStackTrace()
                })

    }

    fun removeBadItems() {


        val realm: Realm = Realm.getDefaultInstance()
        val bad: RealmResults<Item> = realm.where(Item::class.java).equalTo("maxOfferUnitPrice",0).or().equalTo("minSaleUnitPrice",0).findAll()
        Log.d("removed",bad.count().toString())

        realm.executeTransaction {
            bad.deleteAllFromRealm()
        }
        realm.close()
    }

    fun test() {
        val realm: Realm = Realm.getDefaultInstance()
        realm.close()

        Log.d("realm path",realm.path)

    }


    fun createRealmBackup() {
        // Create a path where we will place our picture in the user's
        // public pictures directory.  Note that you should be careful about
        // what you place here, since the user often manages these files.  For
        // pictures and other media owned by the application, consider
        // Context.getExternalMediaDir().
        val path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES)
        val file = File(path, "backup.realm")


        val realmFile = File(context.filesDir.path,"default.realm")

        try {
            // Make sure the Pictures directory exists.
            path.mkdirs()
            val fileInputStream = FileInputStream(realmFile)
            val fileOutputStream = FileOutputStream(
                    file)


            val buffer = ByteArray(512)
            var bufferSize: Int = fileInputStream.read(buffer)
            while (bufferSize > 0) {
                fileOutputStream.write(buffer, 0, bufferSize)
                bufferSize = fileInputStream.read(buffer)
            }
            fileInputStream.close()
            fileOutputStream.close()


        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }

    }
}