package hunt.james.sandyrohan.view

import android.util.Log
import hunt.james.sandyrohan.data.di.scope.app.network.UnofficialGWService
import hunt.james.sandyrohan.data.di.scope.data.loader.models.Item
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by James on 7/16/2017.
 */

class GetAllData(service: UnofficialGWService) {

    var mService = service

    lateinit var disposable: Disposable

    fun getAllItems() {
        disposable = mService.getAllItems().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->

                    Log.d("result",result.toString())
                    if(result.results!=null) {
                        val items: List<Item> = result.results as List<Item>


                        val realm: Realm = Realm.getDefaultInstance()
                        realm.executeTransaction {
                            realm.insertOrUpdate(items)

                        }

                        disposable.dispose()
                        Log.d("realm stuff","got items")

                        removeBadItems()
                        Log.d("realm stuff","removed bad")

                        makeSmaller()
                        Log.d("realm stuff","made smaller")
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


    fun makeSmaller() {
        val realm: Realm = Realm.getDefaultInstance()
        val big: RealmResults<Item> = realm.where(Item::class.java).findAll()

        realm.executeTransaction {
            for(item in big) {
                val itemSmall: ItemSmall = ItemSmall()
                itemSmall.dataID = item.dataID
                itemSmall.name = item.name!!.toLowerCase()
                itemSmall.img = item.img

                realm.insertOrUpdate(itemSmall)
            }
        }

        realm.close()
    }


    /*fun createRealmBackup() {
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

    }*/
}