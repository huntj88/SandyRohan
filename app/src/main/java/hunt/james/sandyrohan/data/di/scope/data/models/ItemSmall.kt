package hunt.james.sandyrohan.data.di.scope.data.models

import hunt.james.sandyrohan.view.recycle.ViewHolderData
import hunt.james.sandyrohan.view.recycle.ViewHolderEnum
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

/**
 * Created by James on 7/16/2017.
 */
open class ItemSmall : RealmObject(), ViewHolderData {

    open var dataID: Int? = null

    @PrimaryKey
    open var nameLowerCase: String? = null

    open var name: String? = null

    open var img: String? = null

    @Ignore
    override var type: ViewHolderEnum = ViewHolderEnum.SEARCH_VIEW
}