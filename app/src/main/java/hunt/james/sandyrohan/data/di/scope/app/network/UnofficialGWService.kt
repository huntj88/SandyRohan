package hunt.james.sandyrohan.data.di.scope.app.network

import hunt.james.sandyrohan.data.di.scope.data.loader.models.Items
import io.reactivex.Observable
import retrofit2.http.GET



/**
 * Created by James on 7/14/2017.
 */
interface UnofficialGWService {

    @GET("/api/v0.9/json/all-items/all")
    fun getAllItems(): Observable<Items>
}