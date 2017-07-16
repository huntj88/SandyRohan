package hunt.james.sandyrohan.view.recycle.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import hunt.james.sandyrohan.data.di.scope.data.loader.models.ItemSmall
import hunt.james.sandyrohan.view.pages.util.PageRequired
import hunt.james.sandyrohan.view.recycle.ViewHolderRequired
import hunt.james.sandyrohan.view.recycle.ViewHolderData
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.view_holder_search.view.*
import java.util.concurrent.TimeUnit

/**
 * Created by James on 7/16/2017.
 */
class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), ViewHolderRequired {

    val name: TextView = itemView.item_name

    override fun bindData(viewHolderData: ViewHolderData, callBack: PageRequired.CallBack) {

        val itemSmall: ItemSmall = viewHolderData as ItemSmall
        name.text = itemSmall.name

        RxView.clicks(itemView)
                .throttleFirst(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({callBack.handleCallBack(viewHolderData)})
    }
}