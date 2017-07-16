package hunt.james.sandyrohan.view.recycle

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import hunt.james.sandyrohan.R
import hunt.james.sandyrohan.view.recycle.viewHolder.SearchViewHolder


/**
 * Created by James on 7/16/2017.
 */
enum class ViewHolderEnum(val viewHolderID: Int): ViewHolderEnumUtils {

    SEARCH_VIEW(0) {
        override fun makeView(parent: ViewGroup): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return SearchViewHolder(inflater.inflate(R.layout.view_holder_search, parent, false))
        }
    };

    companion object {
        private val map = ViewHolderEnum.values().associateBy(ViewHolderEnum::viewHolderID)
        fun fromInt(type: Int) = map[type]
    }
}