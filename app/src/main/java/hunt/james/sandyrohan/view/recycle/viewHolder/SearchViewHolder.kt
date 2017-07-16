package hunt.james.sandyrohan.view.recycle.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall
import hunt.james.sandyrohan.view.pages.util.ViewHolderRequired
import hunt.james.sandyrohan.view.recycle.ViewHolderData
import kotlinx.android.synthetic.main.view_holder_search.view.*

/**
 * Created by James on 7/16/2017.
 */
class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), ViewHolderRequired {

    val name: TextView = itemView.item_name

    override fun bindData(viewHolderData: ViewHolderData) {

        val itemSmall: ItemSmall = viewHolderData as ItemSmall
        name.text = itemSmall.name
    }
}