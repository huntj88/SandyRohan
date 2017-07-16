package hunt.james.sandyrohan.data.di.scope.data.loader.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by James on 7/16/2017.
 */

class SingleItem {

    @SerializedName("result")
    @Expose
    var result: Item? = null

}