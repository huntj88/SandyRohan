package hunt.james.sandyrohan.view.recycle

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by James on 7/16/2017.
 */
interface ViewHolderEnumUtils {
    fun makeView(parent: ViewGroup): RecyclerView.ViewHolder
}