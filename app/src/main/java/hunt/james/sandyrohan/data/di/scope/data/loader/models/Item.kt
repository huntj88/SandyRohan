package hunt.james.sandyrohan.data.di.scope.data.loader.models

/**
 * Created by James on 7/14/2017.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {

    @SerializedName("data_id")
    @Expose
    var dataId: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("rarity")
    @Expose
    var rarity: Int? = null

    @SerializedName("restriction_level")
    @Expose
    var restrictionLevel: Int? = null

    @SerializedName("img")
    @Expose
    var img: String? = null

    @SerializedName("type_id")
    @Expose
    var typeId: Int? = null

    @SerializedName("sub_type_id")
    @Expose
    var subTypeId: Int? = null

    @SerializedName("price_last_changed")
    @Expose
    var priceLastChanged: String? = null

    @SerializedName("max_offer_unit_price")
    @Expose
    var maxOfferUnitPrice: Int? = null

    @SerializedName("min_sale_unit_price")
    @Expose
    var minSaleUnitPrice: Int? = null

    @SerializedName("offer_availability")
    @Expose
    var offerAvailability: Int? = null

    @SerializedName("sale_availability")
    @Expose
    var saleAvailability: Int? = null

    @SerializedName("sale_price_change_last_hour")
    @Expose
    var salePriceChangeLastHour: Int? = null

    @SerializedName("offer_price_change_last_hour")
    @Expose
    var offerPriceChangeLastHour: Int? = null

}