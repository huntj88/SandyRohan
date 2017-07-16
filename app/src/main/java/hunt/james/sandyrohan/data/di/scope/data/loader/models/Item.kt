package hunt.james.sandyrohan.data.di.scope.data.loader.models

/**
 * Created by James on 7/14/2017.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class Item: RealmObject() {

    @PrimaryKey
    @SerializedName("data_id")
    @Expose
    open var dataID: Int? = null

    @Index
    @SerializedName("name")
    @Expose
    open var name: String? = null

    @SerializedName("rarity")
    @Expose
    open var rarity: Int? = null

    @SerializedName("restriction_level")
    @Expose
    open var restrictionLevel: Int? = null

    @SerializedName("img")
    @Expose
    open var img: String? = null

    @SerializedName("type_id")
    @Expose
    open var typeId: Int? = null

    @SerializedName("sub_type_id")
    @Expose
    open var subTypeId: Int? = null

    @SerializedName("price_last_changed")
    @Expose
    open var priceLastChanged: String? = null

    @Index
    @SerializedName("max_offer_unit_price")
    @Expose
    open var maxOfferUnitPrice: Int? = null

    @Index
    @SerializedName("min_sale_unit_price")
    @Expose
    open var minSaleUnitPrice: Int? = null

    @SerializedName("offer_availability")
    @Expose
    open var offerAvailability: Int? = null

    @SerializedName("sale_availability")
    @Expose
    open var saleAvailability: Int? = null

    @SerializedName("sale_price_change_last_hour")
    @Expose
    open var salePriceChangeLastHour: Int? = null

    @SerializedName("offer_price_change_last_hour")
    @Expose
    open var offerPriceChangeLastHour: Int? = null

}