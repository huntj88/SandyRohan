package hunt.james.sandyrohan.data.di.scope.app.network

import hunt.james.sandyrohan.data.di.scope.data.models.ManyItems
import hunt.james.sandyrohan.data.di.scope.data.models.SingleItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by James on 7/14/2017.
 */
interface UnofficialGWService {

    @GET("/api/v0.9/json/all-items/all")
    fun getAllItems(): Observable<ManyItems>

    @GET("/api/v0.9/json/item/{dataID}")
    fun getSpecificItem(@Path(value = "dataID") dataID: Int): Observable<SingleItem>
}