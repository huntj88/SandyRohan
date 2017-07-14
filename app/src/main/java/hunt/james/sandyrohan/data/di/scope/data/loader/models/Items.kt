package hunt.james.sandyrohan.data.di.scope.data.loader.models

/**
 * Created by James on 7/14/2017.
 */


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Items {

    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Item>? = null

}