package hunt.james.sandyrohan.toolbar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import hunt.james.sandyrohan.R

/**
 * Created by James on 7/9/2017.
 */
class SearchToolbar: ToolbarRequired {
    override lateinit var mViewGroup: ViewGroup


    override fun bindLayout(context: Context) {
        val layout = LayoutInflater.from(context).inflate(R.layout.toolbar_search, null, false)
        mViewGroup = layout as ViewGroup
    }
}