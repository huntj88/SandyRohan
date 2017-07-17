package hunt.james.sandyrohan.data.di.scope.data.loader

import hunt.james.sandyrohan.data.SearchPageModel
import hunt.james.sandyrohan.data.di.scope.data.models.ItemSmall
import hunt.james.sandyrohan.data.di.scope.page.PageModel
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by James on 7/16/2017.
 */

/**
 * Created by James on 7/13/2017.
 */
class SearchPageDataLoader: PageDataLoader {

    override fun loadData(pageModel: PageModel) {

        val searchPageModel: SearchPageModel = pageModel as SearchPageModel

        if(searchPageModel.mSearchString.isNotEmpty()) {
            val realm: Realm = Realm.getDefaultInstance()
            val results: RealmResults<ItemSmall> = realm.where(ItemSmall::class.java).contains("name", searchPageModel.mSearchString).findAllAsync()
            results.addChangeListener {
                changed ->
                var max: Int = 200

                if(max > changed.size) {
                    max = changed.size
                }

                searchPageModel.mResults = ArrayList(realm.copyFromRealm(changed.subList(0,max)))
                realm.close()
                searchPageModel.dataFinishedBinding()
            }
        }
    }


}